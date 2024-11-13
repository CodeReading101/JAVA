// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter15/CardMatchingGUI.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// 카드
class Card extends JButton {
	private Color color;
	// 카드 초기화
	public Card( Color color ) {
		super();
		this.color = color;
		this.setBackground( Color.white );
		this.setBorder( null );
	}
	// 카드를 선택하면 카드 앞면
	public void selected() {
		this.setEnabled( false );
		this.setBackground( this.color );
	}
	// 카드를 선택해제하면 카드 뒤면
	public void unselected() {
		this.setEnabled( true );
		this.setBackground( Color.white );
	}
	public Color color() {
		return this.color;
	}
	public boolean equals( Color color ) {
		return ( this.color == color );
	}
}
// 카드 스레드
class CardFlipThread extends Thread {
	private Card card1, card2;
	// 카드 스레드 초기화
	public CardFlipThread( Card card1, Card card2 ) {
		this.card1 = card1;
		this.card2 = card2;
	}
	// (색이 다르면) 0.5초 후 두 카드를 선택해제
	@Override
	public void run() {
		try {
			Thread.sleep( 500 );
			card1.unselected();
			card2.unselected();
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}
}
// 카드 색 맞추기 패널
class CardMatchingPanel extends JPanel {
	protected Card[][] card;
	protected Card card1, card2;
	// 카드를 패널에 배치하여 초기화
	public CardMatchingPanel( int[][] color ) {
		this.card1 = null;
		this.card2 = null;
		this.card = new Card[color.length][color[0].length];
		Color[] palette = { Color.pink, Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.cyan, Color.gray };
		for( int y=0; y < card.length; y++ ){
			for( int x=0; x < card[0].length; x++ ){
				card[y][x] = new Card( palette[ color[y][x] ] );
				card[y][x].addActionListener( new CardListener() );
				add( card[y][x] );
			}
		}
		setLayout( new GridLayout( color.length, color[0].length ) );
		setPreferredSize( new Dimension( 400, 400 ) );
		setFocusable( true );
		requestFocus();
	}
	// 카드 두 장을 선택
	private class CardListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			// 첫번째 카드 선택
			if ( card1 == null  ) {
				card1 = (Card)event.getSource();
				card1.selected();
				return;
			}
			// 두번째 카드 선택
			card2 = (Card)event.getSource();
			card2.selected();
			// 서로 색이 같으면 카드 선택을 유지하고, 다르면 카드 선택을 해제
			if ( !card1.equals(
			                    card2.color() ) ) {
				Thread cardFlip = new CardFlipThread( card1, card2 );
				cardFlip.start();
			}
			// 새로운 카드 두 장을 선택할 수 있도록 준비
			card1 = null;
			card2 = null;
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
		// 프레임 준비
		JFrame frame = new JFrame ( "같은 색깔 찾기" );
		// 패널 준비
		CardMatchingPanel panel = new CardMatchingPanel( color );
		// 프레임에 패널을 끼우고 이벤트를 대기
		frame.getContentPane().add( panel );
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}

