using System.Data;

namespace College_AdvancedPrograming_1
{
    public partial class Form1 : Form
    {
        private DataTable _dataTable = new DataTable();
        public Form1()
        {
            InitializeComponent();
            // Initialize the DataTable
            _dataTable.Columns.Add("Name", typeof(string));
            _dataTable.Columns.Add("Family", typeof(string));
            _dataTable.Columns.Add("Date", typeof(string));
            _dataTable.Columns.Add("Education", typeof(string));
            _dataTable.Columns.Add("Gender", typeof(string));
            _dataTable.Columns.Add("Address", typeof(string));

            // Bind the DataTable to the DataGridView
            dataGridView1.DataSource = _dataTable;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            LblTimer.Text = DateTime.Now.Hour.ToString() + ":" + DateTime.Now.Minute.ToString() + ":" + DateTime.Now.Second.ToString();
            Timer.Enabled = true;
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            LblTimer.Text = DateTime.Now.Hour.ToString()+":"+DateTime.Now.Minute.ToString()+":"+ DateTime.Now.Second.ToString();
        }

        private void BtnRegister_Click(object sender, EventArgs e)
        {
            if (TeboxName.Text == "" || TeboxFamily.Text == "" || TeboxAddress.Text == "" || (RbtnMale.Checked == false && RbtnFemale.Checked == false) || (CoboxEducation.SelectedIndex != 0 && CoboxEducation.SelectedIndex != 1 && CoboxEducation.SelectedIndex != 2) || TipickerDate.Text == "")
            {
                MessageBox.Show("You Can't Register With Empty Faild");
            }
            else {

                DataRow newRow = _dataTable.NewRow();

                if (RbtnMale.Checked == true)
                {

                    newRow["Name"] = TeboxName.Text;
                    newRow["Family"] = TeboxFamily.Text;
                    newRow["Date"] = TipickerDate.Text;
                    newRow["Education"] = CoboxEducation.Items[CoboxEducation.SelectedIndex].ToString();
                    newRow["Gender"] = "Male";
                    newRow["Address"] = TeboxAddress.Text;

                    _dataTable.Rows.Add(newRow);

                    dataGridView1.Refresh();
                }
                else if (RbtnFemale.Checked == true)
                {

                    // Add the text to the new row
                    newRow["Name"] = TeboxName.Text;
                    newRow["Family"] = TeboxFamily.Text;
                    newRow["Date"] = TipickerDate.Text;
                    newRow["Education"] = CoboxEducation.Items[CoboxEducation.SelectedIndex].ToString();
                    newRow["Gender"] = "Female";
                    newRow["Address"] = TeboxAddress.Text;

                    _dataTable.Rows.Add(newRow);

                    dataGridView1.Refresh();
                }

            }
        }
    }
}