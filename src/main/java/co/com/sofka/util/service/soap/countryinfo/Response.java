package co.com.sofka.util.service.soap.countryinfo;

public enum Response {
    CAPITAL_CITY_RESPONSE("<m:CapitalCityResult>%s</m:CapitalCityResult>"),
    LANGUAGE_NAME_RESPONSE("<m:LanguageNameResult>%s</m:LanguageNameResult>"),
    ERROR_SERVER_RESPONSE("Server Error");

    private final String value;

    Response(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
