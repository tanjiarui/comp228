package exercise1;
import java.util.Scanner;

class singers
{
	private int id,album;
	private String name,address,DoB;
	singers()
	{
		name = "empty";
		address = "empty";
		DoB = "19000101";
		id = 0;
		album = 0;
	}
	singers(String name,String address,String DoB,int id,int album)
	{
		this.name = name;
		this.address = address;
		this.DoB = DoB;
		this.id = id;
		this.album = album;
	}
	void set_name(String name)
	{
		this.name=name;
	}
	void set_addr(String address)
	{
		this.address=address;
	}
	void set_dob(String DoB)
	{
		this.DoB=DoB;
	}
	void set_id(int id)
	{
		this.id=id;
	}
	void set_num(int album)
	{
		this.album=album;
	}
	void set_all(String name,String address,String DoB,int id,int album)
	{
		this.name=name;
		this.address=address;
		this.DoB=DoB;
		this.id=id;
		this.album=album;
	}
	String get_name()
	{
		return name;
	}
	String get_addr()
	{
		return address;
	}
	String get_dob()
	{
		return DoB;
	}
	int get_id()
	{
		return id;
	}
	int get_num()
	{
		return album;
	}
	void print_info()
	{
		System.out.println("name: "+name+'\t'+"address: "+address+'\t'+"date of birth: "+DoB+'\t'+"id: "+id+'\t'+"num of albums: "+album);
	}
}

class test
{
	public static void main(String [] args)
	{
		singers singer=new singers();
		singer.print_info();
		singer.set_all("Taylor Swift","Nashville, Tennessee, US","1989.12.13",1,8);
		singer.print_info();
		singer.set_all("Justin Bieber ","Stratford, Ontario, Canada","1994.3.1",2,5);
		singer.print_info();
		Scanner sc = new Scanner(System.in);
		System.out.println("input name：");
		String name = sc.nextLine();
		System.out.println("input address：");
		String address = sc.nextLine();
		System.out.println("input date of birth：");
		String dob = sc.nextLine();
		try
		{
			System.out.println("input id：");
			int id = sc.nextInt();
			System.out.println("input number of albums：");
			int album = sc.nextInt();
			singer.set_all(name,address,dob,id,album);
			singer.print_info();
		}
		catch(Exception e)
		{
			System.out.println("invalid input");
			e.printStackTrace();
			System.exit(0);
		}
	}
}