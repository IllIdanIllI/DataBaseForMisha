package regex;

public class Regular {
    private final static String YEARVALID = "\\d*";
    private static String STRINGVALID = "[a-zA-Z0-9]*";

    public static String getYEARVALID() {
        return YEARVALID;
    }

    public static String getSTRINGVALID() {
        return STRINGVALID;
    }
}
