package core.basesyntax.file;

import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReadFromFileTest {
    private static final String FILE_FROM_OK = "src/test/resources/shop_activity_test.csv";
    private static final String FILE_FROM_NOT_OK = "src/main/resources/shop_activitytest.csv";
    private static List<String> OK_DATA = new ArrayList<>();
    private static CsvFileReader reader;

    @BeforeClass
    public static void beforeClass() {
        reader = new CsvFileReaderImpl();
        OK_DATA.add("type,fruit,quantity");
        OK_DATA.add("b,banana,20");
        OK_DATA.add("b,apple,100");
    }

    @Test
    public void readFromFile_OK() {
        Assert.assertNotNull(reader.readFromFile(FILE_FROM_OK));
    }

    @Test
    public void expectedData_OK() {
        List<String> actual = reader.readFromFile(FILE_FROM_OK);
        Assert.assertEquals(OK_DATA, actual);
    }

    @Test(expected = RuntimeException.class)
    public void readFromFile_NotOK() {
        reader.readFromFile(FILE_FROM_NOT_OK);
    }
}
