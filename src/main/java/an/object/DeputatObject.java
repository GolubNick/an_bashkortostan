package an.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeputatObject {
    @JsonProperty("category")
    private String category;
    @JsonProperty("fio")
    private String fio;
    @JsonProperty("email")
    private String email;
    @JsonProperty("message")
    private String message;

    public String getCategory() {
        return category;
    }

    public String getFio() {
        return fio;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }
}
