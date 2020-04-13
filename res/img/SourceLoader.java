package img;

import java.awt.Image;
import java.awt.Toolkit;

public class SourceLoader {
    static SourceLoader rl = new SourceLoader();
     
    public static Image loadImage(String imageName)
    {
        return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource(imageName));
    }
}
