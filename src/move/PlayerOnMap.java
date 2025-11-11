// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/move/PlayerOnMap.java

package move;

// 맵에 있는 플레이어 캐릭터 클래스
public class PlayerOnMap
{
	protected int[][] map;
	protected int x, y, minX, minY, maxX, maxY;
	protected final int LEFT = -1, RIGHT = 1, UP = -1, DOWN = 1, STOP = 0;
	protected final int PATH = 0, WALL = 1, CHARACTER = 2;
	protected final String symbol[] = { "  ", "\033[44m  \033[0m", "옷" };
	public PlayerOnMap( int[][] map, int x, int y ) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.minX = 0;
		this.minY = 0;
		this.maxX = ( map == null ) ? 0 : map[0].length-1;
		this.maxY = ( map == null ) ? 0 : map.length-1;
	}

	// 캐릭터 이동
	public void move( int x, int y ) {
		this.x += x;
		this.y += y;

		// 이때, 이동하려는 위치가 허용 범위인지 벽인지 확인
		this.x = ( this.x <= minX ) ? minX : this.x;
		this.y = ( this.y <= minY ) ? minY : this.y;
		this.x = ( this.x >= maxX ) ? maxX : this.x;
		this.y = ( this.y >= maxY ) ? maxY : this.y;

		if( map[this.y][this.x] == WALL ) {
			this.x -= x;
			this.y -= y;
		}
	}

	// 맵에서 캐릭터 위치 표현
	public String toString() {
		String strMap = "\033[1;1f";
		for( int y = minY; y <= maxY; y++ ) {
			for( int x = minY; x <= maxX; x++ ) {
				strMap += symbol[ map[y][x] ];
			}
			strMap += "\n";
		}
		return strMap + this.appear();
	}

	// 캐릭터만 나타나기
	public String appear() {
		return "\033[" + (this.y+1) + ";" + (this.x*2+1) + "f"+ symbol[ CHARACTER ];
	}

	// 캐릭터만 사라지기
	public String disappear() {
		return "\033[" + (this.y+1) + ";" + (this.x*2+1) + "f  ";
	}
}

