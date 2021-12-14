import java.util.Scanner;

abstract class Book
{
	String title,ISBN,publisher,genre;
	int year;
	float price;
	String return_string()
	{
		return title+'\t'+ISBN+'\t'+publisher+'\t'+genre+'\t'+year+'\t'+price;
	}
	void setter(String title,String ISBN,String publisher,String genre,int year)
	{
		this.title=title;
		this.ISBN=ISBN;
		this.publisher=publisher;
		this.genre=genre;
		this.year=year;
	}
	abstract void set_price(float price);
	String get_title()
	{
		return title;
	}
	String get_ISBN()
	{
		return ISBN;
	}
	String get_publisher()
	{
		return publisher;
	}
	abstract String get_genre();
	int get_year()
	{
		return year;
	}
	float get_price()
	{
		return price;
	}
}

class Science_Book extends Book
{
	@Override
	void set_price(float price)
	{
		this.price=price*(float).9;
	}
	@Override
	String get_genre()
	{
		return genre;
	}
}

class Children_Book extends Book
{
	@Override
	void set_price(float price)
	{
		this.price=price;
	}
	@Override
	String get_genre()
	{
		return genre;
	}
}

public class run
{
	public static void main(String[] args)
	{
		int type,year;
		float price;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose the type of book:\n1. science\n2. children");
		while (true)
		{
			try
			{
				type = scanner.nextInt();
				if (type == 1)
				{
					scanner.nextLine();
					break;
				}
				else if (type == 2)
				{
					scanner.nextLine();
					break;
				}
				else
				{
					System.out.println("Your input is wrong! Please choose 1 or 2");
				}
			}
			catch (Exception e)
			{
				System.out.println("Your input is wrong! Please choose 1 or 2");
				scanner.next();
			}
		}
		System.out.println("Please enter the title");
		String title=scanner.nextLine();
		System.out.println("Please enter the ISBN");
		String ISBN=scanner.nextLine();
		System.out.println("Please enter the publisher");
		String publisher=scanner.nextLine();
		System.out.println("Please enter the genre");
		String genre=scanner.nextLine();
		System.out.println("Please enter the year");
		while (true)
		{
			try
			{
				year=scanner.nextInt();
				break;
			}
			catch (Exception e)
			{
				System.out.println("Your input is wrong! Please input an integer");
				scanner.next();
			}
		}
		System.out.println("Please enter the price");
		while (true)
		{
			try
			{
				price=scanner.nextFloat();
				break;
			}
			catch (Exception e)
			{
				System.out.println("Your input is wrong! Please input a float");
				scanner.next();
			}
		}
		if (type == 1)
		{
			Science_Book book=new Science_Book();
			book.setter(title,ISBN,publisher,genre,year);
			book.set_price(price);
			System.out.println("book info\n"+book.return_string());
		}
		else
		{
			Children_Book book=new Children_Book();
			book.setter(title,ISBN,publisher,genre,year);
			book.set_price(price);
			System.out.println("book info\n"+book.return_string());
		}
	}
}