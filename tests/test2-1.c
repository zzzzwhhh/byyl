int main()
{
    int a, c;
    int b;
    a = -3;
    b = 04;
    c = 0XF;
	
    {
        int c, d;
        c = a * b;
        b = c / a;
        d = a % b;
    }

    return a + b + c;
}