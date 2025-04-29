package Day2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialize {

	public static void main(String[] args) {

		MyDemo ref = null;
		
		try {
		FileInputStream fis = new FileInputStream("MySerializedFile.ser");
		ObjectInputStream in = new ObjectInputStream(fis);
		ref = (MyDemo)in.readObject();
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
