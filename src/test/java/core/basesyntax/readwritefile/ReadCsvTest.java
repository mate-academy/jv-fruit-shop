package core.basesyntax.readwritefile;

import core.basesyntax.maketransaction.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReadCsvTest {

    private CsvFileReader testReader;

    @Before
    public void setUp() throws Exception {
        testReader = new CsvFileReader();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void readCSV_Ok() throws FileNotFoundException {
        List<Transaction> expected = new ArrayList<>();
        expected.add(new Transaction("s", "banana", 100, "2020-10-17"));
        expected.add(new Transaction("b", "banana", 13, "2020-10-15"));
        expected.add(new Transaction("r", "banana", 10, "2020-10-17"));

        assertEquals(expected, testReader.readCsv("src/test/java/core/basesyntax/readwritefile/testfilestoread/fileOk.csv"));
    }

    @Test
    public void readCSV_Empty() throws FileNotFoundException {
        List<Transaction> expected = new ArrayList<>();

        assertEquals(expected, testReader.readCsv("src/test/java/core/basesyntax/readwritefile/testfilestoread/empty.csv"));
    }

    @Test(expected = FileNotFoundException.class)
    public void readCSV_FileNotFoundException() throws FileNotFoundException {
        testReader.readCsv("1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCSV_IllegalArgumentException() throws FileNotFoundException {
        testReader.readCsv("src/test/java/core/basesyntax/readwritefile/testfilestoread/fileIllegalArgumentException.csv");
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCSV_IllegalArgumentException2() throws FileNotFoundException {
        testReader.readCsv("src/test/java/core/basesyntax/readwritefile/testfilestoread/fileIllegalArgumentException2.csv");
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCSV_IllegalArgumentException3() throws FileNotFoundException {
        testReader.readCsv("src/test/java/core/basesyntax/readwritefile/testfilestoread/fileIllegalArgumentException2.csv");
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCSV_IllegalArgumentException4() throws FileNotFoundException {
        testReader.readCsv("src/test/java/core/basesyntax/readwritefile/testfilestoread/fileIllegalArgumentException2.csv");
    }
}
