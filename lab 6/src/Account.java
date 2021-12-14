public class Account
{
	int balance;
	Account(int balance)
	{
		this.balance = balance;
	}
	
	synchronized void deposit(int amount)
	{
		try
		{
			Thread.sleep(1000); // sleep for 1 second
			balance += amount; // save balance
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.printf("%s deposited %d in %s.\n", Thread.currentThread().getName(), amount, this.toString());
	}
	
	synchronized void withdraw(int amount)
	{
		try
		{
			Thread.sleep(1000); // sleep for 1 second
			balance -= amount; // withdraw balance
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.printf("%s deposited %d in %s.\n", Thread.currentThread().getName(), amount, this.toString());
	}
}