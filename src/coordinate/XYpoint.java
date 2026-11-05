// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/coordinate/XYpoint.java

package coordinate;
// XYpoint 클래스
public class XYpoint
{
	private int x, y;
	// 점의 좌표값을 초기화
	public XYpoint( int x, int y ) {
		this.x = x;
		this.y = y;
	}
	public XYpoint() {
		this( 0, 0 );
	}
	// 점을 문자열 (x,y)로 표현
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	// 두 점이 같은지 비교
	public boolean equals( XYpoint that ) {
		return ( this.x == that.x ) && ( this.y == that.y );
	}
	// 두 점 사이의 거리를 계산
	public double compareTo( XYpoint that ) {
		return Math.sqrt( Math.pow( ( this.x - that.x ), 2 ) + Math.pow( ( this.y - that.y ), 2 ) );
	}
}

