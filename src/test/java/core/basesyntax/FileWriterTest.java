package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;

class FileWriterTest {

    @Test
    void testWrite() throws IOException {
        String testFilePath = "output.csv";
        FileWriter fileWriter = new FileWriter();
        List<String> report = List.of("banana,130", "apple,200");

        fileWriter.write(report, testFilePath);

        List<String> writtenData = Files.readAllLines(Path.of(testFilePath));
        assertEquals(report, writtenData);
    }
}
