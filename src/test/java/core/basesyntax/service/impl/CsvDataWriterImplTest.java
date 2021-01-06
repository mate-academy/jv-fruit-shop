package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.service.DataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvDataWriterImplTest {
    private static List<String> allReadedLines;
    private static DataWriter csvDataWriter;

    @BeforeClass
    public static void beforeAll() {
        csvDataWriter = new CsvDataWriterImpl();
    }

    @Test
    public void writingToFile_Ok() {
        String outputFilePath = "src/test/resources/output-fruit.csv";
        String dataToWrite = "fruit,quantity" + System.lineSeparator() + "banana,152";
        List<String> expectedData = List.of("fruit,quantity", "banana,152");
        csvDataWriter.writeReport(dataToWrite, outputFilePath);
        try {
            allReadedLines = Files.readAllLines(Path.of(outputFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from test file", e);
        }
        assertEquals(expectedData, allReadedLines);
    }
}
