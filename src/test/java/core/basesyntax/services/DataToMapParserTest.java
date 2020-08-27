package core.basesyntax.services;

import core.basesyntax.services.operations.Buy;
import core.basesyntax.services.operations.Operable;
import core.basesyntax.services.operations.Return;
import core.basesyntax.services.operations.Supply;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataToMapParserTest {
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static Map<String, Operable> operations;
    private static List<String[]> dataLines;
    private static DataToMapParser dataParser;

    @BeforeClass
    public static void before() {
        dataParser = new DataToMapParser();
        operations = new HashMap<>();
        dataLines = new ArrayList<>();
        operations.put(RETURN, new Return());
        operations.put(SUPPLY, new Supply());
        operations.put(BUY, new Buy());
    }

    @Test
    public void dataToMapParserTest() {
        dataLines.add(new String[]{"s", "banana", "100", "2020-10-14" });
        dataLines.add(new String[]{"b", "banana", "30", "2020-10-15" });
        dataLines.add(new String[]{"r", "banana", "20", "2020-10-17" });
        dataLines.add(new String[]{"s", "orange", "30", "2020-10-15" });
        Map<String, Map<String, Integer>> actual = dataParser.parseData(dataLines,
                operations);

        Assert.assertEquals(2, actual.size());
        Assert.assertEquals(2, actual.get("banana").size());
    }

    @Test(expected = DateTimeParseException.class)
    public void parseWithWrongLineTest() {
        dataLines.add(new String[]{"b", "**", "30", "!!!" });
        dataLines.add(new String[]{"s", "orange", "30", "2020-10-15" });

        Map<String, Map<String, Integer>> actual = dataParser.parseData(dataLines,
                operations);

        Assert.assertEquals(2, actual.size());
        Assert.assertEquals(1, actual.get("banana").size());
    }

    @Test
    public void parseWithWrongOperationTypeTest() {
        dataLines.add(new String[]{"s", "banana", "100", "2020-10-14" });
        dataLines.add(new String[]{"b", "banana", "30", "2020-10-15" });
        dataLines.add(new String[]{"G", "orange", "30", "2020-10-15" });
        dataLines.add(new String[]{"r", "banana", "20", "2020-10-17" });
        dataLines.add(new String[]{"s", "orange", "30", "2020-10-15" });

        Map<String, Map<String, Integer>> actual = dataParser.parseData(dataLines, operations);

        Assert.assertEquals(2, actual.size());
        Assert.assertEquals(2, actual.get("banana").size());
        Assert.assertEquals(1, actual.get("orange").size());
    }

    @Test
    public void parseEmptyListTest() {
        dataLines.clear();
        Map<String, Map<String, Integer>> actual = dataParser.parseData(dataLines,
                operations);

        Assert.assertEquals(0, actual.size());
    }
}
