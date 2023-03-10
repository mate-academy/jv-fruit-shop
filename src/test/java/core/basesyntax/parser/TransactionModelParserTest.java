package core.basesyntax.parser;

import core.basesyntax.exception.InvalidDateException;
import core.basesyntax.exception.NegativeQuantityException;
import core.basesyntax.model.Model;
import core.basesyntax.model.TransactionModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.List;

public class TransactionModelParserTest {
    private static Parser<TransactionModel> parser;
    private Model transactionModel;
    private String line;
    private List<String> parseData;

    @BeforeClass
    public static void beforeClass() {
        parser = new TransactionModelParser();
    }

    @Test
    public void transactionParseOk() {
        line = "s,banana,13,2020-10-05";
        parseData = List.of(line.split(","));
        transactionModel = new TransactionModel
                ("banana", "s", LocalDate.parse("2020-10-05"), 13);
        Assert.assertEquals(transactionModel, parser.parse(parseData));
    }

    @Test(expected = InvalidDateException.class)
    public void invalidDataParse() {
        line = "s,banana,13,2020-30-05";
        parseData = List.of(line.split(","));
        parser.parse(parseData);
    }

    @Test(expected = NegativeQuantityException.class)
    public void invalidQuantityParse() {
        line = "s,banana,-13,2020-10-05";
        parseData = List.of(line.split(","));
        parser.parse(parseData);
    }
}
