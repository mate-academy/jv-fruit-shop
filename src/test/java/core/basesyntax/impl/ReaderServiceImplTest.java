package core.basesyntax.impl;

import core.basesyntax.service.util.ReaderService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReaderServiceImplTest {
    private final ReaderService readerService = new ReaderServiceImpl();
    private final List<String> expected = new ArrayList<>();

    @Test
    void readFromFileToList_Ok() {
        String fileFrom = "src/test/resources/fileFromTest.csv";
        expected.add("type,fruit,quantity");
        expected.add("    b,banana,20");
        expected.add("    b,apple,100");
        expected.add("    s,banana,100");
        expected.add("    p,banana,13");
        List<String> actual = readerService.readFromFileToList(fileFrom);
        Assertions.assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    void readFromFileToList_fileNotExist_notOk() {
        String fileFrom = "src/test/resources/fileNotExist.csv";
        Assertions.assertThrows(RuntimeException.class, () ->
                readerService.readFromFileToList(fileFrom));
    }

    @Test
    void readFromFileToList_emptyFile_Ok() {
        String fileFrom = "src/test/resources/fileFromTestEmpty.csv";
        List<String> actual = readerService.readFromFileToList(fileFrom);
        Assertions.assertTrue(actual.isEmpty());
    }

    @Test
    void readFromFileToList_oneLineFile_Ok() {
        String fileFrom = "src/test/resources/fileFromTestOneLine.csv";
        List<String> actual = readerService.readFromFileToList(fileFrom);
        Assertions.assertEquals(actual.size(), 1);
    }
}
