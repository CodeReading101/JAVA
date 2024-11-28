// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter19/GenericSort.java


public class GenericSort
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
	// 출력 메서드
	public static <T> void print( T[] list ) {
		for ( T element : list )
			System.out.print( element + " " );
		System.out.println();
	}
	public static void main( String[] args ) {
		// 먼저, 점수 정렬 후 출력
		Integer[] scores = new Integer[]{ 90, 89, 86 };
		sort( scores );
		print( scores );
		String[] words = new String[]{ "carrot", "banana", "apple" };
		// 단어 정렬 후 출력
		sort( words );
		print( words );
	}
}

