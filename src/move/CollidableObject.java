// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/move/CollidableObject.java

package move;
// 충돌가능한 객체
public class CollidableObject extends ObjectByKey
{
	// 캐릭터 초기화 : 이미지, 현재 위치, 이동 허용 범위를 설정
	public CollidableObject( final String image, int x, int y, int width, int height ) {
		super( image, x, y, 0, 20, width, height );
	}
	public CollidableObject( int directionX, int directionY, final String image, int width, int height ) {
		this( image, 0, 40, width, height );
		this.directionX = directionX;
		this.directionY = directionY;
		// 폭탄 초기화 : 위쪽(임의위치)에서 아래쪽으로 폭탄을 투하
		if ( ( directionX == STOP ) && ( directionY == DOWN ) ) {
			this.x = (int)( Math.random() * this.maxX );
		}
		// 총알 초기화 : 왼쪽(임의위치)에서 오른쪽으로 총알을 발사
		else if ( ( directionX == RIGHT ) && ( directionY == STOP ) ) {
			this.y = 40 + (int)( Math.random() * ( this.maxY-40 ) );
		}
	}
	// 일정 속도 위치 이동
	public void move( int directionX, int directionY ) {
		final int SPEED = 20;
		super.move( directionX * SPEED, directionY * SPEED );
	}
	// 이동 허용 범위를 벗어나거나 다른 객체와 충돌하는지 여부 확인
	public boolean collide() {
		return ( this.x < minX ) || ( maxX < this.x ) || ( this.y < minY ) || ( maxY < this.y );
	}
	public boolean collide( ObjectByKey that ) {
		return ( Math.abs( this.x - that.x ) < IMGSIZE ) && ( Math.abs( this.y - that.y ) < IMGSIZE );
	}
}

