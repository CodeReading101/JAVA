// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter02/WeatherNews.java

import java.util.Scanner;
public class Main
{
	public static void main( String[] args ) {
		// 날씨 내용을 저장하는 변수 초기화
		Scanner scan = new Scanner( System.in );
		String month = "";
		String day = "";
		String week = "";
		String weatherReport = "";
		String precaution = "";
		int  lowSeoul = 0;
		int  lowChuncheon = 0;
		int  lowDaejeon = 0;
		int  lowGwangju = 0;
		int  lowBusan = 0;
		int  lowJeju = 0;
		int  highSeoul = 0;
		int  highChuncheon = 0;
		int  highDaejeon = 0;
		int  highGwangju = 0;
		int  highBusan = 0;
		int  highJeju = 0;
		// 주요 날씨 내용을 입력
		System.out.print( "오늘은 몇 월인가요: " );
		month = scan.nextLine().trim();
		System.out.print( "오늘은 몇 일인가요: " );
		day = scan.nextLine().trim();
		System.out.print( "오늘은 무슨 요일인가요: " );
		week = scan.nextLine().trim();
		System.out.print( "오늘의 기상특보는 무엇인가요: " );
		weatherReport = scan.nextLine().trim();
		System.out.print( "오늘의 주의사항은 무엇인가요: " );
		precaution = scan.nextLine().trim();
		System.out.print( "서울 최저기온은 몇 도인가요: " );
		lowSeoul = scan.nextInt();
		System.out.print( "춘천 최저기온은 몇 도인가요: " );
		lowChuncheon = scan.nextInt();
		System.out.print( "대전 최저기온은 몇 도인가요: " );
		lowDaejeon = scan.nextInt();
		System.out.print( "광주 최저기온은 몇 도인가요: " );
		lowGwangju = scan.nextInt();
		System.out.print( "부산 최저기온은 몇 도인가요: " );
		lowBusan = scan.nextInt();
		System.out.print( "제주 최저기온은 몇 도인가요: " );
		lowJeju = scan.nextInt();
		System.out.print( "서울 최고기온은 몇 도인가요: " );
		highSeoul = scan.nextInt();
		System.out.print( "춘천 최고기온은 몇 도인가요: " );
		highChuncheon = scan.nextInt();
		System.out.print( "대전 최고기온은 몇 도인가요: " );
		highDaejeon = scan.nextInt();
		System.out.print( "광주 최고기온은 몇 도인가요: " );
		highGwangju = scan.nextInt();
		System.out.print( "부산 최고기온은 몇 도인가요: " );
		highBusan = scan.nextInt();
		System.out.print( "제주 최고기온은 몇 도인가요: " );
		highJeju = scan.nextInt();
		// 날씨 정보를 바탕으로 기상 뉴스를 자동으로 생성
		System.out.println( month + "월 " + day + "일 " + week + "요일, 아침 날씨입니다." );
		System.out.println( "아침 최저기온은 서울 " + lowSeoul + "도, 춘천 " + lowChuncheon + "도, 대전 " + lowDaejeon + "도, 광주 " + lowGwangju + "도, 부산 " + lowBusan + "도, 제주 " + lowJeju + "도로 예상됩니다." );
		System.out.println( "낮 최고기온은 서울 " + highSeoul + "도, 춘천 " + highChuncheon + "도, 대전 " + highDaejeon + "도, 광주 " + highGwangju + "도, 부산 " + highBusan + "도, 제주 " + highJeju + "도로 예상됩니다." );
		System.out.println( "일부 지방에 " + weatherReport + "가 발효중입니다. 출근길 " + precaution + " 운전에 유의해야 합니다." );
		System.out.print( "이상 날씨였습니다." );
	}
}

