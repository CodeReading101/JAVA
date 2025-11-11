// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/move/PlayerOnZoomMap.java

package move;
// 맵에 있는 플레이어 캐릭터 클래스
public class PlayerOnZoomMap extends PlayerOnMap
{
	public static final int SCOPE = 3;
	public PlayerOnZoomMap( int[][] map, int x, int y ) {
		super( map, x, y );
	}
	// 캐릭터와 주변 맵을 표현
	public String toString() {
		String zoomMap = "\033[1;1f";
		for( int y = this.y - SCOPE, offsetY = y; y <= this.y + SCOPE; y++ ){
			for( int x = this.x - SCOPE, offsetX = x; x <= this.x + SCOPE; x++ ){
				int index = WALL;
				if ( ( x == this.x ) && ( y == this.y ) )
					index = CHARACTER;
				else if ( ( 0 <= x ) && ( x <= maxX ) && ( 0 <= y ) && ( y <= maxY ) )
					index = map[y][x];
				zoomMap += symbol[ index ];
			}
			zoomMap += "\n";
		}
		return zoomMap;
	}
}

