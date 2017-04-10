import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;



public class FileRead {
	
	HashMap m;
	String ln=null;
	Sting ln2=null;
	
	public FileRead(){
		m= new HashMap();
	}
	
	public void read(File txt){
		try {
			Scanner sc= new Scanner(txt);
			if(sc!=null){
				while(sc.hasNext()){
					ln=sc.nextLine();
//					ln1=Collections.sort(ln);
//					alphabetize stuffz					
//					 if(Collections.sort(m.get(ln))!=null)
//					 	m.put(ln2,ln);
//					 
				}
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
