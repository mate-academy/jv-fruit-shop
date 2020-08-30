package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterTest {
    private static Reader reader = new Reader();
    private static Writer writer = new Writer();

    @Before
    public void beforeClass() {
        List<FruitDto> transactions = reader.readFromFile("src/main/resources/Input.csv");
        OperationHandler.handleOperation(transactions);
    }

    @Test
    public void testResult() throws IOException {
        writer.write("src/main/resources/Output.csv");
        List<String> expected = Files.readAllLines(Path.of("src/main/resources/Result.csv"));
        List<String> actual = Files.readAllLines(Path.of("src/main/resources/Output.csv"));
        expected.removeAll(actual);
        Assert.assertTrue(expected.isEmpty());
    }
}
