package main.grui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import main.GrUI.Element;
import main.activities.Point;

public class ElementSource {
	private Vector <Map <String, Element> > elems;
	private Map <String, Element> buttons;
	//public Map <String, ElementSource> childSources;
	
	private void init() {
		elems = new Vector<>(Arrays.asList(new HashMap<>(), new HashMap<>(),
				new HashMap<>(), new HashMap<>(), new HashMap<>(),
				new HashMap<>(), new HashMap<>(), new HashMap<>(),
				new HashMap<>()));
		buttons = new HashMap<>();
		//childSources = new HashMap<>()
	}
	
	public ElementSource() {
		init();
	}
	
	public ElementSource setShape(Point xy0, Point hw) {
		for (Map <String, Element> elemsVec: elems) {
			for (Element el: elemsVec.values()) {
				el.setShape(xy0, hw);
			}
		}
		return this;
	}
	
	public Vector <Map <String, Element> > show() {
		return elems;
	}
	
	public Map <String, Element> showButtons() {
		return buttons;
	}
	
	public void add (Element e) {
		String elname = e.name;
		elems.get(e.priority).put(elname, e);
		if (e.isButton) {
			buttons.put(elname, e);
		}
	}
	
	public void add (String elname, Element e) {
		e.name = elname;
		elems.get(e.priority).put(elname, e);
		if (e.isButton) {
			buttons.put(elname, e);
		}
	}
	
	public void add (Map <String, Element> els) {
		for (String elname: els.keySet()) {
			Element e = els.get(elname);
			add(elname, e);
		}
	}
	
	public void add (ElementSource elemSource) {
		Vector <Map<String, Element> > elemsVec = elemSource.show();
		for (Map <String, Element> m: elemsVec) {
			add(m);
		}
	}
	
	public ElementSource copy () {
		ElementSource req = new ElementSource();
		Vector <Map<String, Element> > elemsVec = this.show();
		for (Map <String, Element> m: elemsVec) {
			for (Element el: m.values()) {
				req.add(el.copy());
			}
		}
		return req;
	}
	
	public void remove(Element e) {
		String elname = e.name;
		if (elems.get(e.priority).containsKey(elname)) {
			elems.get(e.priority).remove(elname);
		}
		if (buttons.containsKey(elname)) {
			buttons.remove(elname);
		}
	}
	
	public void remove(Map <String, Element> els) {
		for (String elname: els.keySet()) {
			Element e = els.get(elname);
			remove(e);
		}
	}
	
	public void remove(String name) {
		for (Map <String, Element> m: elems) {
			if (m.containsKey(name)) {
				m.remove(name);
			}
		}
	}
	
	public void clear() {
		for (Map <String, Element> m: elems) {
			m.clear();
		}
		buttons.clear();
	}
}
