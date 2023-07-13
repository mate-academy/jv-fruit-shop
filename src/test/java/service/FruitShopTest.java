package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import db.FruitStorage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitShopTest {
    private static final String VALID_INPUT_FILE = "input.csv";
    private static final Path TEST_FILE_PATH = Path.of(
            "/Users/egoiste/IdeaProjects/jv-fruit-shop/test.csv");
    private static final String TEST_FILE = "test.csv";

    private CsvFileReader reader;
    private GenerateReport report;
    private ReportToFileWriter writer;
    private FruitStorage storage;

    @BeforeEach
    void setUp() {
        Path sourceFile = Path.of("/Users/egoiste/IdeaProjects/jv-fruit-shop/input.csv");
        Path destinationFile = Path.of("/Users/egoiste/IdeaProjects/jv-fruit-shop/test.csv");

        try {
            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Can't copy file " + sourceFile, e);
        }

        reader = new CsvFileReader();
        report = new GenerateReport();
        writer = new ReportToFileWriter();
        storage = new FruitStorage();
    }

    @Test
    void fileNotExist_notOk() {
        Path filePath = Paths.get(TEST_FILE_PATH.toUri());
        assertTrue(Files.exists(filePath), "Can't find file with such name " + filePath);
    }

    @Test
    void wrongFileName_notOk() {
        String expectedFileName = TEST_FILE;
        String actualFileName = "tets.csv";

        assertNotEquals(expectedFileName, actualFileName,
                "File name not match, check name of input file " + actualFileName);
    }

    @Test
    void inputFileNotEmpty_ok() {
        assertFalse(reader.readCsvFile(VALID_INPUT_FILE).isEmpty(),
                "Input file should not be empty " + VALID_INPUT_FILE);
    }

    @Test
    void calculateReport_ok() {
        List<String> fruitData = Arrays.asList(
                "b,banana,20",
                "b,apple,100",
                "s,banana,100",
                "p,banana,13",
                "r,apple,10",
                "p,apple,20",
                "p,banana,5",
                "s,banana,50"
        );
        Map<String,Integer> expectedStock = new HashMap<>();
        expectedStock.put("banana", 152);
        expectedStock.put("apple", 90);

        report.calculateFruitsStock(fruitData);
        Map<String,Integer> actualStock = report.getStock();

        assertEquals(expectedStock, actualStock,
                "Actual stock isn't match expectedStock");
    }

    @Test
    void calculateReportEmptyData_notOk() {
        List<String> emptyData = List.of();

        report.calculateFruitsStock(emptyData);
        Map<String,Integer> actualStock = report.getStock();

        if (actualStock.isEmpty()) {
            assertEquals(new HashMap<>(), actualStock,
                    "Can't create report from empty input data");
        }
    }

    @Test
    void writeReport_ok() {
        Map<String,Integer> report = new HashMap<>();
        report.put("banana", 152);
        report.put("apple", 90);

        writer.writeReport(report, TEST_FILE);

        assertTrue(Files.exists(Path.of(TEST_FILE_PATH.toUri())));

        try {
            String fileContent = Files.readString(Path.of(TEST_FILE_PATH.toUri()));
            assertEquals("banana,152\napple,90\n", fileContent,
                    "Expected and actual file content should be equals");
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + TEST_FILE, e);
        }
    }

    @Test
    void writerEmptyInput_notOk() {
        Map<String, Integer> emptyReport = new HashMap<>();

        writer.writeReport(emptyReport, TEST_FILE);

        assertTrue(Files.exists(Path.of(TEST_FILE_PATH.toUri())));

        String fileContent;
        try {
            fileContent = Files.readString(Path.of(TEST_FILE_PATH.toUri()));
            assertTrue(fileContent.isEmpty());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + TEST_FILE, e);
        }
    }

    @Test
    void fruitStorageUpdate_ok() {
        List<String> fruitData = reader.readCsvFile(VALID_INPUT_FILE);

        report.calculateFruitsStock(fruitData);

        Map<String,Integer> expectedStock = new HashMap<>();
        expectedStock.put("banana", 152);
        expectedStock.put("apple", 90);

        storage.updateStock(expectedStock);

        assertEquals(152, storage.getBananaStock(),
                "Actual and expected banana stocks must be equals");
        assertEquals(90, storage.getAppleStock(),
                "Actual and expected apple stocks must be equals");
    }

    @AfterEach
    void tearDown() {
        Path filePath = Path.of("/Users/egoiste/IdeaProjects/jv-fruit-shop/test.csv");

        try {
            Files.deleteIfExists(filePath);
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("Can't delete file " + filePath, e);
        }
    }
}
