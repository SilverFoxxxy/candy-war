package main;

import main.activities.Point;

//import java.util.Map;

//import main.grui.ElementSource;

public class GrUI {
	//TODO singleton
	public static class Element {
		
		public String name;
		
		String imgID = "Start";
		
		//TODO priority
		//TODO relative coords
		
		//TODO use class Point
		
		double x0, y0;
		
		double w, h;
		
		boolean inOut = true;
		
		public int priority = 0;
		
		boolean isActive = false;
		
		public boolean isButton = false;
		
		boolean isPressed = false;
		
		boolean buttonAdded = false;
		
		public boolean toRemove = false;
		
		//public Map <String, Element> childElem;
		
		//public Map <String, ElementSource> childElemSource;
		
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
		
		public Element(String name, String imgID) {
			DefElem();
			this.name = name;
			this.imgID = imgID;
		}
		
		public Element(String name, double x0, double y0, double w, double h, String imgId) {
			DefElem();
			this.name = name;
			this.x0 = x0;
			this.y0 = y0;
			this.w = w;
			this.h = h;
			this.imgID = imgId;
		}
		
		public Element(String name, double x0, double y0, double w, double h, boolean inOut, String imgId) {
			this.name = name;
			this.x0 = x0;
			this.y0 = y0;
			this.w = w;
			this.h = h;
			this.inOut = inOut;
			this.imgID = imgId;
		}
		
		public Element(String name, double x0, double y0, double w, double h, boolean inOut, String imgId, boolean isButton) {
			this.name = name;
			this.x0 = x0;
			this.y0 = y0;
			this.w = w;
			this.h = h;
			this.inOut = inOut;
			this.imgID = imgId;
			this.isButton = isButton;
		}
		
		public Element(String name, double x0, double y0, double w, double h, boolean inOut, String imgId, boolean isButton, int priority) {
			this.name = name;
			this.x0 = x0;
			this.y0 = y0;
			this.w = w;
			this.h = h;
			this.inOut = inOut;
			this.imgID = imgId;
			this.isButton = isButton;
			this.priority = priority;
		}
		
		public Element copy() {
			Element el = new Element(name, x0, y0, w, h,
					inOut, imgID, isButton, priority);
			return el;
		}
		
		public void getCoords() {}
		
		public void setShape(Point xy0, Point hw) {
			//System.out.println(x0 + " " + y0 + " " + w + " " + h);
			//System.out.println(xy0.x + " " + xy0.y);
			//System.out.println(hw.x + " " + hw.y);
			x0 = hw.x * x0 + xy0.x;
			y0 = hw.y * y0 + xy0.y;
			w = w * hw.x;
			h = h * hw.y;
			//System.out.println("became");
			//System.out.println(x0 + " " + y0 + " " + w + " " + h);
		}
	}
}
