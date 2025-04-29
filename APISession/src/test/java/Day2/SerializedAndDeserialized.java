package Day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable
{
	int empId;
	String empName;
	float empSalary;
	
	Test(int empId, String empName, float empSalary)
	{
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
}

public class SerializedAndDeserialized {

	public static void main(String[] args) {

		Test t = new Test(101, "almond", 4000f);
		
		try {
		FileOutputStream fos = new FileOutputStream("myFile.ser");
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(t);
		out.flush();
		out.close();
		System.out.println("FILE HAS SERIALIZED...");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		//DESERIALIZED
		
		try {
			Test t1 = null;
			
			FileInputStream fis = new FileInputStream("myFile.ser");
			ObjectInputStream in = new ObjectInputStream(fis);
			t1 = (Test)in.readObject();
			System.out.println(t1.empId);
			System.out.println(t1.empName);
			System.out.println(t1.empSalary);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
