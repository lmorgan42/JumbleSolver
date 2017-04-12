import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Evaluator {
	
	public Evaluator(){
	}
		
	public ArrayList<String> getWords(ArrayList<String> list){ 
		ArrayList<String> words = new ArrayList<String>();
		for (int i =0; i<list.size(); i++){
			words.addAll(solve(list.get(i)));
		}
		return words;
	}

	//solves the string testing 
	private ArrayList <String> solve(String string) {
		ArrayList <String> s = new ArrayList<String>();
		String temp = "";
		temp = Alphabetizer.alph(string);
		HashMap hash = FileRead.getMap();
		HashSet set = (HashSet)hash.get(temp);
		if (set == null){
			return null;
		}
		while (set.iterator().hasNext()==true){
			temp = (String)set.iterator().next();
			s.add(temp);
		}
		return s;
	}
	
}

