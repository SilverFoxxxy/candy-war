package ImageSource;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import img.SourceLoader;



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
	public Map <String, ImageIcon> iconSource = new HashMap<>();
	public Map <String, Image> imgSource = new HashMap <>();
	ArrayList <ArrayList <Image> > brickSource = new ArrayList <>();
	
	public void addByPath(String path, String imgID) {
		String defFolder = "res/img/";
		defFolder = "";
		//System.out.println(defFolder + path + ".png");
		imgSource.put(imgID, SourceLoader.loadImage(defFolder + path + ".png"));
		iconSource.put(imgID, new ImageIcon(SourceLoader.loadImage(defFolder + path + ".png")));
	}
	
	public ImageSource() {
		addByPath("start", "Start");
		addByPath("bluebear", "BlueBear");
		addByPath("yellowbear", "YellowBear");
		addByPath("ground", "Chocolate");
		addByPath("dragon1", "Dragon");
		addByPath("fireball1", "FireBall");
		addByPath("bluefireball0", "BlueFireBall");
		addByPath("dragon1", "DragonUnit");
		addByPath("bluebear", "BearUnit");
		addByPath("fireball1", "Cancel");
		addByPath("start", "AtcMain");
		addByPath("atcMainBuild", "AtcMain");
		addByPath("atcTriangle", "AtcTriangle");
		addByPath("defMainBuild", "DefMain");
		addByPath("defTriangle", "DefTriangle");
		addByPath("start", "putUnit");
	}
}
