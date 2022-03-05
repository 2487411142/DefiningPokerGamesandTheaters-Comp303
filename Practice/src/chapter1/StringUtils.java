package chapter1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringUtils {
	
	public static Comparator<String> BYLENGAS = ByLengthAscending();
	public static Comparator<String> BYLENGDE = ByLengthDescending();
	
	private static final List<String> DATA = 
		Arrays.asList("bb", "dddddd", "a", "ab", "abc", "eee");
	
	public static void main (String[] args) {
		// The normal way
//		Comparator<String> comparator = new ByLength();
		
		// Only use once
//		Comparator<String> comparator = new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				if (o1.length() == o2.length()) {
//					return o1.compareTo(o2);
//				}
//				return o1.length() - o2.length();
//			}
//		};
		Collections.sort(DATA, StringUtils.ByLengthAscending());
		System.out.println(DATA);
	
	
	
	}
	
	// Final version
	private static Comparator<String> ByLengthAscending(){
		return new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		};
	}
	
	private static Comparator<String> ByLengthDescending(){
		return new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o2.length() - o1.length();
			}
		};
	}
}

//The normal way

//class ByLength implements Comparator<String>{
//
//	@Override
//	public int compare(String o1, String o2) {
//		if (o1.length() == o2.length()) {
//			return o1.compareTo(o2);
//		}
//		return o1.length() - o2.length();
//	}
//	
//}