package Day2.POJO;

class MyPojo
{
	String NAME;
	public int ID;
	private double SALARY;
	
	public MyPojo(String NAME, int ID, double SALARY)
	{
		this.NAME = NAME;
		this.ID = ID;
		this.SALARY = SALARY;
	}
	
	public MyPojo() {
		System.out.println("default constructor...");
	}

	public void setID(int ID)
	{
		this.ID = ID;
		System.out.println(ID);
	}
	public void setName(String name)
	{
		NAME = name;
		System.out.println(name);

	}
	public void setSalary(double salary)
	{
		SALARY = salary;
		System.out.println(salary);

	}
	
	public int getID()
	{
		return ID;
	}
	public String getName()
	{
		return NAME;
	}
	public double getSalary()
	{
		return SALARY;
	}
}

public class Example1 {

	public static void main(String[] args) {
		
		MyPojo mypojo = new MyPojo("PojoClass", 1, 50000000);
		System.out.println(mypojo.getID());
		System.out.println(mypojo.getName());
		System.out.println(mypojo.getSalary());
		
		MyPojo mypojo1 = new MyPojo();
		mypojo1.setID(2);
		mypojo1.setName("Pojoclass11");
		mypojo1.setSalary(9999999);
		mypojo1.getID();
		mypojo1.getName();
		mypojo1.getSalary();

	}

}
