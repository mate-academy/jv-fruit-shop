package core.basesyntax;

import core.basesyntax.Parser;
import core.basesyntax.Transaction;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ParserTest {
    public static List<String> stringToParse = new ArrayList<>();
    Transaction correctTransaction = new Transaction("s"
            ,"banana",10,"2020-10-11" );

    @Test
    public void adding_Test_OK() {
        stringToParse.add("s,banana,10,2020-10-11");
        Parser parser = new Parser();
        Transaction expected = parser.parser(stringToParse).get(0);
        Assert.assertEquals(correctTransaction,expected);
    }
}
