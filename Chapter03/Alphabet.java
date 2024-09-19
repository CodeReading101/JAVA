// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter03/Alphabet.java

import java.util.Scanner;
public class Alphabet
{
	public static void main( String[] args ) {
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		char lowercase = '\0', uppercase = '\0';
		
		// 알파벳 소문자를 입력받기
		System.out.print( "알파벳 소문자 한 글자를 입력하세요: " );
		lowercase = scan.nextLine().charAt(0);
		
		// 알파벳 소문자를 대문자로 변환하기
		uppercase = (char)( (int)lowercase - (int)'a' + (int)'A' );
		
		// 입력값 출력하기
		System.out.print( "소문자 " + lowercase + "의 대문자는 " + uppercase + "입니다^^" );
	}
}

