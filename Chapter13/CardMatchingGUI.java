// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter13/CardMatchingGUI.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// 카드 클래스
class Card extends JButton {
	private Color color;
	// 카드 초기화
	public Card( Color color ) {
		super();
		this.color = color;
		this.setBackground( Color.white );
	}
	// 카드 선택시 카드 앞면(색) 제시
	public void selected() {
		this.setEnabled( false );
		this.setBackground( this.color );
	}
	// 카드 해제시 카드 뒤면(흰색) 제시
	public void unselected() {
		this.setEnabled( true );
		this.setBackground( Color.white );
	}
	// 카드 색
	public Color color() {
		return this.color;
	}
}
// 카드 색 맞추기 클래스
class CardMatchingBoard extends JPanel {
	protected Card card1, card2;
	// 16장의 카드를 보드에 배치
	public CardMatchingBoard( int[][] color ) {
		card1 = null;
		card2 = null;
		setLayout( new GridLayout( color.length, color[0].length ) );
		setPreferredSize( new Dimension( 400, 400 ) );
		setFocusable( true );
		requestFocus();
		Card[][] card = new Card[color.length][color[0].length];
		ClickListener click = new ClickListener();
		Color[] palette = { Color.pink, Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.cyan, Color.gray };
		for( int y=0; y < card.length; y++ ){
			for( int x=0; x < card[0].length; x++ ){
				card[y][x] = new Card( palette[ color[y][x] ] );
				card[y][x].addActionListener( click );
				add( card[y][x] );
			}
		}
	}
	// 카드 클릭
	private class ClickListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			// 기존 두 장의 카드 색이 같으면 선택 유지하고, 다르면 선택 해제
			if ( ( card1 != null ) && ( card2 != null ) ) {
				if ( !card1.color().equals( card2.color() ) ) {
					card1.unselected();
					card2.unselected();
				}
				// 새로운 카드 두 장을 선택할 수 있도록 준비
				card1 = null;
				card2 = null;
			}
			// 첫번째 카드 선택
			if ( card1 == null  ) {
				card1 = (Card)event.getSource();
				card1.selected();
			}
			// 두번째 카드 선택
			else if ( card2 == null  ) {
				card2 = (Card)event.getSource();
				card2.selected();
			}
		}
	}
}

public class CardMatchingGUI
{
	public static void main(String[] args)
	{
		final int[][] color = { { 0, 1, 2, 7 },
		                        { 3, 5, 6, 0 },
		                        { 2, 4, 6, 3 },
		                        { 4, 5, 1, 7 } };
		// 틀에 판을 끼우고 실행 준비 완료
		JFrame frame = new JFrame ( "같은 색깔 찾기" );
		frame.getContentPane().add( new CardMatchingBoard( color ) );
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}

