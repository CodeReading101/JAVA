// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter16/WeatherFile.java

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
			String[] item = line.split("\t");
			if ( item.length < 17 ) {
				System.out.print( "(오류) 날짜별 날씨 정보을 읽어올 수 없습니다." );
				break;
			}
			String month      = item[0];
			String day        = item[1];
			String week       = item[2];
			String weatherReport = item[3];
			String precaution = item[4];
			int lowSeoul      = Integer.parseInt( item[5] );
			int lowChuncheon  = Integer.parseInt( item[6] );
			int lowDaejeon    = Integer.parseInt( item[7] );
			int lowGwangju    = Integer.parseInt( item[8] );
			int lowBusan      = Integer.parseInt( item[9] );
			int lowJeju       = Integer.parseInt( item[10] );
			int highSeoul     = Integer.parseInt( item[11] );
			int highChuncheon = Integer.parseInt( item[12] );
			int highDaejeon   = Integer.parseInt( item[13] );
			int highGwangju   = Integer.parseInt( item[14] );
			int highBusan     = Integer.parseInt( item[15] );
			int highJeju      = Integer.parseInt( item[16] );
			// 추출한 정보를 바탕으로 날씨 기사를 자동으로 생성
			System.out.println( month + "월 " + day + "일 " + week + "요일 오늘의 날씨입니다." );
			System.out.println( "주요 지역의 아침 최저 기온은 서울 " + lowSeoul + "도, 춘천 " + lowChuncheon + "도, 대전 " + lowDaejeon + "도, 광주 " + lowGwangju + "도, 부산 " + lowBusan + "도, 제주 " + lowJeju + "도입니다." );
			System.out.println( "낮 최고기온은 서울 " + highSeoul + "도, 춘천 " + highChuncheon + "도, 대전 " + highDaejeon + "도, 광주 " + highGwangju + "도, 부산 " + highBusan + "도, 제주 " + highJeju + "도입니다." );
			System.out.println( weatherReport + "가 발효중인 지역에서는 " + precaution + " 운전에 각별히 주의해 주시기 바랍니다.\n" );
		}
		// 날씨 정보 파일 닫기
		inFile.close();
		scan.close();
	}
}

