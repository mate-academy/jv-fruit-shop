package core.basesyntax.service;

import org.junit.BeforeClass;
import org.junit.Test;
import java.util.NoSuchElementException;

public class CsvFileReaderImplTest {
    private static CsvFileReaderImpl read;

    @BeforeClass
    public static void beforeClass() {
        read = new CsvFileReaderImpl();
    }

    @Test(expected = NoSuchElementException.class)
    public void isEmptyFileTest() {
        String path = "src/test/resources/emptyList.csv";
        read.readFile(path);
    }
}
