package core.basesyntax;

import core.basesyntax.operations.Parser;
import core.basesyntax.operations.Transaction;
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
        stringToParse.add("type,fruit,quantity,date");
        stringToParse.add("s,banana,10,2020-10-11");
        Parser parser = new Parser();
        Transaction expected = parser.parse(stringToParse).get(0);
        Assert.assertEquals(correctTransaction,expected);
    }
}
