import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class demo {
    public static void main(String[] args) {
        String re = "\\w\\W";
        /*regex pattern 
        METACHARACTER
        . = is for any SINGLE character 
        \\w = word char 
        \\W = non word char
        \\s = whitespace char
        \\S = non-space
        \\d = digits
        \\D = non digits

        CLASS
        [ab] = a or b
        [^ab] = not a or b
        [a-z] = a to z
        [a-f[m-z]] = (union) a to f or m to z
        [a-z&&[def]] = d or e or f
        [a-z&&[^bc]] = a-z but not b or c
        [a-z&&[^m-p]] = a-z but not m to p

        QUANTIFIER
        [AB]? = A OR B APPEARS ONCE OR NOT AT ALL 
        [AB]+ = A OR B APPEARS ONCE OR MORE THAN 1
        [AB]* = A OR B WONT APPEAR OR APPEAR MORE TIMES
        D? = non-digit that apprears once or not at all


        */
        String text = "d@";

        Pattern pt = Pattern.compile(re);
        Matcher mt = pt.matcher(text);

        boolean result = mt.matches();
        System.out.println(Pattern.matches("^[a-zA-Z]+\\s[a-zA-Z]+$","n B"));

    }
}
