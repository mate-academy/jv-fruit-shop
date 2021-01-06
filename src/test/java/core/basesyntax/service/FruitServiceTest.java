package core.basesyntax.service;

import static org.junit.Assert.assertNotNull;

import core.basesyntax.db.Storage;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FruitServiceTest {
    private static final String FILE_FROM = "src/test/resources/shop_activity_test.csv";
    private static final String FILE_INVALID_OPERATION
            = "src/test/resources/shop_activity_test_invalid_operation.csv";
    private List<String> data;
    private FruitService service;

    @Before
    public void setUp() {
        service = new FruitServiceImpl();
    }

    @Test
    public void validFileData() {
        data = new CsvFileReaderImpl().readFromFile(FILE_FROM);
        List<String[]> parsedData = new CsvParserImpl().parse(data);
        service.processActivities(parsedData);
        assertNotNull(Storage.storage);
    }

    @Test(expected = RuntimeException.class)
    public void invalidFileData_OperationType() {
        data = new CsvFileReaderImpl().readFromFile(FILE_INVALID_OPERATION);
        List<String[]> parsedData = new CsvParserImpl().parse(data);
        service.processActivities(parsedData);
    }
}
