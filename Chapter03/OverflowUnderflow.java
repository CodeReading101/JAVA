// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter03/OverflowUnderflow.java


public class OverflowUnderflow
{
	public static void main( String[] args ) {
		// int에 저장할 수 있는 최대값과 최소값으로 초기화
		int max = +2147483647;
		int min = -2147483648;
		int overflow = 0;
		int underflow = 0;
		// int의 최대값에 1을 더하면 overflow 발생
		overflow = max + 1;
		// int의 최소값에 1을 빼면 underflow 발생
		underflow = min - 1;
		// overflow와 underflow를 실습 결과 출력
		System.out.println( "max     =  " + max );
		System.out.println( "max + 1 = " + overflow + " ( overflow 발생 )" );
		System.out.println( "min     = " + min );
		System.out.println( "min - 1 =  " + underflow + " ( underflow 발생 )" );
	}
}

