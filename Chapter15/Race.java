// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter15/Race.java

import java.util.Scanner;
// 달리기 선수
class Player extends Thread
{
	private int x, max, lane, speed;
	public Player( int lane, int speed ) {
		this.x = 1;
		this.max = 100;
		this.lane = lane;
		this.speed = speed;
	}
	// 달리기
	public void run() {
		try {
			System.out.print( "\033[" + lane + ";1f" + lane );
			System.out.print( "\033[" + lane + ";"+(max+2)+"f" + lane );
			for( x = 2; x < max; x++ ) {
				// 선수의 위치 이동
				System.out.print( "\033[" + lane + ";"+ x +"f 옷" );
				System.out.print( "\033[4;40f" );
				// 이때 지정 속력으로 이동
				Thread.sleep( speed );
			}
		} catch( Exception e ) {
		}
	}
}
public class Race
{
	public static void main( String[] args ) {
		// 속력이 다른 3명의 선수가 각자 달리기 출발
		int[] speed = { 35, 20, 50 };
		for( int lane = 1; lane <= speed.length; lane++ ) {
			Player player = new Player( lane, speed[lane-1] );
			player.start();
		}
	}
}

