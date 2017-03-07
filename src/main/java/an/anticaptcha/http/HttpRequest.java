package an.anticaptcha.http;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String url;
    private String postRaw;
    private Integer timeout = 60000; // milliseconds
    private Integer maxBodySize = 0; // 0 = unlimited, in bytes
    private boolean followRedirects = true; // does not work now due to moving from JSOUP to ApacheHttpClient
    private boolean validateTLSCertificates = false;
    private Map<String, String> proxy = null; //new HashMap<String, String>() {{put("host", "192.168.0.168"); put("port", "8888");}};
    private Map<String, String> cookies = new HashMap<String, String>();
    private Map<String, String> headers = new HashMap<String, String>()
    {{
        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        put("Accept-Encoding", "gzip, deflate, sdch");
        put("Accept-Language", "ru-RU,en;q=0.8,ru;q=0.6");
    }};

    public HttpRequest(String url) {
        this.url = url;
    }

    public boolean isValidateTLSCertificates() {
        return validateTLSCertificates;
    }

    public String getUrl() {
        return url;
    }

    public String getRawPost() {
        return postRaw;
    }

    public Map<String, String> getProxy() {
        return proxy;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public boolean isFollowRedirects() {
        return followRedirects;
    }

    public Integer getMaxBodySize() {
        return maxBodySize;
    }

    public void setRawPost(String post) {
        this.postRaw = post;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }
}