package Day2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class MyDemo implements Serializable
{
	int empId;
	String empName;
	float empSalary;
	
	MyDemo(int empId, String empName, float empSalary)
	{
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
}

public class Serialize {

	public static void main(String[] args) {

		MyDemo demo = new MyDemo(111, "Prjakta mali", 22222f);
		
		try {
		FileOutputStream fos = new FileOutputStream("MySerializedFile.ser");
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(demo);
		out.flush();
		out.close();
		}
		catch(Throwable e)
		{
			System.out.println(e.getMessage());
		}

	}

}
