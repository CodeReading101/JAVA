// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter20/FactorialRecursion.java

import java.util.Scanner;
public class FactorialRecursion
{
	// 1부터 n까지의 곱을 계산
	private static int factorial( int num ) {
		// n! = n * ( n - 1 )!
		if ( num > 1 ) {
			System.out.print( num + " * " );
			return num * factorial( num - 1 );
		}
		// 1! = 1, 0! = 1
		else {
			System.out.print( "1 = " );
			return 1;
		}
	}
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 숫자 n 입력받기
		System.out.print( "숫자를 입력하세요: " );
		int num = scan.nextInt();
		// 1부터 n까지의 곱을 계산하기
		System.out.print( num + "! = " );
		int result = factorial( num );
		// 결과 출력하기
		System.out.print( result );
		scan.close();
	}
}

