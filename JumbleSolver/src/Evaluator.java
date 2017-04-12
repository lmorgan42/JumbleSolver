import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Evaluator {
	
	GameWindow gw;
	
	public Evaluator(){
		this.gw = gw;
	}
		
	public ArrayList<ArrayList<String>> getWords(ArrayList<String> list){ 
		ArrayList<ArrayList <String>> words = new ArrayList<ArrayList<String>>();
		for (int i =0; i<list.size(); i++){
			words.add(solve(list.get(i)));
		}
		words.add(finalWord());
		return words;
	}

	//solves the string testing 
	private ArrayList <String> solve(String string) {
		ArrayList <String> s = new ArrayList<String>();
		String temp = "";
		temp = Alphabetizer.alph(string);
		HashMap hash = gw.getHashMap();
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
	
	private ArrayList<String> finalWord(){
		return null;
	}
	
}

