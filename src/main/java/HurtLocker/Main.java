package HurtLocker;

import org.apache.commons.io.IOUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

        HurtLocker checker = new HurtLocker();
        checker.regexChecker("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##", output);

        System.out.println(checker.resultString);

        checker.regexChecker("((\\w*(\\^|\\;|\\:)\\w*(\\^|\\;|\\:))(\\w*(\\^|\\;|\\:)(\\d\\/)(\\d{1,2})(\\/\\d{1,4})))\\#\\#", output);

        checker.regexReplace(checker.resultString);

        //gets all objects
        checker.regexChecker("((\\w*(\\^|\\;|\\:)((\\w*(\\^|\\;|\\:))))(\\w*(\\^|\\;|\\:)(\\d{1,10}\\.\\d{1,10})(\\^|\\;|\\:))" +
                "(\\w*(\\^|\\;|\\:)\\w*(\\^|\\;|\\:))(\\w*(\\^|\\;|\\:)(\\d\\/)(\\d{1,2})(\\/\\d{1,4})))\\#\\#", output);

        checker.regexReplace(checker.resultString);

        //checker.regexGroups(checker.resultString);

        //

    }



}
