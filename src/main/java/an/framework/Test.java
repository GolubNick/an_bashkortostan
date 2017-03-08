package an.framework;

import an.framework.model.DeputatModel;
import an.framework.model.ProkuraturaModel;
import an.framework.webdriver.WebManager;
import an.object.PageObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.util.Date;

public class Test {

    private WebManager webManager = WebManager.get();
    private DeputatModel deputatModel = DeputatModel.get();
    private ProkuraturaModel prokuraturaModel = ProkuraturaModel.get();

    public void startGroSovet(PageObject pageObject){
//        webManager.navigateToUrl("http://gorsovet-ufa.ru/newdeputat/os/" + pageObject.getCategory().split("_")[2] + ".php");
        webManager.getUrl("http://gorsovet-ufa.ru/newdeputat/os/" + pageObject.getCategory().split("_")[2] + ".php");
        deputatModel.setName(pageObject.getName());
        deputatModel.setEmail(pageObject.getEmail());
        deputatModel.setMessage(pageObject.getMessage());
        deputatModel.setCaptcha(deputatModel.getCaptchaText());
    }

    public void startBashProk(PageObject pageObject) throws IOException {
        webManager.navigateToUrl("http://bashprok.ru/internet_reception/" );
        prokuraturaModel.setName(pageObject.getName());
        prokuraturaModel.setSirname(pageObject.getSirname());
        if (!pageObject.getFathername().isEmpty())
            prokuraturaModel.setFathername(pageObject.getFathername());
        prokuraturaModel.setEmail(pageObject.getEmail());
        prokuraturaModel.setTelnumber(pageObject.getTelephone());
        prokuraturaModel.setAddresss(pageObject.getAddress());
        prokuraturaModel.setMessage(pageObject.getMessage());

        URL url = new URL(pageObject.getFile());
        BufferedImage img = ImageIO.read(url);
        String fileName = new Date().getTime() + ".jpg";
        File file = new File(fileName);
        ImageIO.write(img, "jpg", file);

        prokuraturaModel.setUploadImage(file.getAbsolutePath());
        prokuraturaModel.setCaptcha(prokuraturaModel.getCaptchaText());
        file.delete();
    }

//    public void startGorSovet(PageObject pageObject) throws IOException, URISyntaxException {
//        URL url = new URL("http://gorsovet-ufa.ru/newdeputat/os/" + pageObject.getCategory());
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setReadTimeout(10000);
//        conn.setConnectTimeout(15000);
//        conn.setRequestMethod("POST");
//        conn.setDoInput(true);
//        conn.setDoOutput(true);
//
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("user_name", pageObject.getName()));
//        params.add(new BasicNameValuePair("user_email", pageObject.getEmail()));
//        params.add(new BasicNameValuePair("MESSAGE", pageObject.getMessage()));
//        params.add(new BasicNameValuePair("captcha_word",
//                new GetTextFromCatpchaImage().exampleImageToText(new GetCaptchaValue().getURLCaptch(pageObject.getCategory()))));
//
//        OutputStream os = conn.getOutputStream();
//        BufferedWriter writer = new BufferedWriter(
//                new OutputStreamWriter(os, "UTF-8"));
//        writer.write(getQuery(params));
//        writer.flush();
//        writer.close();
//        os.close();
//        String response = null;
//        int responseCode = 0;
////        System.out.println(conn.getResponseCode());
//        responseCode = conn.getResponseCode();
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            String line;
//            BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            while ((line=br.readLine()) != null) {
//                response+=line;
//            }
//        }
//        else {
//            response="";
//
//        }
//        conn.connect();
//    }
//
//    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
//        StringBuilder result = new StringBuilder();
//        boolean first = true;
//
//        for (NameValuePair pair : params)
//        {
//            if (first)
//                first = false;
//            else
//                result.append("&");
//
//            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
//            result.append("=");
//            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
//        }
//
//        return result.toString();
//    }
}
