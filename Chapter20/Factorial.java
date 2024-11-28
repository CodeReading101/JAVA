// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter20/Factorial.java

import java.util.Scanner;
public class Factorial
{
	// 1부터 n까지의 곱을 계산
	public static int factorial( int num ) {
		// 1! = 1, 0! = 1
		if ( num <= 1 ) {
			System.out.print ( "1 = " );
			return 1;
		}
		// n! = n * ( n - 1 )!
		else {
			System.out.print ( num + " * " );
			return num = num *
			                   factorial( num - 1 );
		}
	}
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		int num = 0, result = 0;
		// 숫자 n 입력받기
		System.out.print( "숫자를 입력하세요: " );
		num = scan.nextInt();
		// 1부터 n까지의 곱을 계산하기
		System.out.print( num + "! = " );
		result = factorial( num );
		// 결과 출력하기
		System.out.print ( result );
		scan.close();
	}
}

