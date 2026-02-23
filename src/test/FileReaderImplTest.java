package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.service.impl.FileReaderImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;

class FileReaderImplTest {
    private final FileReaderImpl fileReader = new FileReaderImpl();

    @Test
    void read_fromExistingFile_isOk() throws IOException {
        String filePath = "test_input.csv";
        String content = "type,fruit,quantity" + System.lineSeparator() + "b,banana,20";
        Files.writeString(Path.of(filePath), content);

        List<String> actual = fileReader.read(filePath);

        assertEquals(2, actual.size());
        assertEquals("type,fruit,quantity", actual.get(0));
        assertEquals("b,banana,20", actual.get(1));

        new File(filePath).delete();
    }
}
