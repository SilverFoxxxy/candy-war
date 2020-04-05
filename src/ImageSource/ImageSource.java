package ImageSource;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ImageSource {
	// singleton
	/*public enum PageType {
	    ABOUT(1),
	    CODING(2),
	    DATABASES(3);

	    private int value;
	    private static Map map = new HashMap<>();

	    private PageType(int value) {
	        this.value = value;
	    }

	    static {
	        for (PageType pageType : PageType.values()) {
	            map.put(pageType.value, pageType);
	        }
	    }

	    public static PageType valueOf(int pageType) {
	        return (PageType) map.get(pageType);
	    }

	    public int getValue() {
	        return value;
	    }
	}*/
	public ArrayList <ImageIcon> iconSource = new ArrayList<>();
	public ArrayList <Image> imgSource = new ArrayList <>();
	ArrayList <ArrayList <Image> > brickSource = new ArrayList <>();
	public ImageSource() {
		imgSource.add(new ImageIcon("res/img/start.png").getImage());
		iconSource.add(new ImageIcon("res/img/start.png"));
	}
}
