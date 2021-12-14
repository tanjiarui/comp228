import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test
{
	public static void main(String[] arg)
	{
		ArrayList<Transaction> list = new ArrayList<>();
		Account account = new Account(10);
		Transaction transaction1 = new Transaction(account, -10, true);
		Transaction transaction2 = new Transaction(account, 20, true);
		Transaction transaction3 = new Transaction(account, 30, true);
		Transaction transaction4 = new Transaction(account, 1000, false);
		ExecutorService executor = Executors.newCachedThreadPool();
		if(transaction1.valid)
			list.add(transaction1);
		if(transaction2.valid)
			list.add(transaction2);
		if(transaction3.valid)
			list.add(transaction3);
		if(transaction4.valid)
			list.add(transaction4);
		for (Transaction transaction : list)
		{
			executor.execute(transaction);
		}
		executor.shutdown();
		try
		{
			// wait 1 minute for both writers to finish executing
			boolean end_flag = executor.awaitTermination(1, TimeUnit.MINUTES);
			if (end_flag)
				System.out.println("final balance in account after all transactions is " + account.balance);
			else
				System.out.println("timed out while waiting for tasks to finish.");
		}
		catch (InterruptedException ex)
		{
			System.out.println("interrupted while wait for tasks to finish.");
		}
	}
}