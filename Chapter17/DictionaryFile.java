// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter17/DictionaryFile.java

import java.io.*;
import java.util.Scanner;

public class DictionaryFile
{
	public static void main( String[] args ) throws IOException {
		Scanner scan = new Scanner( System.in );
		// 영어 단어 입력
		System.out.print( "영어 단어를 입력하세요: " );
		String word = scan.next();
		// 영한사전 열기
		System.out.print( "사전 이름을 입력하세요: " );
		String filename = scan.next();
		BufferedReader dictionary = new BufferedReader( new FileReader( new File( filename ) ) );
		// 영한사전에서 한 줄씩 읽고
		for ( String meaning = ""; ( meaning = dictionary.readLine() ) != null; ) {
			// 해당 영어 단어를 찾으면 뜻을 출력
			if ( meaning.contains( word ) ) {
				System.out.println( meaning );
				break;
			}
		}
		// 영한사전 닫기
		dictionary.close();
		scan.close();
	}
}

