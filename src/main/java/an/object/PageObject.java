package an.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageObject {
    @JsonProperty("category")
    private String category;

    @JsonProperty("fio")
    private String fio;

    @JsonProperty("email")
    private String email;

    @JsonProperty("message")
    private String message;

    @JsonProperty("name")
    private String name;

    @JsonProperty("sirname")
    private String sirname;

    @JsonProperty("fathername")
    private String fathername;

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty("address")
    private String address;

    public String getDeputy() {
        return deputy;
    }

    @JsonProperty("deputy")
    private String deputy;

    public String getName() {
        return name;
    }

    public String getSirname() {
        return sirname;
    }

    public String getFathername() {
        return fathername;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getFile() {
        return file;
    }

    @JsonProperty("file")
    private String file;

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
