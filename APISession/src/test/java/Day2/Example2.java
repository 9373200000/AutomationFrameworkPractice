package Day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example2 {

	public static void main(String[] args) {

		Demo ref = null;
		
		try {
			FileInputStream fis = new FileInputStream("SerializeFile.ser");
			
			ObjectInputStream in;
			try {
				in = new ObjectInputStream(fis);
				
				try {
					ref = (Demo)in.readObject();
					
					System.out.println(ref.name);
					System.out.println(ref.num);
					System.out.println(ref.salary);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
