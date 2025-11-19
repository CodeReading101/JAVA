// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter19/GenericTest.java

import java.util.*;
public class GenericTest {
	public static void main( String[] args ) {
		// 먼저, 점수 정렬 후 출력
		ArrayList<Integer> scores = new ArrayList<>();
		scores.add( 90 );
		scores.add( 89 );
		scores.add( 86 );
		Collections.sort( scores );
		for( int i = 0; i < scores.size(); i++ )
		    System.out.print( scores.get(i) + " "  );
		System.out.println();
		// 단어 정렬 후 출력
		ArrayList<String> words = new ArrayList<>();
		words.add( "carrot" );
		words.add( "banana" );
		words.add( "apple" );
		Collections.sort( words );
		for( int i = 0; i < words.size(); i++ )
		    System.out.print( words.get(i) + " "  );
	}
}

