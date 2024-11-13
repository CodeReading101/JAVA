// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter16/Dictionary.java

import java.io.*;
import java.util.Scanner;
public class Dictionary
{
	public static void main( String[] args ) throws IOException {
		Scanner scan = new Scanner( System.in );
		String word = "", meaning = "", filename = "";
		// 영어 단어를 입력
		System.out.print( "영어단어를 입력하세요: " );
		word = scan.next();
		// 영한 사전을 열기
		System.out.print( "사전이름을 입력하세요: " );
		filename = scan.next();
		BufferedReader dictionary = new BufferedReader( new FileReader( new File( filename ) ) );
		// 영한 사전에서 한 줄씩 읽고
		while ( ( meaning = dictionary.readLine() ) != null ) {
			// 해당 영어단어를 찾으면 뜻을 출력
			if ( meaning.contains( word ) ) {
				System.out.println( meaning );
				break;
			}
		}
		// 영한 사전 닫기
		dictionary.close();
		scan.close();
	}
}

