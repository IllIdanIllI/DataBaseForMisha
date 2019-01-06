package regex;

public class CheckImput {
    public static String checkIntInput(String input) {
        if (input.matches(Regular.getYEARVALID())) {
            return input;
        } else {
            return "-1";
        }
    }
    public static String checkStringInput(String input) {
        if (input.matches(Regular.getSTRINGVALID())){
            return input;
        } else {
            return "-1";
        }
    }
}
