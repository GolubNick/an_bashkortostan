package an.helpers;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageToText extends AnticaptchaBase {
    private Boolean phrase;
    private Boolean case_;
    private Boolean numeric;
    private Integer math;
    private Integer minLenght;
    private Integer maxLength;
    private String bodyBase64;

    public void setFilePath(String filePath) {
        bodyBase64 = filePath;
    }

    public JSONObject getPostData() {

        if (bodyBase64 == null || bodyBase64.length() == 0) {
            return null;
        }

        JSONObject postData = new JSONObject();

        try {
            postData.put("type", "ImageToTextTask");
            postData.put("body", bodyBase64.replace("\r", "").replace("\n", ""));
            postData.put("phrase", phrase);
            postData.put("case", case_);
            postData.put("numeric", numeric);
            postData.put("math", math);
            postData.put("minLength", minLenght);
            postData.put("maxLength", maxLength);
        } catch (JSONException e) {
            DebugHelper.out("JSON compilation error: " + e.getMessage(), DebugHelper.Type.ERROR);

            return null;
        }

        return postData;
    }

    public String getTaskSolution() {
        return taskInfo.getSolution().getText();
    }
}
