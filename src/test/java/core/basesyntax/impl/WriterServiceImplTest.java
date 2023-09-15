package core.basesyntax.impl;

import core.basesyntax.service.util.WriterServise;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WriterServiceImplTest {
    private final WriterServise writerServise = new WriterServiceImpl();
    private List<String> report = new ArrayList<>();

    @Test
    void writeToFile_wrongFileName_notOk() {
        report = Arrays.asList("fruit,quantity", "banana,150", "apple,92");
        String fileToNotExist = "src/test1/resources/fileToNotExist.csv";
        Assertions.assertThrows(RuntimeException.class, () ->
                writerServise.writeToFile(report, fileToNotExist));
    }

    @Test
    void writeToFile_Ok() {
        String fileTo = "src/test/resources/fileToTest.csv";
        Assertions.assertDoesNotThrow(() -> writerServise.writeToFile(report, fileTo));
    }
}
