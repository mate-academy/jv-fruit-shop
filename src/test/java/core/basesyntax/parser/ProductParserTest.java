package core.basesyntax.parser;

import core.basesyntax.exception.InvalidDateException;
import core.basesyntax.model.InputDataModel;
import core.basesyntax.model.Model;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.List;

public class ProductParserTest {
    private static Parser<InputDataModel> productParser;
    private List<String> parseData;
    private Model inputDataModel;
    private String name;
    private String line;
    private LocalDate date;

    @BeforeClass
    public static void beforeClass() {
        productParser = new ProductParser();
    }

    @Test
    public void parseDataOk() {
        name = "banana";
        date = LocalDate.parse("2020-10-17");
        inputDataModel = new InputDataModel(name, date);
        line = "s,banana,100,2020-10-17";
        parseData = List.of(line.split(","));
        Assert.assertEquals(inputDataModel, productParser.parse(parseData));
    }

    @Test(expected = InvalidDateException.class)
    public void parseInvalidDate() {
        line = "s,banana,100,2020-30-37";
        parseData = List.of(line.split(","));
        productParser.parse(parseData);
    }
}
