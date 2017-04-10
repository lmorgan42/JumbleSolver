import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
	public Alphabetizer(){
		
	}
	public String alph(String s){
		ArrayList<Integer> asc = new ArrayList<Integer>();
		String last = "";
		for (int i = 0; i< s.length(); i++){
			asc.add((int)s.charAt(i));
		}
		Collections.sort(asc);
		for (int i:asc){
			last+=(Character.toString((char)(i)));
		}
		return last;
	}
}
