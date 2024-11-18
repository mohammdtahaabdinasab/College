namespace College_AdvancedPrograming_1
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.CoboxEducation = new System.Windows.Forms.ComboBox();
            this.TipickerDate = new System.Windows.Forms.DateTimePicker();
            this.LblName = new System.Windows.Forms.Label();
            this.LblFamily = new System.Windows.Forms.Label();
            this.LblDate = new System.Windows.Forms.Label();
            this.LblEducation = new System.Windows.Forms.Label();
            this.LblGender = new System.Windows.Forms.Label();
            this.LblAddress = new System.Windows.Forms.Label();
            this.LblRegisterList = new System.Windows.Forms.Label();
            this.RbtnMale = new System.Windows.Forms.RadioButton();
            this.RbtnFemale = new System.Windows.Forms.RadioButton();
            this.Timer = new System.Windows.Forms.Timer(this.components);
            this.TeboxAddress = new System.Windows.Forms.TextBox();
            this.TeboxFamily = new System.Windows.Forms.TextBox();
            this.TeboxName = new System.Windows.Forms.TextBox();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.BtnRegister = new System.Windows.Forms.Button();
            this.LblTimer = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // CoboxEducation
            // 
            this.CoboxEducation.FormattingEnabled = true;
            this.CoboxEducation.Items.AddRange(new object[] {
            "Student",
            "Bachelor\'s",
            "Ph.D"});
            this.CoboxEducation.Location = new System.Drawing.Point(87, 227);
            this.CoboxEducation.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.CoboxEducation.Name = "CoboxEducation";
            this.CoboxEducation.Size = new System.Drawing.Size(212, 27);
            this.CoboxEducation.TabIndex = 0;
            // 
            // TipickerDate
            // 
            this.TipickerDate.Location = new System.Drawing.Point(88, 160);
            this.TipickerDate.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.TipickerDate.Name = "TipickerDate";
            this.TipickerDate.Size = new System.Drawing.Size(212, 26);
            this.TipickerDate.TabIndex = 1;
            // 
            // LblName
            // 
            this.LblName.AutoSize = true;
            this.LblName.Font = new System.Drawing.Font("Vazir", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.LblName.ForeColor = System.Drawing.Color.White;
            this.LblName.Location = new System.Drawing.Point(8, 25);
            this.LblName.Name = "LblName";
            this.LblName.Size = new System.Drawing.Size(46, 19);
            this.LblName.TabIndex = 2;
            this.LblName.Text = "Name :";
            // 
            // LblFamily
            // 
            this.LblFamily.AutoSize = true;
            this.LblFamily.Font = new System.Drawing.Font("Vazir", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.LblFamily.ForeColor = System.Drawing.Color.White;
            this.LblFamily.Location = new System.Drawing.Point(9, 90);
            this.LblFamily.Name = "LblFamily";
            this.LblFamily.Size = new System.Drawing.Size(51, 19);
            this.LblFamily.TabIndex = 3;
            this.LblFamily.Text = "Family :";
            // 
            // LblDate
            // 
            this.LblDate.AutoSize = true;
            this.LblDate.Font = new System.Drawing.Font("Vazir", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.LblDate.ForeColor = System.Drawing.Color.White;
            this.LblDate.Location = new System.Drawing.Point(9, 166);
            this.LblDate.Name = "LblDate";
            this.LblDate.Size = new System.Drawing.Size(40, 19);
            this.LblDate.TabIndex = 4;
            this.LblDate.Text = "Date :";
            // 
            // LblEducation
            // 
            this.LblEducation.AutoSize = true;
            this.LblEducation.Font = new System.Drawing.Font("Vazir", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.LblEducation.ForeColor = System.Drawing.Color.White;
            this.LblEducation.Location = new System.Drawing.Point(9, 231);
            this.LblEducation.Name = "LblEducation";
            this.LblEducation.Size = new System.Drawing.Size(70, 19);
            this.LblEducation.TabIndex = 5;
            this.LblEducation.Text = "Education :";
            // 
            // LblGender
            // 
            this.LblGender.AutoSize = true;
            this.LblGender.Font = new System.Drawing.Font("Vazir", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.LblGender.ForeColor = System.Drawing.Color.White;
            this.LblGender.Location = new System.Drawing.Point(310, 25);
            this.LblGender.Name = "LblGender";
            this.LblGender.Size = new System.Drawing.Size(54, 19);
            this.LblGender.TabIndex = 6;
            this.LblGender.Text = "Gender :";
            // 
            // LblAddress
            // 
            this.LblAddress.AutoSize = true;
            this.LblAddress.Font = new System.Drawing.Font("Vazir", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.LblAddress.ForeColor = System.Drawing.Color.White;
            this.LblAddress.Location = new System.Drawing.Point(310, 90);
            this.LblAddress.Name = "LblAddress";
            this.LblAddress.Size = new System.Drawing.Size(60, 19);
            this.LblAddress.TabIndex = 7;
            this.LblAddress.Text = "Address :";
            // 
            // LblRegisterList
            // 
            this.LblRegisterList.AutoSize = true;
            this.LblRegisterList.Font = new System.Drawing.Font("Vazir", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.LblRegisterList.ForeColor = System.Drawing.Color.White;
            this.LblRegisterList.Location = new System.Drawing.Point(231, 281);
            this.LblRegisterList.Name = "LblRegisterList";
            this.LblRegisterList.Size = new System.Drawing.Size(120, 30);
            this.LblRegisterList.TabIndex = 8;
            this.LblRegisterList.Text = "Register List";
            // 
            // RbtnMale
            // 
            this.RbtnMale.AutoSize = true;
            this.RbtnMale.Font = new System.Drawing.Font("Vazir", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.RbtnMale.ForeColor = System.Drawing.Color.White;
            this.RbtnMale.Location = new System.Drawing.Point(393, 23);
            this.RbtnMale.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.RbtnMale.Name = "RbtnMale";
            this.RbtnMale.Size = new System.Drawing.Size(53, 23);
            this.RbtnMale.TabIndex = 10;
            this.RbtnMale.TabStop = true;
            this.RbtnMale.Text = "Male";
            this.RbtnMale.UseVisualStyleBackColor = true;
            // 
            // RbtnFemale
            // 
            this.RbtnFemale.AutoSize = true;
            this.RbtnFemale.Font = new System.Drawing.Font("Vazir", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.RbtnFemale.ForeColor = System.Drawing.Color.White;
            this.RbtnFemale.Location = new System.Drawing.Point(477, 23);
            this.RbtnFemale.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.RbtnFemale.Name = "RbtnFemale";
            this.RbtnFemale.Size = new System.Drawing.Size(65, 23);
            this.RbtnFemale.TabIndex = 11;
            this.RbtnFemale.TabStop = true;
            this.RbtnFemale.Text = "Female";
            this.RbtnFemale.UseVisualStyleBackColor = true;
            // 
            // Timer
            // 
            this.Timer.Interval = 1000;
            this.Timer.Tick += new System.EventHandler(this.Timer_Tick);
            // 
            // TeboxAddress
            // 
            this.TeboxAddress.Location = new System.Drawing.Point(377, 90);
            this.TeboxAddress.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.TeboxAddress.Multiline = true;
            this.TeboxAddress.Name = "TeboxAddress";
            this.TeboxAddress.Size = new System.Drawing.Size(206, 165);
            this.TeboxAddress.TabIndex = 12;
            // 
            // TeboxFamily
            // 
            this.TeboxFamily.Location = new System.Drawing.Point(87, 86);
            this.TeboxFamily.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.TeboxFamily.Name = "TeboxFamily";
            this.TeboxFamily.Size = new System.Drawing.Size(218, 26);
            this.TeboxFamily.TabIndex = 13;
            // 
            // TeboxName
            // 
            this.TeboxName.Location = new System.Drawing.Point(88, 23);
            this.TeboxName.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.TeboxName.Name = "TeboxName";
            this.TeboxName.Size = new System.Drawing.Size(217, 26);
            this.TeboxName.TabIndex = 14;
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AllowUserToDeleteRows = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dataGridView1.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.dataGridView1.Location = new System.Drawing.Point(12, 339);
            this.dataGridView1.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.RowHeadersWidthSizeMode = System.Windows.Forms.DataGridViewRowHeadersWidthSizeMode.DisableResizing;
            this.dataGridView1.RowTemplate.Height = 25;
            this.dataGridView1.Size = new System.Drawing.Size(571, 319);
            this.dataGridView1.TabIndex = 15;
            // 
            // BtnRegister
            // 
            this.BtnRegister.Location = new System.Drawing.Point(450, 281);
            this.BtnRegister.Name = "BtnRegister";
            this.BtnRegister.Size = new System.Drawing.Size(75, 23);
            this.BtnRegister.TabIndex = 16;
            this.BtnRegister.Text = "Register";
            this.BtnRegister.UseVisualStyleBackColor = true;
            this.BtnRegister.Click += new System.EventHandler(this.BtnRegister_Click);
            // 
            // LblTimer
            // 
            this.LblTimer.AutoSize = true;
            this.LblTimer.Font = new System.Drawing.Font("Vazir", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.LblTimer.ForeColor = System.Drawing.Color.White;
            this.LblTimer.Location = new System.Drawing.Point(257, 672);
            this.LblTimer.Name = "LblTimer";
            this.LblTimer.Size = new System.Drawing.Size(0, 30);
            this.LblTimer.TabIndex = 17;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 19F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DimGray;
            this.ClientSize = new System.Drawing.Size(594, 711);
            this.Controls.Add(this.LblTimer);
            this.Controls.Add(this.BtnRegister);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.TeboxName);
            this.Controls.Add(this.TeboxFamily);
            this.Controls.Add(this.TeboxAddress);
            this.Controls.Add(this.RbtnFemale);
            this.Controls.Add(this.RbtnMale);
            this.Controls.Add(this.LblRegisterList);
            this.Controls.Add(this.LblAddress);
            this.Controls.Add(this.LblGender);
            this.Controls.Add(this.LblEducation);
            this.Controls.Add(this.LblDate);
            this.Controls.Add(this.LblFamily);
            this.Controls.Add(this.LblName);
            this.Controls.Add(this.TipickerDate);
            this.Controls.Add(this.CoboxEducation);
            this.Font = new System.Drawing.Font("Vazir", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.Name = "Form1";
            this.ShowIcon = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "College";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private ComboBox CoboxEducation;
        private DateTimePicker TipickerDate;
        private Label LblName;
        private Label LblFamily;
        private Label LblDate;
        private Label LblEducation;
        private Label LblGender;
        private Label LblAddress;
        private Label LblRegisterList;
        private RadioButton RbtnMale;
        private RadioButton RbtnFemale;
        private System.Windows.Forms.Timer Timer;
        private TextBox TeboxAddress;
        private TextBox TeboxFamily;
        private TextBox TeboxName;
        private DataGridView dataGridView1;
        private Button BtnRegister;
        private Label LblTimer;
    }
}