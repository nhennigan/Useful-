//Niamh Hennigan 17418134
import java.io.*;
import  java.io.File;
public class InputOutputToFile {

	public InputOutputToFile() {
	}

	public static String Output(String fileName, Object array) {
		//creates a file and then writes data to the file from the array object that is passed in
		try {
			File f1 = new File(fileName+".bin");
			FileOutputStream out = new FileOutputStream (f1);
			ObjectOutputStream objOut ;
			objOut = new ObjectOutputStream (out);
			objOut.writeObject(array);
			objOut.close();
			out.close();
			return f1.getAbsolutePath();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error has occurred with either input or output");

		}
		return null;
	}
	
	public static Object Input(String filePath) {
		//reads in from a file and returns it as an object 
		FileInputStream in;
		try {
			in = new FileInputStream(filePath);
			ObjectInputStream objIn = new ObjectInputStream (in);
			Object load = objIn.readObject();
			objIn.close();
			in.close();
			return load;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Cannont find this file");
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error has occurred with either input or output");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Cannont find this class");
		}
		return null;
		
	}
}
