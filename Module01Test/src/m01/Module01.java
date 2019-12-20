package m01;
/**
 * Class Module01 contains main for runnabble jar only.
 * Also contains the transform method.
 * @author landonhowa
 *
 */
public class Module01 {

	public static void main(String[] args) {

	}
	/**
	 * Method transform, first checks to see if string is null, if not
	 * the string is searched for a space. If found, the space is replaced
	 * by a - to later be split and re-added if the string contains cs, cis,
	 * or csis. If this is true, the first part of the string is replaced.
	 * @param word
	 * @return newly created string
	 */
	public static String transform(String word) {
		if (word == null) {
			System.out.println("< >");
			System.exit(0);
		}
		String s1=word.replace(' ','-');
		String s2 = null;
		String[] output = s1.split("-");
		String firstHalf = output[0];
		if (firstHalf.equalsIgnoreCase("csis") || firstHalf.equalsIgnoreCase("cis") || firstHalf.equalsIgnoreCase("cs")){
			s2 = "<CSIS-" + output[1] + ">";
			
		}else {
			s2 = "<" + output[0]+ "-" + output[1] + ">";
		}
		
		return s2;
	}

}
