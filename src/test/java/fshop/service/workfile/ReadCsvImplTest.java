package fshop.service.workfile;

import static junit.framework.TestCase.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;

public class ReadCsvImplTest {
    @Test (expected = NullPointerException.class)
    public void createObject_null() {
        new ReadCsvImpl(null);
    }

    @Test (expected = RuntimeException.class)
    public void notExist_file() {
        new ReadCsvImpl("asdad").read();
    }

    @Test (expected = IllegalArgumentException.class)
    public void negative_valueOfFile() {
        new ReadCsvImpl("fileNegativeValues.csv").read();
    }

    @Test
    public void test1_readOk() throws IOException {
        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        List<String> expected = Files.readAllLines(Paths.get(new File("file.csv")
                .getAbsolutePath()));
        expected.remove(0);
        assertEquals(expected, readCsv.read());
    }

    @Test
    public void test2_readOk() throws IOException {
        ReadCsv readCsv = new ReadCsvImpl("file2.csv");
        List<String> expected = Files.readAllLines(Paths.get(new File("file2.csv")
                .getAbsolutePath()));
        expected.remove(0);
        assertEquals(expected, readCsv.read());
    }
}
