package core.basesyntax.csvservice;

import core.basesyntax.Transaction;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ReaderTest {
    @Test
    public void testReaderWithNormalData() {
        List<Transaction> expected = new ArrayList<>();
        expected.add(new Transaction("s", "banana", "185", "2020-11-20"));
        expected.add(new Transaction("b", "banana", "20", "2020-10-19"));
        expected.add(new Transaction("r", "banana", "5", "2020-11-20"));
        expected.add(new Transaction("s", "apple", "50", "2020-11-17"));
        expected.add(new Transaction("b", "apple", "20", "2020-10-19"));
        expected.add(new Transaction("r", "banana", "5", "2020-11-20"));
        expected.add(new Transaction("s", "orange", "30", "2020-11-17"));
        expected.add(new Transaction("b", "orange", "10", "2020-10-19"));
        expected.add(new Transaction("r", "orange", "1", "2020-11-20"));
        List<Transaction> actual = Reader.read("src/main/resources/inputNormal1.csv");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void testReaderWithNonExistingFile() {
        Reader.read("src/main/resources/wrongName.csv");
    }

    @Test(expected = RuntimeException.class)
    public void testReaderWithEmptyFile() {
        Reader.read("src/main/resources/emptyFile.csv");
    }
}
