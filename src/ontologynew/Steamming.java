package ontologynew;

import org.tartarus.snowball.ext.EnglishStemmer;

public class Steamming {

	public static String Steamming(String args) {
		EnglishStemmer english = new EnglishStemmer();
		english.setCurrent(args.toLowerCase());
		english.stem();
		String rootWord = english.getCurrent();
		return rootWord;
	}
}
