// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter17/WeatherFile.java

import java.io.*;
import java.util.Scanner;

public class WeatherFile
{
	public static void main( String[] args ) throws IOException {
		Scanner scan = new Scanner( System.in );
		// 날씨 정보 파일 열기
		System.out.print( "파일이름을 입력하세요: " );
		String filename = scan.next();
		BufferedReader inFile = new BufferedReader( new FileReader( new File( filename ) ) );
		// 파일에서 날짜별 날씨 정보를 추출하기
		for( String line; ( line = inFile.readLine() ) != null; ) {
			String[] data = line.split( "\t" );
			if ( data.length == 17 ) {
				// 추출한 정보를 바탕으로 날씨 기사를 자동으로 생성
				System.out.println( data[0] + "월 " + data[1] + "일 " + data[2] + "요일 오늘의 날씨입니다." );
				System.out.println( "주요 지역의 아침 최저기온은 서울 " + data[5] + "도, 춘천 " + data[6] + "도, 대전 " + data[7] + "도, 광주 " + data[8] + "도, 부산 " + data[9] + "도, 제주 " + data[10] + "도입니다." );
				System.out.println( "낮 최고기온은 서울 " + data[11] + "도, 춘천 " + data[12] + "도, 대전 " + data[13] + "도, 광주 " + data[14] + "도, 부산 " + data[15] + "도, 제주 " + data[16] + "도입니다." );
				System.out.println( data[3] + "가 발효 중인 지역에서는 " + data[4] + " 운전에 주의해 주시기 바랍니다.\n" );
			}
			else {
				System.out.print( "(오류) 날짜별 날씨 정보을 읽어올 수 없습니다." );
				break;
			}
		}
		// 날씨 정보 파일 닫기
		inFile.close();
		scan.close();
	}
}

