package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileReader;
import core.basesyntax.service.MyFileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyFileWriterCsvImplTest {
    private static final String TEST_FRUIT_WHICH_LOCK_CSV
            = "src/test/resources/test-file-which-lock.csv";
    private static final String TEST_FRUIT_REPORT_CSV
            = "src/test/resources/test-report-fruit-shop.csv";
    private static MyFileWriter myFileWriterCsv;
    private static MyFileReader myFileReaderCsv;
    private static String dataForWrite;
    private static final String emptyDataForWrite = "";

    @BeforeClass
    public static void beforeClass() {
        myFileWriterCsv = new MyFileWriterCsvImpl();
        myFileReaderCsv = new MyFileReaderCsvImpl();
        dataForWrite = "type,fruit,quantity" + System.lineSeparator()
                + "b,banana,20" + System.lineSeparator()
                + "b,apple,100" + System.lineSeparator();
    }

    @Test
    public void writeToFileUsualData_Ok() {
        myFileWriterCsv.writeToFile(TEST_FRUIT_REPORT_CSV, dataForWrite);
        List<String> expected = Arrays.asList("b,banana,20", "b,apple,100");
        List<String> actual = myFileReaderCsv.readFromFile(TEST_FRUIT_REPORT_CSV);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeToFileEmptyData_Ok() {
        myFileWriterCsv.writeToFile(TEST_FRUIT_REPORT_CSV, emptyDataForWrite);
        List<String> expected = new ArrayList<>();
        List<String> actual = myFileReaderCsv.readFromFile(TEST_FRUIT_REPORT_CSV);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void writeToFileNull_NotOk() {
        myFileWriterCsv.writeToFile(TEST_FRUIT_REPORT_CSV, null);
        myFileReaderCsv.readFromFile(TEST_FRUIT_REPORT_CSV);
    }

    @Test(expected = RuntimeException.class)
    public void writeToFileDoNotExistFile_NotOk() {
        myFileWriterCsv.writeToFile("src/test/", dataForWrite);
    }

    @Test(expected = RuntimeException.class)
    public void writeToFileWhichLocked_NotOk() {
        myFileWriterCsv.writeToFile(TEST_FRUIT_WHICH_LOCK_CSV, dataForWrite);
        try {
            new RandomAccessFile(TEST_FRUIT_WHICH_LOCK_CSV, "rw").getChannel().lock();
            myFileReaderCsv.readFromFile(TEST_FRUIT_WHICH_LOCK_CSV);
        } catch (IOException e) {
            throw new RuntimeException("IOException",e);
        }
    }
}
