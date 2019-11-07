package miniprj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO {
	public static void saveToFile(ArrayList a, String dir) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(dir);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList readFile(String dir) {
        try
        {
            FileInputStream fis = new FileInputStream(dir);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList temp = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            
            return temp;
         }catch(IOException ioe){
             //ioe.printStackTrace();
             return new ArrayList();
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             //c.printStackTrace();
             return new ArrayList();
          }
	}
}
