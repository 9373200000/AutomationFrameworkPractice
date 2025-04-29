package Day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class MyTest implements Serializable
{
	int ID;
	String NAME;
	float SALARY;
	
	MyTest(int ID, String NAME, float SALARY)
	{
		this.ID = ID;
		this.NAME = NAME;
		this.SALARY = SALARY;
	}
}

public class TestSerializeDeserialize {

	public static void main(String[] args) {
		
		//SERIALIZATION
		MyTest t1 = new MyTest(555, "Selena Gomez", 777777);
		
		try {
		FileOutputStream fos = new FileOutputStream("SERIALIZE.ser");
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(t1);
		System.out.println("SERIALIZED.......");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		//DESERIALIZATION
		MyTest t2 = null;
		
		try {
			FileInputStream fis = new FileInputStream("SERIALIZE.ser");
			ObjectInputStream in = new ObjectInputStream(fis);
			t2 = (MyTest)in.readObject();
			System.out.println(t2.ID);
			System.out.println(t2.NAME);
			System.out.println(t2.SALARY);
			System.out.println("DE SERIALIZED.......");

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
