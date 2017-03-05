package an.helpers;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class GetTextFromCatpchaImage {

    public static String exampleImageToText(String url) {
        String captchaValue = "";
        DebugHelper.setVerboseMode(true);

        ImageToText api = new ImageToText();
        api.setClientKey("930b161fd1c1e4e4ec53016b41d50df3");
        api.setFilePath(convertImageToBase64(url,"jpg"));
        try {
            if (!api.createTask()) {
                DebugHelper.out(
                        "API v2 send failed. " + api.getErrorMessage(),
                        DebugHelper.Type.ERROR
                );
            } else if (!api.waitForResult()) {
                DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
            } else {
                DebugHelper.out("Result: " + api.getTaskSolution(), DebugHelper.Type.SUCCESS);
                captchaValue = api.getTaskSolution();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return captchaValue;
    }

    public static String convertImageToBase64(String urlString, String type ){

        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            URL url = new URL(urlString);
            BufferedImage img = ImageIO.read(url);

            ImageIO.write(img, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
}
