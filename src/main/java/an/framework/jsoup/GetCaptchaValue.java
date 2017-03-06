package an.framework.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class GetCaptchaValue {

    public String getURLCaptch(String deputat) throws IOException {
        Document doc = Jsoup.connect("http://gorsovet-ufa.ru/newdeputat/os/" + deputat).get();
        return "http://gorsovet-ufa.ru" + doc.select(".mf-captcha").select("img").get(0).attr("src").toString();
    }
}
