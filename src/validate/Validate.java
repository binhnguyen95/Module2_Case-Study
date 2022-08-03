package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String CODE_REGEX = "^(SH|PA|SC|SP)-[\\d]+$";

    public Validate() {
    }

    public Boolean validateCode(String regex) {
        Pattern pattern = Pattern.compile(CODE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
