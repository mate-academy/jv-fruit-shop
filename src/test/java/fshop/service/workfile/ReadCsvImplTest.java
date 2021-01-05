package fshop.service.workfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReadCsvImplTest {
    @Test
    void createObject_null() {
        Assertions.assertThrows(NullPointerException.class, () -> new ReadCsvImpl(null));
    }

    @Test
    void notExist_file() {
        Assertions.assertThrows(RuntimeException.class, () -> new ReadCsvImpl("asdad").read());
    }

    @Test
    void negative_valueOfFile() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ReadCsvImpl("fileNegativeValues.csv").read());
    }

    @Test
    void test1_readOk() throws IOException {
        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        List<String> expected = Files.readAllLines(Paths.get(new File("file.csv")
                .getAbsolutePath()));
        expected.remove(0);
        Assertions.assertEquals(expected, readCsv.read());
    }

    @Test
    void test2_readOk() throws IOException {
        ReadCsv readCsv = new ReadCsvImpl("file2.csv");
        List<String> expected = Files.readAllLines(Paths.get(new File("file2.csv")
                .getAbsolutePath()));
        expected.remove(0);
        Assertions.assertEquals(expected, readCsv.read());
    }
}
