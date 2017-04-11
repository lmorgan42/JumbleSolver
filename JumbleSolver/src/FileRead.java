import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FileRead{

	HashMap m = new HashMap();
	HashSet temp = new HashSet();
	String ln = null;
	String key = null;

	public FileRead() {
	}

	public void read(File txt) {
		try {
			Scanner sc = new Scanner(txt);
			if (sc != null) {
				while (sc.hasNext()) {
					key = Alphabetizer.alph(sc.nextLine());
					if (m.get(key) == null) {
						temp.add(ln);
						m.put(key, temp);
						temp.clear();
					} else {
						temp = (HashSet) m.get(key);
						temp.add(ln);
						m.put(key, temp);
						temp.clear();
					}

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap getMap(){
		return m; 
	}

}
