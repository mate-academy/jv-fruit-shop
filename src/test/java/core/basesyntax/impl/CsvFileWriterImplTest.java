package core.basesyntax.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.service.FileWriter;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterImplTest {
    public static final String CORRECT_FILE_FOR_WRITING = "success_writing.csv";
    public static final String CORRECT_CONTENT = "fruit,quantity\n"
            + "banana,20\n"
            + "apple,100\n";
    public static final Map<String, Long> testMap = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        testMap.put("banana", 20L);
        testMap.put("apple", 100L);
    }

    @Test
    public void testWriterForCorrectContent() {
        FileWriter testWriter = new CsvFileWriterImpl();
        testWriter.createReportFile(testMap, CORRECT_FILE_FOR_WRITING);
        String testLine;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(CORRECT_FILE_FOR_WRITING))) {
            while ((testLine = reader.readLine()) != null) {
                sb.append(testLine)
                        .append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file! " + e);
        }
        assertEquals(CORRECT_CONTENT, sb.toString());
    }

    @AfterClass
    public static void afterClass() {
        File testFileWriting = new File(CORRECT_FILE_FOR_WRITING);
        testFileWriting.delete();
    }
}
