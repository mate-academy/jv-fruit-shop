package core.basesyntax.service;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.service.work.with.file.ReadInformationFromFile;
import core.basesyntax.service.work.with.file.ReadInformationFromFileImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FruitServiceImplTest {
    FruitService fruitService;
    ReadInformationFromFile readInformationFromFile;

    @Before
    public void setUp() throws Exception {
        fruitService = new FruitServiceImpl();
        readInformationFromFile = new ReadInformationFromFileImpl();
    }

    @Test
    public void inputData_Ok() {
        List<String> list = new ArrayList<>();
        list.add("b,apple,100");
        list.add("s,banana,4");
        list.add("r,banana,1");
        fruitService.addNewFruit(list);
        assertEquals(2, Storage.fruits.size());
        Storage.fruits.clear();
    }
}

