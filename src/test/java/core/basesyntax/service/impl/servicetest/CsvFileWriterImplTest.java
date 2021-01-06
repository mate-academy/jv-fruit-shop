package core.basesyntax.service.impl.servicetest;

import static org.junit.Assert.assertEquals;

import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterImplTest {
    private static final String PATH_TO_FILE = "src/test/resources/reportByFirstFile.csv";
    private static Map<String, Long> testMapForReport;
    private static CsvFileWriter csvFileWriter;

    @BeforeClass
    public static void beforeAll() {
        testMapForReport = new HashMap<>();
        testMapForReport.put("banana", 152L);
        testMapForReport.put("apple", 90L);
        csvFileWriter = new CsvFileWriterImpl();
    }

    @Test
    public void correctWriteToFile_Ok() {
        String expectedResult = "banana:152"
                + "apple:90";
        csvFileWriter.createReportFile(testMapForReport,PATH_TO_FILE);
        StringBuilder stringBuilder;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_FILE))) {
            String row;
            stringBuilder = new StringBuilder();
            while ((row = bufferedReader.readLine()) != null) {
                stringBuilder.append(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + PATH_TO_FILE, e);
        }
        assertEquals(expectedResult, stringBuilder.toString());
    }
}
