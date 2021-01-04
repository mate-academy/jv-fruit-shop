package core.basesyntax.service.work.with.file;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReadFromCsvFileImplTest {
    private static FruitDao fruitDao;
    private ReadFromCsvFile readFromCsvFile;
    private String fileName;

    @BeforeAll
    static void beforeAll() {
        fruitDao = new FruitDaoImpl();
    }

    @Test
    void inputFile_Ok() {
        fileName = "database.csv";
        readFromCsvFile = new ReadFromCsvFileImpl(fruitDao, fileName);
        List<String[]> expectedList = new ArrayList<>();
        boolean expected = true;
        expectedList.add(new String[]{"s", "banana", "100"});
        expectedList.add(new String[]{"p", "banana", "13"});
        expectedList.add(new String[]{"r", "apple", "10"});
        expectedList.add(new String[]{"p", "apple", "20"});
        expectedList.add(new String[]{"p", "banana", "5"});
        expectedList.add(new String[]{"s", "banana", "50"});
        for (int i = 0; i < expectedList.size(); i++) {
            expected = Arrays.toString(readFromCsvFile.readInformationFromFile()
                    .get(i)).equals(Arrays.toString(expectedList.get(i)));
            if (!expected) {
                break;
            }
        }
        assertTrue(expected);
        Storage.fruits.clear();
    }

    @Test
    void inputFileName_NotOk() {
        fileName = "qwerty.csv";
        readFromCsvFile = new ReadFromCsvFileImpl(fruitDao, fileName);
        assertThrows(RuntimeException.class, () -> readFromCsvFile.readInformationFromFile());
    }
}
