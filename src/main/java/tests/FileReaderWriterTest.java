package tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.FileReader;
import core.basesyntax.FileReaderImpl;
import core.basesyntax.FileWriter;
import core.basesyntax.FileWriterImpl;

public class FileReaderWriterTest {
    @Test
    public void testFileReaderWriter() throws IOException {
        final String filePath = "testReport.csv";
        final String content = "fruit,quantity\nbanana,152\napple,90\n";
        final FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(content, filePath);

        final FileReader fileReader = new FileReaderImpl();
        final List<String> readContent = fileReader.read(filePath);

        assertEquals(Arrays.asList(content.split("\n")), readContent);

        Files.delete(Paths.get(filePath));
    }
}
