// 13706342
// SamClendenan@icloud.com


public class BankAccount { 

    int balance;
    int max;
    int min;

    BankAccount( int initialBalance )
    {
        balance = initialBalance;
        max = initialBalance;
        min = initialBalance;
    }

    public int getBalance()
    {
        return balance;
    }

    public void updateBalance( int newBalance )
    {
        if (newBalance > max) { max = newBalance; }
        if (newBalance < min) { min = newBalance; }
        balance = newBalance;
    }

    public int getMin()
    {
        return min;
    }

    public int getMax() { return max; }

}

