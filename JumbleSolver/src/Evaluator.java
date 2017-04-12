import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Evaluator {
	
	public Evaluator(){
	}
	
	public ArrayList<String> getWords(ArrayList<String> list){ 
		ArrayList<String> words = new ArrayList<String>();
		for (int i =0; i<list.size(); i++){
			words.add(solve(list.get(i)));
		}
		return words;
	}
	//solves the string testing 
	private String solve(String string) {
		String s = Alphabetizer.alph(string);
		HashMap hash = FileRead.getMap();
		HashSet set = (HashSet)hash.get(s);
		if (set == null){
			return null;
		}
		//need to ask Hanson about last word solving to determine word
		s = (String)set.iterator().next();
		return s;
	}
	
	
}

