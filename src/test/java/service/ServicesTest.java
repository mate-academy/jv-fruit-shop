package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import db.FruitStorage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.InputDataType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicesTest {
    private static final String TEST_FILE = "src/main/resources/test.csv";
    private CsvFileReader reader;
    private GenerateReport report;
    private ReportToFileWriter writer;
    private InputDataResolver resolver;
    private TransactionOperation operation;
    private FruitStorage storage;
    private Path testFilePath;

    @BeforeEach
    void setUp() {
        reader = new CsvFileReader();
        report = new GenerateReport();
        writer = new ReportToFileWriter();
        resolver = new InputDataResolver();
        operation = new TransactionOperation();
        storage = new FruitStorage();

        try {
            testFilePath = Files.createTempFile("test", ".csv");
        } catch (IOException e) {
            throw new RuntimeException("Can't create file with path " + testFilePath, e);
        }

        String testString = "operation,fruit,quantity\nb,banana,10\nb,apple,20\nb,orange,30";
        try {
            Files.write(testFilePath, testString.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + testFilePath, e);
        }
    }

    @AfterEach
    void tearDown() {
        try {
            Files.deleteIfExists(Path.of(TEST_FILE));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file" + TEST_FILE, e);
        }
        try {
            Files.deleteIfExists(testFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't delete file " + testFilePath, e);
        }
    }

    @Test
    void readCsvFile_ok() {
        List<String> expected = new ArrayList<>(
                Arrays.asList("b,banana,10", "b,apple,20", "b,orange,30")
        );
        List<String> actual = reader.readCsvFile(String.valueOf(testFilePath));
        assertEquals(expected, actual, "Actual and expected strings must be equals");
    }

    @Test
    void readWrongFilePath_notOk() {
        String fileName = "src/main/resources/wrong.csv";
        assertThrows(RuntimeException.class, () -> reader.readCsvFile(fileName),
                "Can't find file with such name " + fileName);
    }

    @Test
    void dataResolverValidInput_ok() {
        List<String> input = reader.readCsvFile(String.valueOf(testFilePath));
        List<InputDataType> expected = new ArrayList<>();
        expected.add(new InputDataType("b", "banana", 10));
        expected.add(new InputDataType("b", "apple", 20));
        expected.add(new InputDataType("b", "orange", 30));
        List<InputDataType> actual = resolver.resolveData(input);

        assertEquals(expected, actual,
                "Actual and expected data types must be equals");
    }

    @Test
    void dataResolverInvalidInput_notOk() {
        List<String> input = List.of("b,banana,", "b,apple,5", "b,orange,-8");

        assertThrows(RuntimeException.class, () -> resolver.resolveData(input),
                "Invalid input data " + input);
    }

    @Test
    void dataResolverEmptyInput_returnsEmptyList_ok() {
        List<String> input = new ArrayList<>();
        List<InputDataType> expected = new ArrayList<>();

        assertEquals(expected, resolver.resolveData(input),
                "Actual resolved data must be empty");
    }

    @Test
    void transactionOperationValidInput_ok() {
        ArrayList<InputDataType> operations = new ArrayList<>();
        operations.add(new InputDataType("b", "banana", 10));
        operations.add(new InputDataType("s", "banana", 55));
        operations.add(new InputDataType("p", "banana", 23));
        operations.add(new InputDataType("r", "banana", 10));

        operation.transactionOperation(operations, storage);

        Map<String,Integer> expectedStock = new HashMap<>();
        expectedStock.put("banana", 52);

        assertEquals(expectedStock, storage.getFruitStock(),
                "Actual and expected storages must be equals");
    }

    @Test
    void transactionOperationInvalidInput_notOk() {
        ArrayList<InputDataType> operations = new ArrayList<>();
        operations.add(new InputDataType("q", "banana", 10));
        operations.add(new InputDataType("w", "coconut", 55));
        operations.add(new InputDataType("e", "banana", -23));
        operations.add(new InputDataType("t", "banana", 10));

        storage.setFruit("banana", 100);
        storage.setFruit("apple", 25);

        operation.transactionOperation(operations, storage);

        Map<String,Integer> expectedStock = new HashMap<>();
        expectedStock.put("banana", 100);
        expectedStock.put("apple", 25);

        assertEquals(expectedStock, storage.getFruitStock(),
                "Actual and expected storages must be equals");
    }

    @Test
    void generateReport_ok() {
        storage.setFruit("banana", 100);
        storage.setFruit("apple", 25);
        Map<String,Integer> input = storage.getFruitStock();

        List<String> expected = List.of("fruit,quantity", "banana,100", "apple,25");

        assertEquals(expected, report.generateReport(input),
                "Actual and expected reports must be equals");
    }

    @Test
    void writeReport_ok() {
        List<String> expected = List.of("fruit,quantity", "banana,100", "apple,25");

        storage.setFruit("banana", 100);
        storage.setFruit("apple", 25);

        writer.writeReport(expected, TEST_FILE);

        List<String> actual = new ArrayList<>();
        actual.add("fruit,quantity");
        actual.addAll(reader.readCsvFile(TEST_FILE));

        assertEquals(expected, actual,
                "Actual and expected files content should be equals");
    }
}
