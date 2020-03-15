import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String afterParse = hamletParser.parseHamletToLeon(hamletText);
        Assert.assertFalse(hamletParser.findHamlet(afterParse));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String afterParse = hamletParser.parseHoratioToTariq(hamletText);
        Assert.assertFalse(hamletParser.findHoratio(afterParse));
    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(hamletParser.findHoratio(hamletText));
        String afterParse = hamletParser.parseHoratioToTariq(hamletText);
        Assert.assertFalse(hamletParser.findHoratio(afterParse));
    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(hamletParser.findHamlet(hamletText));
        String afterParse = hamletParser.parseHamletToLeon(hamletText);
        Assert.assertFalse(hamletParser.findHamlet(afterParse));
    }

    @Test
    public void findPatternTest(){
        Assert.assertTrue(hamletParser.findPattern("this is funny","is"));
    }
    @Test
    public void findPatternTest2(){
        Assert.assertTrue(hamletParser.findPattern("this is not funny","is", "not"));
    }
    @Test
    public void findPatternTest3(){
        Assert.assertTrue(hamletParser.findPattern("this is not funny","is", "hello"));
    }
    @Test
    public void findPatternTest4(){
        Assert.assertFalse(hamletParser.findPattern("this is not funny", "hello"));
    }

}