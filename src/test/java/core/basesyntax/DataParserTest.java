package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataParserTest {
    private DataParser dataParser = new DataParser();

    @Test()
    public void parseDataOk() {
        LocalDate localDate = LocalDate.parse("2020-06-20");
        FruitPackage expectedFruitPackage = new FruitPackage("apple", 100, localDate);
        List<String> data = new ArrayList<>();
        data.add("s");
        data.add("apple");
        data.add("100");
        data.add("2020-06-20");
        FruitPackage actualFruitPackage = dataParser.mapToFruit(data);
        Assert.assertEquals(expectedFruitPackage.getType(), actualFruitPackage.getType());
        Assert.assertEquals(expectedFruitPackage.getAmount(), actualFruitPackage.getAmount());
        Assert.assertEquals(expectedFruitPackage.getDate(), actualFruitPackage.getDate());
    }
}
