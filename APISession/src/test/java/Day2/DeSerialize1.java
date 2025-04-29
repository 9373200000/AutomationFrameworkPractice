package Day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class MyDemo2 implements Serializable
{
	int empId;
	String empName;
	float empSalary;
	
	MyDemo2(int empId, String empName, float empSalary)
	{
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
}

public class DeSerialize1 {

	public static void main(String[] args) {
		
		MyDemo2 myDemo2 = new MyDemo2(333, "Raven", 444444f);
		
		try {
		FileOutputStream fos = new FileOutputStream("MySerializedFile2.ser");
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(myDemo2);
		out.flush();
		out.close();
		
		System.out.println("SERIALIZED...");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		// deserialized
		
		MyDemo2 ref = null;
		
		try {
		FileInputStream fis = new FileInputStream("MySerializedFile2.ser");
		ObjectInputStream in = new ObjectInputStream(fis);
		ref = (MyDemo2)in.readObject();
		System.out.println(ref.empId);
		System.out.println(ref.empName);
		System.out.println(ref.empSalary);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
