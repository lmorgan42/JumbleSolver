import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
	public Alphabetizer(){
	}
	//alphabetizes the string
	public static String alph(String s){
		s.toLowerCase();
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
