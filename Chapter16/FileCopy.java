// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter16/FileCopy.java

import java.io.*;
import java.util.Scanner;
public class FileCopy
{
	public static void main( String[] args ) throws IOException {
		Scanner scan = new Scanner( System.in );
		String line = "", inFilename = "", outFilename = "";
		// 파일 열기
		// 원본 파일 열기
		System.out.print( "원  본 파일이름을 입력하세요: " );
		inFilename = scan.next();
		BufferedReader inFile = new BufferedReader( new FileReader( new File( inFilename ) ) );
		// 복사본 파일 열기
		System.out.print( "복사본 파일이름을 입력하세요: " );
		outFilename = scan.next();
		BufferedWriter outFile = new BufferedWriter( new FileWriter( new File( outFilename ) ) );
		// 파일 복사
		// 원본 파일 끝까지 한 줄씩 읽기
		while( ( line = inFile.readLine() ) != null ) {
			// 복사본 파일에 한 줄씩 쓰기
			System.out.println( line );
			outFile.write( line + "\n" );
		}
		// 파일 닫기
		inFile.close();
		outFile.close();
		scan.close();
	}
}

