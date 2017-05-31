package HurtLocker;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vilenalivinsky on 5/31/17.
 */
public class HurtLocker {

    //List<String> parsedObjOutput = new ArrayList<String>();
    String resultString = "";

    public String regexChecker(String theRegex, String str2Check) {

        Pattern checkRegex = Pattern.compile(theRegex, Pattern.CASE_INSENSITIVE);

        Matcher regexMatcher = checkRegex.matcher(str2Check);

        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                resultString+=regexMatcher.group().trim();
                System.out.println(regexMatcher.group().trim());//if there's length then print string & get rid of wspace
            }
            System.out.println("Start index: " + regexMatcher.start());
            System.out.println("End index: " + regexMatcher.end());
        }
        return resultString;
    }

    //String replaces
    public static void regexReplace(String str2Replace) {
        //matching 1 or more spaces
        Pattern replace = Pattern.compile("\\#\\#");  //case sensitive: "[A-Z]+",Pattern.CASE_INSENSITIVE

        Matcher regexMatcher = replace.matcher(str2Replace.trim());

        System.out.println(regexMatcher.replaceAll("\n"));//instead of space put comma and space

    }

    //fix
    public String regexGroups(String input)throws Exception{

        //String theRegex = "((\\w*(\\^|\\;|\\:)((\\w*(\\^|\\;|\\:))))(\\w*(\\^|\\;|\\:)(\\d{1,10}\\.\\d{1,10})(\\^|\\;|\\:))" +
          //      "(\\w*(\\^|\\;|\\:)\\w*(\\^|\\;|\\:))(\\w*(\\^|\\;|\\:)(\\d\\/)(\\d{1,2})(\\/\\d{1,4})))\\#\\#";

        String theRegex = "((\\w*(\\^|\\;|\\:)((\\w*(\\^|\\;|\\:))))(\\w*(\\^|\\;|\\:)(\\d{1,10}\\.\\d{1,10})(\\^|\\;|\\:))" +
                "(\\w*(\\^|\\;|\\:)\\w*(\\^|\\;|\\:))(\\w*(\\^|\\;|\\:)(\\d\\/)(\\d{1,2})(\\/\\d{1,4})))\\#\\#";

        Pattern pattern = Pattern.compile(theRegex, Pattern.CASE_INSENSITIVE);

        //ClassLoader classLoader = getClass().getClassLoader();
        //String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));

        Matcher matcher = pattern.matcher(input);
        String item="";
        String price="";
        String type="";
        String expiration="";
        if(matcher.matches()){
            item = matcher.group(1);
            price = matcher.group(2);
            type = matcher.group(3);
            expiration = matcher.group(4);
        }
        return "item: "+item+"price: "+price+"type: "+"expiration: "+expiration;
    }

}
