package Day2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class MyDemo1 implements Serializable
{
	int empId ;
	String empName;
	float empSalary;
	
	MyDemo1(int empId, String empName, float empSalary)
	{
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
}

public class Serialize1 {

	public static void main(String[] args) {

		MyDemo1 ref = new MyDemo1(222, "Katrina kaif", 333333f);
		
		try {
		FileOutputStream fos = new FileOutputStream("MySerializedFile1.ser");
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(ref);
		out.flush();
		out.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("File Serialized...");

	}

}
