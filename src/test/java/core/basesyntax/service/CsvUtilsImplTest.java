package core.basesyntax.service;

import com.opencsv.CSVReader;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvUtilsImplTest {
    private static CsvUtilsImpl csvUtils;
    private static StorageDao<Product> storageDao;
    private static final String CSV_INPUT_TEST_FILE = "src/main/resources/testInputFile.csv";
    private static final String CSV_BAD_OPERATION_INPUT_TEST_FILE =
            "src/main/resources/testBadOperationInputFile.csv";
    private static final String CSV_ALL_OPERATIONS_IN_SINGLE_LINE_INPUT_TEST_FILE =
            "src/main/resources/testAllOperationsInSingleLineInputFile.csv";
    private static final String CSV_BUY_MORE_THEN_EXIST_INPUT_TEST_FILE =
            "src/main/resources/testBuyMoreThenExistInputFile.csv";
    private static final String CSV_BAD_FRUIT_INPUT_TEST_FILE =
            "src/main/resources/testBadFruitInputFile.csv";
    private static final String CSV_OUTPUT_TEST_FILE = "src/main/resources/testOutputFile.csv";
    private static final String NOT_EXISTING_FILE = "notExist";

    @BeforeClass
    public static void initialCsvUtils() {
        csvUtils = new CsvUtilsImpl();
        storageDao = new StorageDaoImpl();
    }

    @Before
    public void cleanDao() {
        storageDao.getAll().clear();
    }

    @Test
    public void positiveProcessFile() {
        csvUtils.processFile(CSV_INPUT_TEST_FILE);
        List<Product> expectedList = new ArrayList<>();
        expectedList.add(new Product("orange", LocalDate.parse("2020-10-16")));
        expectedList.add(new Product("orange", LocalDate.parse("2020-10-17")));
        expectedList.add(new Product("orange", LocalDate.parse("2020-10-17")));
        expectedList.add(new Product("apple", LocalDate.parse("2020-10-17")));
        expectedList.add(new Product("banana" ,LocalDate.parse("2020-10-17")));
        expectedList.add(new Product("orange", LocalDate.parse("2020-10-18")));
        List<Product> actualList = storageDao.getAll();
        Assert.assertEquals(expectedList, actualList);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionWhenBadOperation() {
        csvUtils.processFile(CSV_BAD_OPERATION_INPUT_TEST_FILE);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionWhenInputFileNotExist() {
        csvUtils.processFile(NOT_EXISTING_FILE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenAllOperationsInSingleLine() {
        csvUtils.processFile(CSV_ALL_OPERATIONS_IN_SINGLE_LINE_INPUT_TEST_FILE);

    }

    @Test
    public void positiveCreateReport() {
        List<String[]> actualList = new ArrayList<>();
        storageDao.put(new Product("orange", LocalDate.parse("2020-10-17")));
        storageDao.put(new Product("orange", LocalDate.parse("2020-10-17")));
        storageDao.put(new Product("apple", LocalDate.parse("2020-10-17")));
        storageDao.put(new Product("banana", LocalDate.parse("2020-10-17")));
        csvUtils.createReport(CSV_OUTPUT_TEST_FILE);
        try (CSVReader csvReader = new CSVReader(new FileReader(CSV_OUTPUT_TEST_FILE))) {
            actualList = csvReader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String[]> expectedList = new ArrayList<>();
        expectedList.add(new String[]{"fruit","quantity"});
        expectedList.add(new String[]{"apple","1"});
        expectedList.add(new String[]{"banana","1"});
        expectedList.add(new String[]{"orange","2"});
        for (int i = 0; i < actualList.size(); i++) {
            for (int j = 0; j < actualList.get(i).length; j++) {
                Assert.assertEquals(expectedList.get(i)[j], actualList.get(i)[j]);
            }
        }
    }
}
