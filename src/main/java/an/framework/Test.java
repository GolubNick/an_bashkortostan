package an.framework;

import an.framework.jsoup.GetCaptchaValue;
import an.framework.model.DeputatModel;
import an.framework.webdriver.WebManager;
import an.helpers.GetTextFromCatpchaImage;
import an.object.PageObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Test {

//    private WebManager webManager = WebManager.get();
//    private DeputatModel deputatModel = DeputatModel.get();
//
//    public void startGroSovet(PageObject pageObject){
//        webManager.navigateToUrl("http://gorsovet-ufa.ru/newdeputat/os/" + pageObject.getCategory());
//        deputatModel.setName(pageObject.getFio());
//        deputatModel.setEmail(pageObject.getEmail());
//        deputatModel.setMessage(pageObject.getMessage());
//        deputatModel.setCaptcha(deputatModel.getCaptchaText());
//    }

    public void startGorSovet(PageObject pageObject) throws IOException, URISyntaxException {
        URL url = new URL("http://gorsovet-ufa.ru/newdeputat/os/" + pageObject.getCategory());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("user_name", pageObject.getName()));
        params.add(new BasicNameValuePair("user_email", pageObject.getEmail()));
        params.add(new BasicNameValuePair("MESSAGE", pageObject.getMessage()));
        params.add(new BasicNameValuePair("captcha_word",
                new GetTextFromCatpchaImage().exampleImageToText(new GetCaptchaValue().getURLCaptch(pageObject.getCategory()))));

        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        writer.write(getQuery(params));
        writer.flush();
        writer.close();
        os.close();

        System.out.println(conn.getResponseCode());
        conn.connect();
    }

    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params)
        {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}
