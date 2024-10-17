// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter11/XYpoint_Main.java

import java.util.Scanner;
import java.lang.Math;
// XYpoint 클래스
class XYpoint {
	private int x, y;
	// 점의 좌표값을 초기화하는 생성자
	public XYpoint( int x, int y ) {
		this.x = x;
		this.y = y;
	}
	public XYpoint() {
		this( 0, 0 );
	}
	// 점을 문자열 (x,y)로 표현하는 메서드
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	// 두 점이 같은지 비교하는 메서드
	public boolean equals( XYpoint that ) {
		return ( this.x == that.x ) && ( this.y == that.y );
	}
	// 두 점의 차이를 계산하는 메서드
	public double compareTo( XYpoint that ) {
		return Math.sqrt( Math.pow( ( this.x - that.x ), 2 ) + Math.pow( ( this.y - that.y ), 2 ) );
	}
}

public class XYpoint_Main 
{
	public static void main( String[] args ) {
		// 먼저 점의 좌표값 입력
		Scanner scan = new Scanner( System.in );
		System.out.print( "점의 x좌표 값을 입력하세요 : " );
		int x = scan.nextInt();
		System.out.print( "점의 y좌표 값을 입력하세요 : " );
		int y = scan.nextInt();
		// 좌표값을 바탕으로 원점과 입력점의 객체 초기화
		XYpoint origin = new XYpoint();
		XYpoint point = new XYpoint( x, y );
		// 원점과 입력점 사이의 거리 출력
		if ( origin.equals( point ) ) {
			System.out.println( "이 점은 원점입니다" );
		}
		else {
			System.out.println( origin + "과 " + point + " 사이의 거리는 " + point.compareTo( origin ) + "입니다" );
		}
	}
}

