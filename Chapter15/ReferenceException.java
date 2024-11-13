// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter15/ReferenceException.java

import java.util.*;
public class ReferenceException
{
	public static void main( String args[] ) {
		// 변수 초기화
		String[] word = { "apple", "banana", "carrot" };
		try {
			for( int index = 0; index <= word.length; index++ ) {
				System.out.println( ( index + 1 ) + ") " + word[ index ] + " " );
			}
		}
		// 예외 처리
	 	catch ( ArrayIndexOutOfBoundsException e ) {
			System.out.println( "\n배열 허용 범위 초과" );
		}
		try {
			// null 포인터 예외 발생
			word = null;
			System.out.println( word[0] );
		}
		catch ( NullPointerException e ) {
			System.out.println( "빈 객체 접근 오류" );
		}
	}
}

