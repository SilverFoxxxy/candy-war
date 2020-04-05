package main.sheet;

import java.awt.Image;

public class Button {
	String name;
	double x0, y0, h, w;
	Image img;
	int imgId = -1;
	boolean tap;
	public Button(String name, double x0, double y0, double h, double w, Image img) {
		this.name = name;
		this.x0 = x0;
		this.y0 = y0;
		this.h = h;
		this.w = w;
		this.img = img;
		this.tap = false;
	}
}
