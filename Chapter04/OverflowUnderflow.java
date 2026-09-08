// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter04/OverflowUnderflow.java

public class OverflowUnderflow
{
	public static void main( String[] args ) {
		// int의 최대값과 최소값으로 변수 초기화
		final int MAX = +2147483647;
		final int MIN = -2147483648;
		// int의 최대값에 1을 더하거나 최소값에서 1을 빼면 오류 발생
		int overflow = MAX + 1;
		int underflow = MIN - 1;
		// overflow 및 underflow 결과 출력
		System.out.println( "MAX     =  " + MAX );
		System.out.println( "MAX + 1 = " + overflow + " ( 오류 발생 )" );
		System.out.println( "MIN     = " + MIN );
		System.out.println( "MIN - 1 =  " + underflow + " ( 오류 발생 )" );
	}
}

