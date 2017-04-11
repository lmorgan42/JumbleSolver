import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Evaluater {
	
	public Evaluater(){
	}
	
	public void getWords(ArrayList<String> list){ 
		ArrayList<String> words = new ArrayList<String>();
		for (int i =0; i<list.size(); i++){
			words.add(solve(list.get(i)));
		}
	}

	private String solve(String string) {
		String s = "";
		s = Alphabetizer.alph(string);
		HashMap hash = FileRead.getMap();
		HashSet set = (HashSet)hash.get(s);
		if (set == null){
			return null;
		}
		s = (String)set.iterator().next();
		return s;
	}
	
	
}
