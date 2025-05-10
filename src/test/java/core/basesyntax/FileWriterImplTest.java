package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FileWriterImplTest {
    private final FileWriter fileWriter = new FileWriterImpl();

    @Test
    void fileNoExist_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            fileWriter.writeToFile(null,"File.csv");
        });
    }
}
