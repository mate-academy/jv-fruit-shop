package core.basesyntax.service.impl;

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
    private static final String outputFilePath = "src/test/resources/output-fruit.csv";
    private static final String dataToWrite = "fruit,quantity\n banana,152";

    @BeforeClass
    public static void beforeAll() {
        csvDataWriter = new CsvDataWriterImpl();
    }

    @Test
    public void writingToFile_Ok() {
        csvDataWriter.writeReport(dataToWrite, outputFilePath);
        try {
            allReadedLines = Files.readAllLines(Path.of(outputFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from test file", e);
        }
    }
}
