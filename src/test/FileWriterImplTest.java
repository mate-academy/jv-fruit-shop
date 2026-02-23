package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.service.impl.FileWriterImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test; 

class FileWriterImplTest {
    private final FileWriterImpl fileWriter = new FileWriterImpl();

    @Test
    void writeToFile_isOk() throws IOException {
        String filePath = "test_output.csv";

        String content = "fruit,quantity" + System.lineSeparator() + "apple,10";

        fileWriter.write(content, filePath);

        String actualContent = Files.readString(Path.of(filePath));
        assertEquals(content, actualContent);

        new File(filePath).delete();
    }
}
