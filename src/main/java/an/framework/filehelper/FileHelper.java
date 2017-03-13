package an.framework.filehelper;

import an.object.PageObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

public class FileHelper {

    public static File getImageFile(PageObject pageObject) throws IOException {
        URL url = new URL(pageObject.getFile());
        BufferedImage img = ImageIO.read(url);
        String fileName = new Date().getTime() + ".jpg";
        File file = new File(fileName);
        ImageIO.write(img, "jpg", file);
        return file;
    }

    public static void fileDelete(File file){
        file.delete();
    }
}
