package core.basesyntax.services;

import core.basesyntax.services.operations.PurchaseOperation;
import core.basesyntax.services.operations.Operable;
import core.basesyntax.services.operations.SupplyOperation;
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
    private static List<FruitDto> fruitDtos;
    private static DataToMapParser dataParser;

    @BeforeClass
    public static void beforeClass() {
        dataParser = new DataToMapParser();
        operations = new HashMap<>();
        fruitDtos = new ArrayList<>();
        operations.put(RETURN, new SupplyOperation());
        operations.put(SUPPLY, new SupplyOperation());
        operations.put(BUY, new PurchaseOperation());
    }

    @Test
    public void parseDataToMap() {
        fruitDtos.add(new FruitDto("s", "banana", 100, "2020-10-14" ));
        fruitDtos.add(new FruitDto("b", "banana", 30, "2020-10-15" ));
        fruitDtos.add(new FruitDto("r", "banana", 20, "2020-10-17" ));
        fruitDtos.add(new FruitDto("s", "orange", 30, "2020-10-15" ));
        Map<String, Map<String, Integer>> actual = dataParser.parseData(fruitDtos,
                operations);

        Assert.assertEquals(2, actual.size());
        Assert.assertEquals(2, actual.get("banana").size());
    }

    @Test(expected = DateTimeParseException.class)
    public void parseWithWrongLine() {
        fruitDtos.add(new FruitDto("b", "**", 30, "!!!" ));
        fruitDtos.add(new FruitDto("s", "orange", 30, "2020-10-15" ));

        Map<String, Map<String, Integer>> actual = dataParser.parseData(fruitDtos,
                operations);

        Assert.assertEquals(2, actual.size());
        Assert.assertEquals(1, actual.get("banana").size());
    }

    @Test
    public void parseWithWrongOperationType() {
        fruitDtos.add(new FruitDto("s", "banana", 100, "2020-10-14" ));
        fruitDtos.add(new FruitDto("b", "banana", 30, "2020-10-15" ));
        fruitDtos.add(new FruitDto("G", "orange", 30, "2020-10-15" ));
        fruitDtos.add(new FruitDto("r", "banana", 20, "2020-10-17" ));
        fruitDtos.add(new FruitDto("s", "orange", 30, "2020-10-15" ));

        Map<String, Map<String, Integer>> actual = dataParser.parseData(fruitDtos, operations);

        Assert.assertEquals(2, actual.size());
        Assert.assertEquals(2, actual.get("banana").size());
        Assert.assertEquals(1, actual.get("orange").size());
    }

    @Test
    public void parseEmptyList() {
        fruitDtos.clear();
        Map<String, Map<String, Integer>> actual = dataParser.parseData(fruitDtos,
                operations);

        Assert.assertEquals(0, actual.size());
    }
}
