package Day2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Example1 {

	public static void main(String[] args) {
		
		Demo obj = new Demo(101, "promo", 77.0f);
		String filename = "SerializeFile.ser";
		
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			
			try {
				ObjectOutputStream out = new ObjectOutputStream(fos);
				out.writeObject(obj);
				
				out.flush();
				out.close();
				
				System.out.println("File serialized...");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}

class Demo implements Serializable
{
	public int num;
	public String name;
	public float salary;
	
	Demo(int num, String name, float salary)
	{
		this.num = num;
		this.name =name;
		this.salary = salary;
	}
}
