using System.Data;
using System.Data.OleDb;
using System.Runtime.InteropServices;

namespace UniversityRegistration
{
    public partial class MainForm : Form
    {
        private OleDbConnection databaseConnection;
        private Dictionary<string, TextBox> inputFields;
        private int? selectedId = null;

        public MainForm()
        {
            InitializeComponent();
            SetupEventHandlers();
            InitializeFields();
            DisableControls();
        }

        private void InitializeFields()
        {
            // Store references to all input fields
            inputFields = new Dictionary<string, TextBox>
            {
                ["FirstName"] = (TextBox)sidePanel.Controls["txtFirstName"],
                ["LastName"] = (TextBox)sidePanel.Controls["txtLastName"],
                ["PhoneNumber"] = (TextBox)sidePanel.Controls["txtPhoneNumber"],
                ["NationalCode"] = (TextBox)sidePanel.Controls["txtNationalCode"],
                ["Address"] = (TextBox)sidePanel.Controls["txtAddress"]
            };

            // Add validation for numeric fields
            inputFields["PhoneNumber"].KeyPress += NumericOnly_KeyPress;
            inputFields["NationalCode"].KeyPress += NumericOnly_KeyPress;
        }

        private void SetupEventHandlers()
        {
            // Button click handlers
            ((Button)sidePanel.Controls["btnConnect"]).Click += BtnConnect_Click;
            ((Button)sidePanel.Controls["btnAdd"]).Click += BtnAdd_Click;
            ((Button)sidePanel.Controls["btnUpdate"]).Click += BtnUpdate_Click;
            ((Button)sidePanel.Controls["btnDelete"]).Click += BtnDelete_Click;

            // DataGridView selection handler
            dataGridView1.SelectionChanged += DataGridView1_SelectionChanged;
        }

        private void DisableControls()
        {
            foreach (var textBox in inputFields.Values)
                textBox.Enabled = false;

            foreach (var btn in new[] { "btnAdd", "btnUpdate", "btnDelete" })
                ((Button)sidePanel.Controls[btn]).Enabled = false;
        }

        private void EnableControls()
        {
            foreach (var textBox in inputFields.Values)
                textBox.Enabled = true;

            foreach (var btn in new[] { "btnAdd", "btnUpdate", "btnDelete" })
                ((Button)sidePanel.Controls[btn]).Enabled = true;
        }

        private async void BtnConnect_Click(object sender, EventArgs e)
        {
            using (OpenFileDialog dialog = new OpenFileDialog())
            {
                dialog.Filter = "Access Database|*.accdb";
                if (dialog.ShowDialog() == DialogResult.OK)
                {
                    try
                    {
                        databaseConnection?.Close();
                        databaseConnection = new OleDbConnection($"Provider=Microsoft.ACE.OLEDB.12.0;Data Source={dialog.FileName}");
                        await databaseConnection.OpenAsync();
                        await RefreshDataGrid();
                        EnableControls();
                        ShowStatus("Connected to database successfully");
                    }
                    catch (Exception ex)
                    {
                        ShowStatus($"Error connecting to database: {ex.Message}", true);
                    }
                }
            }
        }

        private async void BtnAdd_Click(object sender, EventArgs e)
        {
            if (!ValidateInputs()) return;

            try
            {
                using (OleDbCommand cmd = new OleDbCommand(
                    "INSERT INTO Students (FirstName, LastName, PhoneNumber, NationalCode, Address) " +
                    "VALUES (@FirstName, @LastName, @PhoneNumber, @NationalCode, @Address)", databaseConnection))
                {
                    foreach (var field in inputFields)
                        cmd.Parameters.AddWithValue($"@{field.Key}", field.Value.Text);

                    await cmd.ExecuteNonQueryAsync();
                    await RefreshDataGrid();
                    ClearInputs();
                    ShowStatus("Record added successfully");
                }
            }
            catch (Exception ex)
            {
                ShowStatus($"Error adding record: {ex.Message}", true);
            }
        }

        private async void BtnUpdate_Click(object sender, EventArgs e)
        {
            if (!selectedId.HasValue || !ValidateInputs()) return;

            try
            {
                using (OleDbCommand cmd = new OleDbCommand(
                    "UPDATE Students SET FirstName=@FirstName, LastName=@LastName, " +
                    "PhoneNumber=@PhoneNumber, NationalCode=@NationalCode, Address=@Address " +
                    "WHERE ID=@ID", databaseConnection))
                {
                    foreach (var field in inputFields)
                        cmd.Parameters.AddWithValue($"@{field.Key}", field.Value.Text);
                    cmd.Parameters.AddWithValue("@ID", selectedId.Value);

                    await cmd.ExecuteNonQueryAsync();
                    await RefreshDataGrid();
                    ClearInputs();
                    ShowStatus("Record updated successfully");
                }
            }
            catch (Exception ex)
            {
                ShowStatus($"Error updating record: {ex.Message}", true);
            }
        }

        private async void BtnDelete_Click(object sender, EventArgs e)
        {
            if (!selectedId.HasValue) return;

            if (MessageBox.Show("Are you sure you want to delete this record?", "Confirm Delete",
                MessageBoxButtons.YesNo, MessageBoxIcon.Warning) == DialogResult.Yes)
            {
                try
                {
                    using (OleDbCommand cmd = new OleDbCommand(
                        "DELETE FROM Students WHERE ID=@ID", databaseConnection))
                    {
                        cmd.Parameters.AddWithValue("@ID", selectedId.Value);
                        await cmd.ExecuteNonQueryAsync();
                        await RefreshDataGrid();
                        ClearInputs();
                        ShowStatus("Record deleted successfully");
                    }
                }
                catch (Exception ex)
                {
                    ShowStatus($"Error deleting record: {ex.Message}", true);
                }
            }
        }

        private void DataGridView1_SelectionChanged(object sender, EventArgs e)
        {
            if (dataGridView1.CurrentRow?.Index >= 0)
            {
                selectedId = Convert.ToInt32(dataGridView1.CurrentRow.Cells["ID"].Value);
                foreach (var field in inputFields)
                {
                    field.Value.Text = dataGridView1.CurrentRow.Cells[field.Key].Value.ToString();
                }
            }
        }

        private async Task RefreshDataGrid()
        {
            try
            {
                using (OleDbCommand cmd = new OleDbCommand("SELECT * FROM Students", databaseConnection))
                using (OleDbDataAdapter adapter = new OleDbDataAdapter(cmd))
                {
                    DataTable dt = new DataTable();
                    await Task.Run(() => adapter.Fill(dt));
                    dataGridView1.DataSource = dt;
                }
            }
            catch (Exception ex)
            {
                ShowStatus($"Error refreshing data: {ex.Message}", true);
            }
        }

        private void ShowStatus(string message, bool isError = false)
        {
            statusLabel.ForeColor = isError ? Color.FromArgb(255, 65, 65) : Color.FromArgb(75, 181, 67);
            statusLabel.Text = message;

            Task.Delay(3000).ContinueWith(t =>
            {
                if (IsDisposed) return;
                this.Invoke(() => statusLabel.Text = "");
            });
        }

        private void NumericOnly_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar))
                e.Handled = true;
        }

        private bool ValidateInputs()
        {
            foreach (var field in inputFields)
            {
                if (string.IsNullOrWhiteSpace(field.Value.Text))
                {
                    ShowStatus($"{field.Key} is required", true);
                    field.Value.Focus();
                    return false;
                }
            }
            return true;
        }

        private void ClearInputs()
        {
            foreach (var textBox in inputFields.Values)
                textBox.Clear();
            selectedId = null;
        }
    }
}