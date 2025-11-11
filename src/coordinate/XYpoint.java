package coordinate;
import java.lang.Math;	 
public class XYpoint {
    private int x, y;
    public XYpoint( int x, int y ) {
        this.x = x;
        this.y = y;
    }
    public XYpoint() {
        this( 0, 0 );
    }
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
    public boolean equals( XYpoint that ) {
        return ( this.x == that.x) && ( this.y == that.y );
    }
    public double compareTo( XYpoint that ) {
        return Math.sqrt( Math.pow( ( this.x - that.x ), 2 ) + Math.pow( ( this.y - that.y ), 2 ) );
    } 
}