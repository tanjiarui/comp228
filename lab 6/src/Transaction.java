public class Transaction implements Runnable
{
	private final Account account;
	private final int amount;
	private boolean deposit;
	boolean valid = true;// check the transactional validity

	Transaction(Account account, int amount, boolean deposit)
	{
		this.account = account;
		this.amount = amount;
		this.deposit = deposit;
	}

	public void run()
	{
		if(this.deposit)
		{
			// amount must be more than zero
			if(this.amount<=0)
			{
				System.out.println("invalid amount");
				valid=false;
			}
			else
				this.account.deposit(this.amount);
		}
		else
		{
			// amount must be less than balance
			if(this.amount>this.account.balance)
			{
				System.out.println("the balance is not enough");
				valid=false;
			}
			else
				this.account.withdraw(this.amount);
		}
	}
}
