// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter15/RhythmGame.java

import java.util.Scanner;
class Beat implements Runnable {
	private int index;
	private final String[][] beat = {
			{ "     ", "     ", "     " },
			{ "     ", "     ", "     " },
			{ "     ", "     ", "     " },
			{ "     ", "     ", "     " },
			{ "     ", "     ", "     " },
			{ "     ", "     ", "OOOOO" },
			{ "     ", "OOOOO", "     " },
			{ "     ", "OOOOO", "     " },
			{ "OOOOO", "     ", "     " },
			{ "     ", "     ", "OOOOO" },
			{ "     ", "OOOOO", "     " },
			{ "     ", "     ", "     " },
			{ "     ", "     ", "     " },
			{ "     ", "     ", "     " },
			{ "     ", "     ", "     " },
	};
	// Drop the Beat 스레드 시작
	public void run() {
		try {
			System.out.println( "\033[6;1f  A    S    D " );
			// 주기적으로 한 줄씩 아래로 이동
			for( index = beat.length-1; index > 3; index-- ) {
				System.out.print( "\033[1;1f" );
				System.out.println( beat[index-4][0] + beat[index-4][1] + beat[index-4][2] );
				System.out.println( beat[index-3][0] + beat[index-3][1] + beat[index-3][2] );
				System.out.println( beat[index-2][0] + beat[index-2][1] + beat[index-2][2] );
				System.out.println( beat[index-1][0] + beat[index-1][1] + beat[index-1][2] );
				System.out.println( beat[index  ][0] + beat[index  ][1] + beat[index  ][2] );
				System.out.println( "\033[7;1f\033[7;40f" );
				System.out.flush();
				Thread.sleep( 1000 );
			}
			System.exit(0);
		} catch( Exception e ) {
		}
	// Drop the Beat 스레드 종료
	}
	// Hit the Beat 메서드 시작
	public void hit() {
		Scanner scan = new Scanner( System.in );
		String in = "";
		do {
			// 입력값이 비트가 떨어진 위치에 해당하면 Good!, 아니면 Miss! 출력
			if ( ( in.equals("A") || in.equals("a") ) && beat[index][0].equals("OOOOO") )
				System.out.println( "\033[5;1fGood!");
			else if ( in.equals("A") || in.equals("a") )
				System.out.println( "\033[5;1fMiss!");
			else if ( ( in.equals("S") || in.equals("s") ) && beat[index][1].equals("OOOOO") )
				System.out.println( "\033[5;6fGood!");
			else if ( in.equals("S") || in.equals("s") )
				System.out.println( "\033[5;6fMiss!");
			else if ( ( in.equals("D") || in.equals("d") ) && beat[index][2].equals("OOOOO") )
				System.out.println( "\033[5;11fGood!");
			else if ( in.equals("D") || in.equals("d") )
				System.out.println( "\033[5;11fMiss!");
			System.out.flush();
			System.out.print(  "\033[7;1fA,S,D,Q(uit)중 하나를 입력하고 엔터치세요: " );
			in = scan.nextLine();
		} while( in.equals("a") || in.equals("s") || in.equals("d") || in.equals("A") || in.equals("S") || in.equals("D") );
		scan.close();
	// Hit the Beat 메서드 종료
	}
}
public class RhythmGame
{
	// 메인 스레드 시작
	public static void main( String[] args ) {
		Beat beat = new Beat();
		Thread thread = new Thread( beat );
		// Drop the Beat 스레드 시작
		thread.start();
		// Hit the Beat 메서드 호출
		beat.hit();
	// 메인 스레드 종료
	}
}

