package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterImplTest {
    public static FileWriter csvFileWriter;

    @BeforeClass
    public static void beforeClass() {
        csvFileWriter = new CsvFileWriterImpl();
    }

    @Test(expected = RuntimeException.class)
    public void fileNotFound_Ok() {
        csvFileWriter
                .writeDataInFile(new HashMap<>(), "");
    }

    @Test
    public void dataWrite_Ok() {
        Map<String, Long> longMap = new HashMap<>();
        longMap.put("banana", 10L);
        csvFileWriter.writeDataInFile(longMap, "src/test/resources/checkWriteMethod.csv");
        try {
            List<String> lines = Files.readAllLines(Path.of("src/test/"
                    + "resources/checkWriteMethod.csv"));
            StringBuilder sb = new StringBuilder();
            for (String line : lines) {
                sb.append(line);
            }
            assertEquals("fruit,quantitybanana,10", sb.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file ");
        }
    }
}
