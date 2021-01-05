package core.basesyntax.service.work.with.file;

import static org.junit.Assert.assertTrue;

import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReadFromCsvFileImplTest {
    private static ReadInformationFromFile readInformationFromFile;
    private String fileName;

    @Before
    public void beforeAll() {
        readInformationFromFile = new ReadInformationFromFileImpl();
    }

    @After
    public void tearDown() throws Exception {
        Storage.fruits.clear();
    }

    @Test
    public void inputFile_Ok() {
        fileName = "database.csv";
        boolean expected = true;
        List<String> expectedList = new ArrayList<>();
        expectedList.add("type,fruit,quantity");
        expectedList.add("b,banana,20");
        expectedList.add("b,apple,100");
        expectedList.add("s,banana,100");
        expectedList.add("p,banana,13");
        expectedList.add("r,apple,10");
        expectedList.add("p,apple,20");
        expectedList.add("p,banana,5");
        expectedList.add("s,banana,50");
        List<String> allLines = readInformationFromFile.getAllLines(fileName);
        for (int i = 0; i < expectedList.size(); i++) {
            expected = allLines.get(i).equals(expectedList.get(i));
            if (!expected) {
                break;
            }
        }
        assertTrue(expected);
    }

    @Test (expected = RuntimeException.class)
    public void inputFileName_NotOk() {
        fileName = "qwerty.csv";
        readInformationFromFile.getAllLines(fileName);
    }
}

