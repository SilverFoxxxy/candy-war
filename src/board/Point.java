package board;

public class Point {
	public double x = 0;
	public double y = 0;
	
	public Point(){
		x = 0;
		y = 0;
	}
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Point mult(double a) {
		return new Point(this.x * a, this.y * a);
	}
	
	public Point add(Point b) {
		return new Point(this.x + b.x, this.y + b.y);
	}
	
	public Point sub(Point b) {
		return new Point(this.x - b.x, this.y - b.y);
	}
	
	public Point Normalize() {
		Point res = new Point(this.x, this.y);
		double len = Math.sqrt(x * x + y * y);
		if (len > 0.0001) {
			res.x /= len;
			res.y /= len;
		}
		return res;
	}
	
	public double len() {
		//return 1;
		return Math.sqrt(x * x + y * y);
		//return (x * x + y * y);
	}
	
	public double dist(Point b) {
		return this.sub(b).len();
	}
	
}
