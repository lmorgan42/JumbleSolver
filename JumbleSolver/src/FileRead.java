import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FileRead{

	public HashMap<String, HashSet<String>> m = new HashMap<String, HashSet<String>>();
	String ln = null;
	String key = null;

	public FileRead() {
		
	}

	public void read(File txt) {
		try {
			Scanner sc = new Scanner(txt);
			if (sc != null) {
				while (sc.hasNext()) {
					HashSet<String> temp = new HashSet<String>();
					ln = sc.nextLine().toLowerCase();
					key = Alphabetizer.alph(ln);
					if (m.get(key) == null) {
						temp.add(ln);
						m.put(key, temp);
					} 
					else {
						for (String s: m.get(key)){
							temp.add(s);
						}
						temp.add(ln);
						m.put(key, temp);
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	public HashMap<String, HashSet<String>> getMap(){
		return m; 
	}

}
