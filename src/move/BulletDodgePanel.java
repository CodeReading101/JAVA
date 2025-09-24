// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/move/BulletDodgePanel.java

package move;
import java.awt.*;

// 총알 피하기 패널
public class BulletDodgePanel extends BombDodgePanel
{
	public BulletDodgePanel( CollidableObject character, final String imageBomb ) {
		super( character, imageBomb );
		setPreferredSize( new Dimension( width, height+40 ) );
	}

	// 최신 정보 업데이트
	protected void update() {
		// 모든 총알은 오른쪽으로 이동하며, 일정 시간마다 새 총알을 발사
		for ( CollidableObject bomb : bombs )
			bomb.move();
		if ( ( ( time-- ) % 8 ) == 0 ) {
			bombs.add( new CollidableObject( CollidableObject.RIGHT, CollidableObject.STOP, imageBomb, width, height ) );
		}

		// 캐릭터는 이동하고 HP 업데이트
		character.move( CollidableObject.STOP, character.directionY() );
		updateHP();
	}
}

