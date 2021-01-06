package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterImplTest {
    public static CsvFileWriterImpl csvFileWriter;
    public static Map<String, Long> balance;

    @BeforeClass
    public static void beforeClass() throws Exception {
        csvFileWriter = new CsvFileWriterImpl();
        balance = new HashMap<>();
        balance.put("banana", 30L);
    }

    @Test
    public void report_file_Ok() {
        String filePath = "src/test/resources/check-report-to-file.txt";
        csvFileWriter.reportFile(balance, filePath);
        String actual;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String value = bufferedReader.readLine();
            actual = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file! " + filePath);
        }
        assertEquals("banana,30", actual);
    }
}
