package main.activities;

public class RelatedRectangle {
	public Point coords;
	public Point shape;
	boolean inOut;
	public RelatedRectangle(Point coords0, Point shape0, boolean inOut0) {
		coords = coords0;
		shape = shape0;
		inOut = inOut0;
	}
	
	public RelatedRectangle putIn(RelatedRectangle r) {
		RelatedRectangle rect;
		
		if (inOut) {
			
		} else {
			
		}
		rect = new RelatedRectangle(
					r.coords.add(new Point(r.shape.x * shape.x, r.shape.y * shape.y)),
					new Point(r.shape.x * shape.x, r.shape.y * shape.y),
					this.inOut);
		return rect;
	}
}
