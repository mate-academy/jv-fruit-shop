package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;

class FileReaderImplTest {
    private final FileReader fileReader = new FileReaderImpl();

    @Test
    void fileNoExist_NotOk() {
        assertThrows(FileNotFoundException.class, () -> {
            fileReader.readFromFile("nonExistFile.csv");
        });
    }
}
