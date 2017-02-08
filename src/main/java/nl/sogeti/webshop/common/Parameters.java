package nl.sogeti.webshop.common;

/**
 * Created by ikikuchi on 16-1-2017.
 */
public enum Parameters {

    TEST("default");

    private String defaultValue;

    private Parameters(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getValue() {
        String sysPropValue = System.getProperty(this.toString());
        return sysPropValue != null ? sysPropValue : this.defaultValue;
    }

    public int getIntValue() {
        return Integer.valueOf(this.getValue());
    }
}
