namespace Fibonacci
{
    public partial class Form1 : Form
    {

        int[] FibonacciNumbers = {0,1};

        public Form1()
        {
            InitializeComponent();
        }

        private void BtnShow_Click(object sender, EventArgs e)
        {
            for (int i = 0; i <= 15; i++)
            {
                int nextFibonacci = FibonacciNumbers[FibonacciNumbers.Length - 2] + FibonacciNumbers[FibonacciNumbers.Length - 1];
                TboxResult.Text += FibonacciNumbers[FibonacciNumbers.Length - 2] + " + " + FibonacciNumbers[FibonacciNumbers.Length - 1] + " = " + nextFibonacci + System.Environment.NewLine;
                FibonacciNumbers = FibonacciNumbers.Concat(new int[] { nextFibonacci }).ToArray();
            }
        }
    }
}