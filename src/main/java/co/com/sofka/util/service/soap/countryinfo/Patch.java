package co.com.sofka.util.service.soap.countryinfo;


public enum Patch {

    CAPITAL_CITY_REQUEST(System.getProperty("user.dir")
            + "\\src\\test\\resources\\file\\services\\soap\\countryinfo\\request\\capitalcity.xml"),

    lANGUAGE_NAME_REQUEST(System.getProperty("user.dir")
            + "\\src\\test\\resources\\file\\services\\soap\\countryinfo\\request\\languageName.xml");

    private final String value;

    Patch(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
