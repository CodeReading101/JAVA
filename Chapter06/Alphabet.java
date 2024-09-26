// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter06/Alphabet.java

import java.util.Scanner;
public class Alphabet
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		char letter = '\0';
		// 글자를 입력받기
		System.out.print( "한 글자를 입력하세요: " );
		letter = scan.nextLine().charAt(0);
		// 입력값이 알파벳 소문자, 알파벳 대문자, 숫자, 기호 중 무엇인지를 출력하기
		// 입력값이 알파벳 소문자인 경우 출력하기
		if (  ( 'a' <= letter ) && ( letter <= 'z' ) ) {
			System.out.print( "알파벳 소문자를 입력했군요^^" );
		}
		// 입력값이 알파벳 대문자인 경우 출력하기
		else if (  ( 'A' <= letter ) && ( letter <= 'Z' ) ) {
			System.out.print( "알파벳 대문자를 입력했군요^^" );
		}
		// 입력값이 숫자인 경우 출력하기
		else if (  ( '0' <= letter ) && ( letter <= '9' ) ) {
			System.out.print( "숫자를 입력했군요^^" );
		}
		// 입력값이 기호인 경우 출력하기
		else {
			System.out.print( "기호를 입력했군요^^" );
		}
	}
}

