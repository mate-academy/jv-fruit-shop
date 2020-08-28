package core.basesyntax.parsers;

import org.junit.Test;
import java.util.List;

public class ParseFromCSVTest {

    @Test(expected = RuntimeException.class)
    public void testWrongPath() {
        List<String[]> fromCSV = new ParseFromCSV().parseFromCSV("path.csv");
    }

}