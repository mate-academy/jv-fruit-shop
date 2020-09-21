package parsers;

import core.basesyntax.service.FileService;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class OrderParserTest {
    FileService fileService = new FileService();
    OrderParser orderParser = new OrderParser();

    @Test
    public void orderParserTest() {
        List<String> line = fileService.readFile("src/test/java/resourses/test5.csv");
        String actual = line.get(0);
        String expected = "b,banana,50,2020-10-15";
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void wrongAmountTest() {
        orderParser.parse("s,banana,blablabla,2020-10-17");
    }

    @Test(expected = RuntimeException.class)
    public void wrongDateTest() {
        orderParser.parse("s,banana,121,blablabla");
    }
}
