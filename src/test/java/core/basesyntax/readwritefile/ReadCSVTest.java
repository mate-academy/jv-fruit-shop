package core.basesyntax.readwritefile;

import core.basesyntax.maketransaction.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReadCSVTest {

    private ReadCsv testReader;

    @Before
    public void setUp() throws Exception {
        testReader = new ReadCsv();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void readCSV_Ok() {
        List<Transaction> expected = new ArrayList<>();
        expected.add(new Transaction("s", "banana", 100, "2020-10-17"));
        expected.add(new Transaction("b", "banana", 13, "2020-10-15"));
        expected.add(new Transaction("r", "banana", 10, "2020-10-17"));

        assertEquals(expected, testReader.readCsv("src/test/java/core/basesyntax/readWriteFile/testFilesToRead/fileOk.csv"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCSV_IllegalArgumentException() {
        testReader.readCsv("src/test/java/core/basesyntax/readWriteFile/testFilesToRead/fileIllegalArgumentException.csv");
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCSV_IllegalArgumentException2() {
        testReader.readCsv("src/test/java/core/basesyntax/readWriteFile/testFilesToRead/fileIllegalArgumentException2.csv");
    }
}