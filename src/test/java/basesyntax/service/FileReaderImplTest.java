package basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import basesyntax.service.impl.FileReaderImpl;
import java.util.List;
import org.junit.jupiter.api.Test;

class FileReaderImplTest {

    @Test
    void read_validFile_ok() {
        FileReader reader = new FileReaderImpl();

        List<String> result = reader.read("src/test/resources/input.csv");

        assertEquals(3, result.size());
    }
}
