// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/rpsGame/RockPaperScissorsPanel.java

package rpsGame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * 가위바위보 GUI 패널
 * @author So Young Park
 * @version 0.8
 */
public class RockPaperScissorsPanel extends JPanel implements ActionListener
{
	/**
	 * 가위바위보
	 */
	private final int SCISSORS = 0;
	private final int ROCK = 1;
	private final int PAPER = 2;
	/**
	 * 타이머
	 */
	private   Timer timer;
	/**
	 * 가위바위보 참여자의 선택 결과를 이미지로 표현
	 */
	protected JLabel imgPlayerA;
	/**
	 * 가위바위보 상대편의 선택 결과를 이미지로 표현
	 */
	protected JLabel imgPlayerB;
	/**
	 * 가위바위보 참여자와 상대편의 상태를 문자열로 표현
	 */
	protected JLabel strPlayers;
	/**
	 * 가위바위보 버튼
	 */
	protected JButton[] button;
	/**
	 * 가위바위보 3가지, 미선택 1가지, 승패 2가지를 2차원 배열로 고려하여 총 8(=(3+1)*2)가지 경우의 이미지를 준비
	 */
	protected ImageIcon[][] image;
	/**
	 * 가위바위보 기본 이미지 상수
	 */
	protected final int BASE = 0;
	/**
	 * 가위바위보 이겼을 때 이미지 상수
	 */
	protected final int WIN = 1;
	/**
	 * 가위바위보 대기중 물음표 이미지 상수
	 */
	protected final int QUESTIONMARK = 3;
	/**
	 * 가위바위보 GUI 패널 초기화
	 */
	public RockPaperScissorsPanel( final String imgPath )
	{
		// 가위바위보 3가지, 미선택 1가지, 승패 2가지를 2차원 배열로 고려하여 총 8(=(3+1)*2)가지 경우의 이미지를 준비
		image = new ImageIcon[4][2];
		image[QUESTIONMARK][BASE] = new ImageIcon( new ImageIcon( imgPath + "questionmark.gif" ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[QUESTIONMARK][WIN]  = new ImageIcon( new ImageIcon( imgPath + "questionmark.gif" ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[SCISSORS    ][BASE] = new ImageIcon( new ImageIcon( imgPath + "scissors.gif"     ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[SCISSORS    ][WIN]  = new ImageIcon( new ImageIcon( imgPath + "scissors_win.gif" ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[ROCK        ][BASE] = new ImageIcon( new ImageIcon( imgPath + "rock.gif"         ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[ROCK        ][WIN]  = new ImageIcon( new ImageIcon( imgPath + "rock_win.gif"     ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[PAPER       ][BASE] = new ImageIcon( new ImageIcon( imgPath + "paper.gif"        ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[PAPER       ][WIN]  = new ImageIcon( new ImageIcon( imgPath + "paper_win.gif"    ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		// 화면 위쪽에 참여자와 상대편의 가위바위보 이미지 초기화
		this.strPlayers = new JLabel( "<html><body>[너]<br>[나]</body></html>", JLabel.CENTER );
		this.imgPlayerA = new JLabel( image[QUESTIONMARK][BASE] );
		this.imgPlayerB = new JLabel( image[QUESTIONMARK][BASE] );
		this.add( this.imgPlayerB );
		this.add( this.strPlayers );
		this.add( this.imgPlayerA );
		// 화면 아래쪽에 가위바위보 입력 버튼 3개 초기화
		button = new JButton[3];
		button[SCISSORS] = new JButton( new ImageIcon( image[SCISSORS][BASE].getImage().getScaledInstance( 30, 30, Image.SCALE_SMOOTH ) ) );
		button[SCISSORS].addActionListener( this );
		button[ROCK] = new JButton( new ImageIcon( image[ROCK][BASE].getImage().getScaledInstance( 30, 30, Image.SCALE_SMOOTH ) ) );
		button[ROCK].addActionListener( this );
		button[PAPER] = new JButton( new ImageIcon( image[PAPER][BASE].getImage().getScaledInstance( 30, 30, Image.SCALE_SMOOTH ) ) );
		button[PAPER].addActionListener( this );
		this.add( new JLabel("  가위 바위 보를 선택하세요  ") );
		this.add( button[SCISSORS] );
		this.add( button[ROCK] );
		this.add( button[PAPER] );
		this.setBackground(Color.cyan);
		this.setPreferredSize(new Dimension(220, 530));
		// 가위바위보 선택 후 잠깐 1초 쉬었다가 재시작할 수 있도록 타이머 설정
		this.timer = new Timer( 1000, new TimerListener() );
	}
	/**
	 * 참여자가 버튼을 눌러서 선택한 가위바위보 결과를 int형 자료로 변환
	 * @param event 버튼을 눌러서 선택한 결과
	 * @return 가위바위보 선택 결과
	 */
	protected int selectRockPaperScissors( ActionEvent event )
	{
		if( event.getSource() == button[SCISSORS] )
			return SCISSORS;
		else if ( event.getSource() == button[ROCK] )
			return ROCK;
		else
			return PAPER;
	}
	/**
	 * 임의로 가위바위보 중에서 하나를 선택
	 * @return 가위(0), 바위(1), 보(2) 중 임의의 값
	 */
	protected int selectRockPaperScissors()
	{
		return (int)(Math.random()*3);
	}
	/**
	 * 가위바위보 참여자와 상대편의 선택 결과를 바탕으로 승패 판정
	 * @param playerA 가위바위보 참여자의 선택 결과
	 * @param playerB 가위바위보 상대편의 선택 결과
	 * @return 가위바위보 승패 판정 결과
	 */
	protected String judge( int playerA, int playerB )
	{
		if ( playerA == playerB )
		{
			return "상대편과 참여자가 비겼습니다";
		}
		else if ( ( ( playerA == SCISSORS ) && ( playerB == PAPER ) )
				|| ( ( playerA == ROCK ) && ( playerB == SCISSORS ) )
				|| ( ( playerA == PAPER ) && ( playerB == ROCK ) ) )
		{
			return "참여자가 이겼습니다";
		}
		else
		{
			return "상대편이 이겼습니다";
		}
	}
	/**
	 * 가위바위보 선택 결과를 분석하여 누가 이겼는지 표기
	 */
	protected void showGameResult( int playerA, int playerB )
	{
		String result = judge( playerA, playerB );
		int playerA_winOrLose = BASE, playerB_winOrLose = BASE;
		if ( result.contains( "참여자가 이겼습니다" ) )
		{
			playerA_winOrLose = WIN;
			playerB_winOrLose = BASE;
		}
		else if ( result.contains( "상대편이 이겼습니다" ) )
		{
			playerA_winOrLose = BASE;
			playerB_winOrLose = WIN;
		}
		else
		{
			playerA_winOrLose = BASE;
			playerB_winOrLose = BASE;
		}
		imgPlayerA.setIcon( image[ playerA ][ playerA_winOrLose ] );
		imgPlayerB.setIcon( image[ playerB ][ playerB_winOrLose ] );
	}
	public void disableSelection()
	{
		button[0].setEnabled( false );
		button[1].setEnabled( false );
		button[2].setEnabled( false );
	}
	public void enableSelection()
	{
		button[0].setEnabled( true );
		button[1].setEnabled( true );
		button[2].setEnabled( true );
	}
	/**
	 * 참여자가 가위바위보를 선택시 상대편 선택과 비교하여 승패 결과를 제시하고 게임 상황 업데이트
	 * @param event : 참여자의 가위바위보 선택 결과
	 */
	public void actionPerformed( ActionEvent event )
	{
		// 참여자가 먼저 가위바위보 내기
		int playerA = selectRockPaperScissors( event );
		// 상대편도 임의로 가위바위보 내기
		int playerB = selectRockPaperScissors();
		// 승패 결과를 GUI 화면에 업데이트
		showGameResult( playerA, playerB );
		// 다음 판은 잠시 대기
		disableSelection();
		timer.start();
	}
	/**
	 * 타이머 클래스
	 */
	private class TimerListener implements ActionListener
	{
		/**
		 * 잠시 대기후 다음 판 허용
		 */
		public void actionPerformed( ActionEvent event )
		{
			timer.stop();
			imgPlayerB.setIcon( image[QUESTIONMARK][BASE] );
			enableSelection();
		}
	}
}

