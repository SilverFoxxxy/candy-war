package main;

public class GrUI {
	// singleton
	public static class Element {
		// use class Point
		double x0, y0;
		double w, h;
		boolean inOut = true;
		int imgID = -1;
		boolean isActive = false;
		boolean isButton = false;
		boolean isPressed = false;
		boolean buttonAdded = false;
		boolean toRemove = false;
		public String name;
		private void DefElem() {
			this.x0 = 0;
			this.y0 = 0;
			this.w = 1;
			this.h = 1;
			this.inOut = true;
			isActive = false;
			isButton = false;
			isPressed = false;
			buttonAdded = false;
		}
		public Element(String name, int imgID) {
			DefElem();
			this.name = name;
			this.imgID = imgID;
		}
		public Element(String name, double x0, double y0, double w, double h, int imgId) {
			DefElem();
			this.name = name;
			this.x0 = x0;
			this.y0 = y0;
			this.w = w;
			this.h = h;
			this.imgID = imgId;
		}
		public Element(String name, double x0, double y0, double w, double h, boolean inOut, int imgId) {
			this.name = name;
			this.x0 = x0;
			this.y0 = y0;
			this.w = w;
			this.h = h;
			this.inOut = inOut;
			this.imgID = imgId;
		}
		public Element(String name, double x0, double y0, double w, double h, boolean inOut, int imgId, boolean isButton) {
			this.name = name;
			this.x0 = x0;
			this.y0 = y0;
			this.w = w;
			this.h = h;
			this.inOut = inOut;
			this.imgID = imgId;
			this.isButton = isButton;
		}
		public void getCoords() {}
	}
}
