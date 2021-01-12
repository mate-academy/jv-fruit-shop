package servise;

import exception.FruitShopException;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ReaderFromCsvFileImplTest {

    @Test
    public void checkReader_Ok() {
        ReaderFromCsvFileImpl file = new ReaderFromCsvFileImpl("src/test/resources/Input_file.csv");
        List<String> actual = file.readFromFile();
        List<String> expected = Arrays.asList("type,fruit,quantity", "b,banana,20", "b,apple,100");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = FruitShopException.class)
    public void checkReaderWrongFile_NotOk() {
        ReaderFromCsvFileImpl file = new ReaderFromCsvFileImpl("no file");
        file.readFromFile();
    }
}
