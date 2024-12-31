namespace UniversityRegistration
{
    partial class MainForm
    {
        private System.ComponentModel.IContainer components = null;
        private StatusStrip statusStrip;
        private ToolStripStatusLabel statusLabel;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            
            // Initialize main components
            this.statusStrip = new StatusStrip();
            this.statusLabel = new ToolStripStatusLabel();
            this.mainPanel = new Panel();
            this.sidePanel = new Panel();
            this.dataPanel = new Panel();
            this.dataGridView1 = new DataGridView();
            
            // Form settings
            this.Size = new Size(1200, 800);
            this.StartPosition = FormStartPosition.CenterScreen;
            this.Text = "University Registration System";
            this.BackColor = Color.FromArgb(18, 18, 18);
            
            // Side Panel
            this.sidePanel.Size = new Size(300, Height - 40);
            this.sidePanel.Dock = DockStyle.Left;
            this.sidePanel.BackColor = Color.FromArgb(24, 24, 24);
            this.sidePanel.Padding = new Padding(15);
            
            // Data Panel
            this.dataPanel.Dock = DockStyle.Fill;
            this.dataPanel.BackColor = Color.FromArgb(18, 18, 18);
            this.dataPanel.Padding = new Padding(15);
            
            // DataGridView
            this.dataGridView1.Dock = DockStyle.Fill;
            this.dataGridView1.BackgroundColor = Color.FromArgb(18, 18, 18);
            this.dataGridView1.BorderStyle = BorderStyle.None;
            this.dataGridView1.CellBorderStyle = DataGridViewCellBorderStyle.SingleHorizontal;
            this.dataGridView1.GridColor = Color.FromArgb(40, 40, 40);
            this.dataGridView1.RowTemplate.Height = 40;
            this.dataGridView1.ColumnHeadersHeight = 45;
            this.dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            
            // Add controls
            InitializeInputControls();
            InitializeButtons();
            InitializeDataGridView();
            
            // Layout
            this.Controls.Add(dataPanel);
            this.Controls.Add(sidePanel);
            this.Controls.Add(statusStrip);
            
            // Status strip
            this.statusStrip.BackColor = Color.FromArgb(24, 24, 24);
            this.statusLabel.ForeColor = Color.White;
            this.statusStrip.Items.Add(statusLabel);
        }

        private void InitializeInputControls()
        {
            // Create input fields with modern styling
            var inputFields = new[]
            {
                new { Name = "FirstName", Label = "First Name" },
                new { Name = "LastName", Label = "Last Name" },
                new { Name = "PhoneNumber", Label = "Phone Number" },
                new { Name = "NationalCode", Label = "National Code" },
                new { Name = "Address", Label = "Address" }
            };

            int yOffset = 20;
            foreach (var field in inputFields)
            {
                var label = new Label
                {
                    Text = field.Label,
                    ForeColor = Color.FromArgb(200, 200, 200),
                    Font = new Font("Segoe UI", 9F),
                    Location = new Point(15, yOffset),
                    AutoSize = true
                };

                var textBox = new TextBox
                {
                    Name = $"txt{field.Name}",
                    Location = new Point(15, yOffset + 25),
                    Size = new Size(270, 30),
                    BackColor = Color.FromArgb(30, 30, 30),
                    ForeColor = Color.White,
                    BorderStyle = BorderStyle.None,
                    Font = new Font("Segoe UI", 10F)
                };

                sidePanel.Controls.Add(label);
                sidePanel.Controls.Add(textBox);
                yOffset += 70;
            }
        }

        private void InitializeButtons()
        {
            var buttons = new[]
            {
                new { Name = "btnAdd", Text = "Add New Record", Y = 400 },
                new { Name = "btnUpdate", Text = "Update Record", Y = 450 },
                new { Name = "btnDelete", Text = "Delete Record", Y = 500 },
                new { Name = "btnConnect", Text = "Connect Database", Y = 550 }
            };

            foreach (var btn in buttons)
            {
                var button = new Button
                {
                    Name = btn.Name,
                    Text = btn.Text,
                    Size = new Size(270, 40),
                    Location = new Point(15, btn.Y),
                    FlatStyle = FlatStyle.Flat,
                    BackColor = Color.FromArgb(0, 120, 212),
                    ForeColor = Color.White,
                    Font = new Font("Segoe UI", 10F, FontStyle.Regular),
                    Cursor = Cursors.Hand
                };

                button.FlatAppearance.BorderSize = 0;
                button.MouseEnter += (s, e) => button.BackColor = Color.FromArgb(0, 140, 240);
                button.MouseLeave += (s, e) => button.BackColor = Color.FromArgb(0, 120, 212);

                sidePanel.Controls.Add(button);
            }
        }

        private void InitializeDataGridView()
        {
            dataGridView1.DefaultCellStyle.BackColor = Color.FromArgb(18, 18, 18);
            dataGridView1.DefaultCellStyle.ForeColor = Color.White;
            dataGridView1.DefaultCellStyle.SelectionBackColor = Color.FromArgb(0, 120, 212);
            dataGridView1.DefaultCellStyle.SelectionForeColor = Color.White;
            dataGridView1.ColumnHeadersDefaultCellStyle.BackColor = Color.FromArgb(24, 24, 24);
            dataGridView1.ColumnHeadersDefaultCellStyle.ForeColor = Color.White;
            dataGridView1.ColumnHeadersDefaultCellStyle.Font = new Font("Segoe UI", 10F, FontStyle.Regular);
            dataGridView1.EnableHeadersVisualStyles = false;
            
            dataPanel.Controls.Add(dataGridView1);
        }

        // Designer variables
        private Panel mainPanel;
        private Panel sidePanel;
        private Panel dataPanel;
        private DataGridView dataGridView1;
    }
}