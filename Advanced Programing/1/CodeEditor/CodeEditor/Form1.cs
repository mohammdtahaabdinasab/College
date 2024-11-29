namespace CodeEditor
{
    public partial class Form1 : Form
    {
        private bool isDragging = false;
        bool saveFile = false;
        private Point dragCursorPoint;
        private Point dragFormPoint;
        string[] tags = {"html", "head", "body", "title", "style", "script", "div", "p", "h1", "h2", "h3", "h4", "h5", "h6","a"};
        public Form1()
        {
            InitializeComponent();
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {
            panel1.BackColor = ColorTranslator.FromHtml("#23272e");
            richTextBox1.AcceptsTab = true;
        }

        private void header_Paint(object sender, PaintEventArgs e)
        {
            header.BackColor = ColorTranslator.FromHtml("#2c313c");
            BtnClose.BackColor = ColorTranslator.FromHtml("#23272e");
            BtnFullScreen.BackColor = ColorTranslator.FromHtml("#23272e");
            BtnMinimize.BackColor = ColorTranslator.FromHtml("#23272e");
            BtnItalic.BackColor = ColorTranslator.FromHtml("#23272e");
            BtnBold.BackColor = ColorTranslator.FromHtml("#23272e");
            BtnOptions.BackColor = ColorTranslator.FromHtml("#23272e");
            richTextBox1.BackColor = ColorTranslator.FromHtml("#23272e");
        }

        private void BtnFullScreen_Click(object sender, EventArgs e)
        {
            if (WindowState == FormWindowState.Maximized)
            {
                WindowState = FormWindowState.Normal;
            }
            else
            {
                WindowState = FormWindowState.Maximized;
            }
        }

        private void BtnMinimize_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }

        private void BtnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void header_MouseMove(object sender, MouseEventArgs e)
        {
            if (isDragging)
            {
                if (WindowState == FormWindowState.Maximized)
                {
                    WindowState = FormWindowState.Normal;
                }

                Point cursorPoint = Cursor.Position;
                this.Location = new Point(dragFormPoint.X - dragCursorPoint.X + cursorPoint.X, dragFormPoint.Y - dragCursorPoint.Y + cursorPoint.Y);
            }
        }

        private void header_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                isDragging = true;
                dragCursorPoint = Cursor.Position;
                dragFormPoint = this.Location;
            }
        }

        private void header_MouseUp(object sender, MouseEventArgs e)
        {
            isDragging = false;
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {
            try
            {
                string text = richTextBox1.Text;
                int caretIndex = richTextBox1.SelectionStart;

                if (text[caretIndex - 1] == '(')
                {
                    richTextBox1.Text = text.Insert(caretIndex, ")");
                    richTextBox1.SelectionStart = caretIndex;
                }
                else if (text[caretIndex - 1] == '[')
                {
                    richTextBox1.Text = text.Insert(caretIndex, "]");
                    richTextBox1.SelectionStart = caretIndex;
                }
                else if (text[caretIndex - 1] == '{')
                {
                    richTextBox1.Text = text.Insert(caretIndex, "}");
                    richTextBox1.SelectionStart = caretIndex;
                }

                for (int i = 0; i <= tags.Length; i++)
                {
                    if (text.Substring(caretIndex - (tags[i].Length+1), (tags[i].Length+1)) == "<"+tags[i])
                    {
                        richTextBox1.Text = text.Insert(caretIndex, "></"+tags[i]+">");
                        richTextBox1.SelectionStart = caretIndex + 1;
                    }

                }
                saveFile = false;
            }
            catch (Exception ex) { }
        }

        private void BtnOptions_Click(object sender, EventArgs e)
        {
            using (OpenFileDialog openFileDialog = new OpenFileDialog())
            {
                openFileDialog.Filter = "HTML Files (*.html)|*.html";
                openFileDialog.Title = "ذخیره فایل";
                if (openFileDialog.ShowDialog() == DialogResult.OK)
                {
                    string filePath = openFileDialog.FileName;
                    string fileContent = richTextBox1.Text;
                    File.WriteAllText(filePath, fileContent);
                    LblFileName.Text = filePath;
                }
            }
            saveFile = true;
        }

        private void BtnItalic_Click(object sender, EventArgs e)
        {
            if (richTextBox1.SelectionLength > 0)
            {
                richTextBox1.SelectionFont = new Font(richTextBox1.SelectionFont, FontStyle.Italic);
            }
        }

        private void BtnBold_Click(object sender, EventArgs e)
        {
            if (richTextBox1.SelectionLength > 0)
            {
                richTextBox1.SelectionFont = new Font(richTextBox1.SelectionFont, FontStyle.Bold);
            }

        }
    }
}