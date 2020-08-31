package core.basesyntax;

import core.basesyntax.service.BuyOperation;
import core.basesyntax.service.FruitDto;
import core.basesyntax.service.FruitOperations;
import core.basesyntax.service.SupplyAndReturnOperation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataToMapParserTest {
    private static final String BUY = "b";
    private static final String SUPPLY = "s";
    private static final String RETURN = "r";
    private static Map<String, FruitOperations> operations;
    private static List<FruitDto> fruits;
    private static core.basesyntax.service.DataToMapParser dataParser;

    @BeforeClass
    public static void beforeClass() {
        dataParser = new core.basesyntax.service.DataToMapParser();
        operations = new HashMap<>();
        fruits = new ArrayList<>();
        operations.put(RETURN, new SupplyAndReturnOperation());
        operations.put(SUPPLY, new SupplyAndReturnOperation());
        operations.put(BUY, new BuyOperation());
    }

    @Test
    public void parseDataToMap() {
        fruits.add(new FruitDto("s", "banana", 120, "2020-08-30"));
        fruits.add(new FruitDto("s", "apple", 330, "2020-08-30"));
        fruits.add(new FruitDto("s", "melon", 130, "2020-08-30"));
        Map<String, Map<String, Integer>> actual = dataParser.parseData(fruits, operations);
        Assert.assertEquals(3, actual.size());
        Assert.assertEquals(1, actual.get("melon").size());
    }

    @Test
    public void parseWithWrongType() {
        fruits.add(new FruitDto("q", "banana", 12, "2020-08-26"));
        fruits.add(new FruitDto("r", "melon", 17, "2020-08-26"));
        fruits.add(new FruitDto("w", "banana", 10, "2020-08-27"));
        Map<String, Map<String, Integer>> actual = dataParser.parseData(fruits, operations);
        Assert.assertEquals(1, actual.size());
    }

    @Test
    public void parseEmptyList() {
        fruits.clear();
        Map<String, Map<String, Integer>> actual = dataParser.parseData(fruits,
                operations);
        Assert.assertEquals(0, actual.size());
    }
}
