package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileServiceTest {
    private static CsvFileService csvFileService;
    private static StorageDao<Product> storageDao;
    private static CsvFileHandler csvFileHandler;
    private static CsvFileWriter csvFileWriter;
    private static final String CSV_INPUT_TEST_FILE = "src/main/resources/testInputFile.csv";
    private static final String CSV_BAD_OPERATION_INPUT_TEST_FILE =
            "src/main/resources/testBadOperationInputFile.csv";
    private static final String CSV_ALL_OPERATIONS_IN_SINGLE_LINE_INPUT_TEST_FILE =
            "src/main/resources/testAllOperationsInSingleLineInputFile.csv";
    private static final String CSV_BAD_FRUIT_INPUT_TEST_FILE =
            "src/main/resources/testBadFruitInputFile.csv";
    private static final String CSV_OUTPUT_TEST_FILE = "src/main/resources/testOutputFile.csv";
    private static final String NOT_EXISTING_FILE = "";

    @BeforeClass
    public static void initialCsvUtils() {
        csvFileService = new CsvFileService();
        storageDao = new StorageDaoImpl();
        csvFileHandler = new CsvFileHandler();
        csvFileWriter = new CsvFileWriter();
    }

    @Before
    public void cleanDao() {
        storageDao.getAll().clear();
        csvFileHandler = new CsvFileHandler();
    }

    @Test
    public void positiveApplication() {
        Assert.assertTrue(csvFileService.runApplication(CSV_INPUT_TEST_FILE, CSV_OUTPUT_TEST_FILE));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsupportedOperationExceptionWhenBadOperation() {
        csvFileService.runApplication(CSV_BAD_OPERATION_INPUT_TEST_FILE, NOT_EXISTING_FILE);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionWhileProcessWhenInputFileNotExist() {
        csvFileHandler.processFile(NOT_EXISTING_FILE);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionWhileReportWhenInputFileNotExist() {
        csvFileWriter.createReport(NOT_EXISTING_FILE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenAllOperationsInSingleLine() {
        csvFileService.runApplication(CSV_ALL_OPERATIONS_IN_SINGLE_LINE_INPUT_TEST_FILE, NOT_EXISTING_FILE);

    }
}
