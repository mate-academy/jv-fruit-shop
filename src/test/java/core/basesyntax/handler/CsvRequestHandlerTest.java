package core.basesyntax.handler;

import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CsvRequestHandlerTest {
    private static final FileProcessor FILE_PROCESSOR = new CsvFileProcessor();
    private static final FruitService FRUIT_SERVICE = new FruitServiceImpl();

    @Test
    public void handleRequestOk() throws IOException {
        CsvRequestHandler handler = new CsvRequestHandler(FILE_PROCESSOR, FRUIT_SERVICE);
        File actualFile = new File(handler.handle("fruits.csv"));
        File expectedFile = new File("src/test/resources/fruits2.csv");
        List<String> actual =  Files.readAllLines(actualFile.toPath());
        List<String> expected =  Files.readAllLines(expectedFile.toPath());

        assertEquals(expected, actual);
    }
}
