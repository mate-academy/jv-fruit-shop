package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;

class FileReaderTest {

    @Test
    void testReadFile() throws IOException {
        String testFilePath = "testFile.csv";
        Files.writeString(Path.of(testFilePath), "b,banana,100\ns,apple,50\np,banana,30");

        FileReader fileReader = new CsvFileReader();

        List<String> data = fileReader.read(testFilePath);

        assertEquals(3, data.size());
        assertEquals("b,banana,100", data.get(0));
    }
}
