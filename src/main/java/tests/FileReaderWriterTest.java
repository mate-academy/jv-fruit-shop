package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.FileReader;
import core.basesyntax.FileReaderImpl;
import core.basesyntax.FileWriter;
import core.basesyntax.FileWriterImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FileReaderWriterTest {
    @Test
    public void writeAndRead_validData_ok() throws IOException {
        String filePath = "testReport.csv";
        String content = "fruit,quantity\nbanana,152\napple,90\n";
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(content, filePath);
        FileReader fileReader = new FileReaderImpl();
        List<String> readContent = fileReader.read(filePath);
        assertEquals(Arrays.asList(content.split("\n")), readContent);
        Files.delete(Paths.get(filePath));
    }
}
