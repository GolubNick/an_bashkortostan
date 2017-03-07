package an.anticaptcha.http;

import org.apache.http.Header;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private String body = null;
    private Map<String, String> headers = new HashMap<String, String>();
    private Map<String, String> cookies = new HashMap<String, String>();

    public HttpResponse(String body, org.apache.http.HttpResponse apacheHttpResponse, HttpClientContext apacheHttpContext) {

        this.body = body;

        // HEADERS
        for (Header header : apacheHttpResponse.getAllHeaders()) {
            headers.put(header.getName(), header.getValue());
        }

        // COOKIES
        for (Cookie cookie : apacheHttpContext.getCookieStore().getCookies()) {
            cookies.put(cookie.getName(), cookie.getValue());
        }
    }

    public String getBody() {
        return body;
    }

}
