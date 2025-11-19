// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter19/GenericMethodMain.java


public class GenericMethodMain
{
	// 정렬
	public static <T extends Comparable<T>> void sort( T[] list ) {
		// 마지막 칸에 가장 큰 값을 저장하면서 한칸씩 앞으로 영역 좁혀가기
		for ( int last = list.length - 1; last >= 0; last-- ) {
			// 영역의 첫번째 칸부터 인접한 두 값을 비교하면서
			for ( int index = 0; index < last; index++ ) {
				// 앞이 뒤보다 크면 두 값을 맞바꾸기하면서 뒤쪽에 큰 값을 저장
				if ( list[ index ].compareTo( list[ index + 1 ] ) > 0 ) {
					T temp = list[ index ];
					list[ index ] = list[ index + 1 ];
					list[ index + 1 ] = temp;
				}
			}
		}
	}
	public static void main( String[] args ) {
		// 먼저, 점수 정렬 후 출력
		Integer[] scores = new Integer[]{ 90, 89, 86 };
		sort( scores );
		for( int score : scores )
		    System.out.print( score + " "  );
		System.out.println();
		// 단어 정렬 후 출력
		String[] words = new String[]{ "carrot", "banana", "apple" };
		sort( words );
		for( String word : words )
		    System.out.print( word + " "  );
	}
}

