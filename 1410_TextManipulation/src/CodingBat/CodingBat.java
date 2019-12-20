package CodingBat;

public class CodingBat {
	public static String wordEnds(String str, String word) {
		
		
		int wordLength = word.length();
		int len = str.length();
		int currentPosition = str.indexOf(word);
		int i = 0;
		StringBuilder st = new StringBuilder(len);
		while(currentPosition != -1)
		{
			i = currentPosition + wordLength;
			if(currentPosition >= 1)
				st.append(str.charAt(currentPosition-1));
			if(i < len)
				st.append(str.charAt(currentPosition + wordLength));
			currentPosition = str.indexOf(word, i);	
		}
		return st.toString();
	}

}
