// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter20/TowerOfHanoi.java

import java.util.Scanner;
public class TowerOfHanoi
{
	private static int[][] tower = new int[3][10];
	private static int[] diskCountPerTower = new int[3];
	private static int totalDiskCount;
	// 하노이 타워의 초기 상태를 설정하는 함수
	private static void initializeTower( int diskCount ) {
		totalDiskCount = diskCount;
		diskCountPerTower[0] = diskCount;
		diskCountPerTower[1] = 0;
		diskCountPerTower[2] = 0;
		for ( int i = 0; i < diskCount; i++ ) {
			tower[0][i] = diskCount - i;
		}
	}
	// 하노이 타워의 현재 상태를 출력하는 함수
	private static void printTower() {
		for ( int line = totalDiskCount-1; line >= 0; line-- ) {
			for ( int number = 0; number < 3; number++ ) {
				if ( tower[number][line] > 0 )
					System.out.print( "  " + tower[number][line] + "  " );
				else
					System.out.print( "  .  " );
			}
			System.out.println();
		}
		System.out.println(" ---  ---  ---\n  A    B    C \n");
	}
	// 원반 한 개를 이동하는 함수
	private static void moveOneDisk( int from, int to ) {
		// 출발기둥의 가장 위에 있는 원반 하나 가져오기
		int top = --diskCountPerTower[from];
		int disk = tower[from][top];
		tower[from][top] = 0;
		// 도착기둥의 가장 위에 원반 놓기
		top = diskCountPerTower[to]++;
		tower[to][top] = disk;
		// 원반 한 개를 이동한 결과 출력
		printTower();
	}
	// 원반 여러 개를 이동하는 함수
	private static void moveDisks( int diskCount, int from, int temp, int to ) {
		if ( diskCount == 1 ) {
			moveOneDisk( from, to );
		}
		else {
			// N-1개 원반을 출발기둥에서 임시기둥으로 모두 이동
			moveDisks( diskCount-1, from, to, temp );
			// 가장 큰 원반을 출발기둥에서 도착기둥으로 이동
			moveOneDisk( from, to );
			// N-1개 원반을 임시기둥에서 도착기둥으로 모두 이동
			moveDisks( diskCount-1, temp, from, to );
		}
	}
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 하노이 타워의 초기 상태를 설정
		System.out.print( "하노이 탑의 원반 개수를 입력하세요(10개 이하) : " );
		int diskCount = scan.nextInt();
		initializeTower( diskCount );
		printTower();
		// 3개의 원반을 출발기둥, 임시기둥, 도착기둥을 이용해 이동
		moveDisks( diskCount, 0, 1, 2 );
		scan.close();
	}
}

