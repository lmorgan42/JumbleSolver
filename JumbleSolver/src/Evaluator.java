import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Evaluator {
	
	GameWindow gw;
	
	public Evaluator(GameWindow gw){
		this.gw = gw;
	}

	//returns all possible words for each key  
	private ArrayList <String> keyWords(String string) {
		System.out.println("ran keyWords");
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
			System.out.print(temp+" ");
		}
		System.out.println("");
		System.out.println("KEyWords s: " + s);
		return s;
	}
	
	//returns all the possible words for all the keys
	public ArrayList<ArrayList<String>> getWords(){ 
		ArrayList<ArrayList <String>> words = new ArrayList<ArrayList<String>>();
		ArrayList<String> s = gw.getJumWords();
		for (int i =0; i<s.size(); i++){
			System.out.println("ran getWord for loop " + i + " times");
			words.add(keyWords(s.get(i)));
		}
		System.out.println("words: " + words);
		return words;
	}
	
	
	public ArrayList<ArrayList<String>> getCircledLetters() {
		ArrayList<ArrayList<String>> allPos = this.getWords();
		ArrayList<ArrayList<String>> lets = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<Integer>> circled = gw.getCircled();
		String temp = "";
		ArrayList <String> temp2 = new ArrayList <String>();
		if (circled == null){
			return null;
		}
		for (int i = 0; i<allPos.size(); i++){
			for (int x = 0; x<allPos.get(i).size(); x++){
				for (int z = 0; z<allPos.get(i).get(x).length(); z++){
					if(circled.get(i).indexOf((Integer)z)>0){
						temp+=allPos.get(i).get(x).substring(z);
					}
				}
				temp2.add(temp);
			}
			lets.add(temp2);
		}
		return lets;
	}
	
	//returns the final word 
	private ArrayList<String> finalWord(){
		ArrayList<ArrayList<String>> circled = getCircledLetters();
		int[] numFinalWords = gw.getFinalLayout();
		ArrayList<String> word = new ArrayList<String>();
		for (int i = 0; i<circled.size(); i++){
			for (int x=0; x<0; x++){
				
			}
		}
		return word;
	}
	

	//returns all the words including final word as solved
	private ArrayList<ArrayList<String>> solve(ArrayList<String> string){
		ArrayList<ArrayList<String>> finalWords = new ArrayList<ArrayList<String>>();
		
		finalWords.add(finalWord());

		return null;
	}
}

