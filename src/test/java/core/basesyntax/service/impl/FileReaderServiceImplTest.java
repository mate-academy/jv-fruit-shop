package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

public class FileReaderServiceImplTest {
    private static FileReaderService reader;

    @BeforeClass
    public static void setup() {
        reader = new FileReaderServiceImpl();
    }

    @Test
    public void normalDataTest() {
        List<List<String>> expected = List.of(List.of("s", "banana", "100", "2020-08-26"),
                List.of("s", "banana", "100", "2020-08-26"),
                List.of("b", "banana", "50", "2020-08-26"),
                List.of("r", "banana", "50", "2020-07-26"),
                List.of("s", "orange", "100", "2020-08-26"),
                List.of("s", "kiwi", "100", "2020-06-26"));
        List<List<String>> actual = reader.read("src/test/resources/normalData.csv");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void noSuchFileTest() {
        reader.read("src/test/resources/nofile.csv");
    }

    @Test(expected = RuntimeException.class)
    public void emptyFileTest() {
        reader.read("src/test/resources/empty.csv");
    }
}