import java.util.Random;
import java.util.concurrent.locks.*;

public class Runner {

	private Account account1 = new Account();
	private Account account2 = new Account();

	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();

	public void firstThread() throws InterruptedException
	{
		Random amount = new Random();

		for(int i=0;i< 10000;i++)
		{
			lock1.lock();
			lock2.lock();
			try
			{
			Account.transfer(account1, account2, amount.nextInt(100));
			}finally
			{
				lock1.unlock();
				lock2.unlock();
			}
		}

	}
	public void secondThread() throws InterruptedException
	{
        Random amount = new Random();

		for(int i=0;i< 10000;i++)
		{
			lock1.lock();
			lock2.lock();
			try
			{
			Account.transfer(account2, account1, amount.nextInt(100));
			}finally
			{
			lock1.unlock();
			lock2.unlock();
			}
		}
	}

	public void finished()
	{
		System.out.println("Account 1 balance: "+ account1.getBalance());
		System.out.println("Account 2 balance: "+ account2.getBalance());
		System.out.println("total balance: "+ (account1.getBalance()+ account2.getBalance()));
	}
}
