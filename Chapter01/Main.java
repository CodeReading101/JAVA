import java.util.Scanner;

class Perimeter {
	private final double PI = 3.141592;

	public double calculateRunningTrack( int width, int height ) {	
		double perimeter = 2 * width + calculateCircumference( height );
		return perimeter;
	}

	private double calculateCircumference( int diameter ) {
		double circumference = PI * diameter;
		return circumference;
	}
}

public class Main {
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		System.out.print("트랙의 가로길이를 입력하세요: ");
		int width = scan.nextInt();
		System.out.print("트랙의 세로길이를 입력하세요: ");
		int height = scan.nextInt();
	
		Perimeter perimeter = new Perimeter();
		double y = perimeter.calculateRunningTrack( width, height );
		System.out.println("트랙의 둘레는 " + y + "입니다");
	}
}