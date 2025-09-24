// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter14/TopViewGUI.java

import javax.swing.*;
import move.TopViewObject;
import move.ViewPanel;

public class TopViewGUI
{
	public static void main( String[] args )
	{
		final String imagePath = "C:\\Users\\user\\Downloads\\JAVA-main\\src\\move\\image\\";
		// 미로 맵을 2차원 배열로 초기화
		int[][] map = { { 1,1,1,1,1,1,1 },
		                { 1,0,0,1,0,0,1 },
		                { 1,1,0,1,0,1,1 },
		                { 1,0,0,1,0,0,1 },
		                { 1,0,1,1,1,0,1 },
		                { 1,0,0,0,0,0,1 },
		                { 1,1,1,1,1,1,1 }
		              };

		// 판을 틀에 끼우고 실행 준비 완료
		ViewPanel panel = new ViewPanel( new TopViewObject( map, 1, 1, imagePath ) );
		JFrame frame = new JFrame( "탑 뷰 맵" );
		frame.getContentPane().add( panel );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible(true);
	}
}


