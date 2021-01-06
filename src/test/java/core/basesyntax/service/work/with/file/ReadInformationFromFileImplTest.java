package core.basesyntax.service.work.with.file;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReadInformationFromFileImplTest {
    private static ReadInformationFromFile readInformationFromFile;
    private static List<String> expectedList;
    private String fileName;

    @Before
    public void beforeAll() {
        readInformationFromFile = new ReadInformationFromFileImpl();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        expectedList = new ArrayList<>();
        expectedList.add("b,banana,20");
        expectedList.add("b,apple,100");
        expectedList.add("s,banana,100");
        expectedList.add("p,banana,13");
        expectedList.add("r,apple,10");
        expectedList.add("p,apple,20");
        expectedList.add("p,banana,5");
        expectedList.add("s,banana,50");
    }

    @After
    public void tearDown() throws Exception {
        Storage.fruits.clear();
    }

    @Test
    public void inputFile_Ok() {
        fileName = "database.csv";
        List<String> allLines = readInformationFromFile.getAllLines(fileName);
        assertEquals(expectedList, allLines);
    }

    @Test (expected = RuntimeException.class)
    public void inputFileName_NotOk() {
        fileName = "qwerty.csv";
        readInformationFromFile.getAllLines(fileName);
    }
}

