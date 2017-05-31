package HurtLockerTest;

import HurtLocker.HurtLocker;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vilenalivinsky on 5/31/17.
 */
public class HurtLockerTest {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    @Test
    public void stringCheckerTest()throws Exception{

        //Given
        String regex = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        HurtLocker myChecker = new HurtLocker();
        String output = (new HurtLockerTest()).readRawDataToString();
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        //When
        String actual = myChecker.regexChecker(regex,output);
        //Then
        Assert.assertEquals("The two string outputs are equal",expected,actual);
    }

    @Test
    public void regexPartialStringCheckerTest()throws Exception{

        //Given
        String regex = "((\\w*(\\^|\\;|\\:)\\w*(\\^|\\;|\\:))(\\w*(\\^|\\;|\\:)(\\d\\/)(\\d{1,2})(\\/\\d{1,4})))\\#\\#";
        HurtLocker myChecker = new HurtLocker();
        String output = (new HurtLockerTest()).readRawDataToString();
        String expected = "type:Food;expiration:1/25/2016##";
        //When
        String actual = myChecker.regexChecker(regex,output);
        //Then
        Assert.assertEquals("Matches objects from 'type'...to end of string (ie, date)",expected,actual);
    }

    @Test
    public void regexWholeStringCheckerTest()throws Exception{

        //Given
        String regex = "((\\w*(\\^|\\;|\\:)((\\w*(\\^|\\;|\\:))))(\\w*(\\^|\\;|\\:)(\\d{1,10}\\.\\d{1,10})(\\^|\\;|\\:))" +
                "(\\w*(\\^|\\;|\\:)\\w*(\\^|\\;|\\:))(\\w*(\\^|\\;|\\:)(\\d\\/)(\\d{1,2})(\\/\\d{1,4})))\\#\\#";
        HurtLocker myChecker = new HurtLocker();
        String output = (new HurtLockerTest()).readRawDataToString();
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        //When
        String actual = myChecker.regexChecker(regex,output);
        //Then
        Assert.assertEquals("Matches all string objects",expected,actual);
    }

    //@Test

}

