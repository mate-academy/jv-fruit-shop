package core.basesyntax;

import core.basesyntax.service.DoOperationImpl;
import core.basesyntax.service.ReadFromFileImpl;
import core.basesyntax.service.SetDataIntoMapImpl;
import core.basesyntax.service.WriteToFileImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

class Test {
    String dataPath = "src/test/resources/data";
    String resultPath = "src/test/resources/result";

    @org.junit.jupiter.api.Test
    void usualTest() {
        new Shop(dataPath, resultPath);
        List<String> expected = new ArrayList<>();
        expected.add("fruit,quantity");
        expected.add("banana,152");
        expected.add("apple,90");

        List<String> actual = new ArrayList<>();
        try {
            actual = Files.readAllLines(new File(resultPath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void readFromFileTest() {
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,20");
        expected.add("b,apple,100");
        expected.add("s,banana,100");
        expected.add("p,banana,13");
        expected.add("r,apple,10");
        expected.add("p,apple,20");
        expected.add("p,banana,5");
        expected.add("s,banana,50");

        List<String> actual = new ReadFromFileImpl().readFromFile(dataPath);

        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void setDataIntoMapTest() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("item_1", 1);
        expected.put("item_2", 2);
        expected.put("item_3", 3);

        List<String> parsedData = new ArrayList<>();
        parsedData.add("b,item_1,1");
        parsedData.add("b,item_2,2");
        parsedData.add("b,item_3,3");

        Map<String, Integer> actual = new HashMap<>();
        actual.put("item_1", 0);
        actual.put("item_2", 0);
        actual.put("item_3", 0);

        new SetDataIntoMapImpl().setDataIntoMap(actual, parsedData);

        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void writeToFileImplTest() {
        List<String> expected = new ArrayList<>();
        expected.add("fruit,quantity");
        expected.add("floop-loop,1");
        expected.add("ababagalamaga,2");
        expected.add("pum-purum,3");

        Map<String, Integer> map = new HashMap<>();
        map.put("floop-loop", 1);
        map.put("ababagalamaga", 2);
        map.put("pum-purum", 3);
        new WriteToFileImpl().write(resultPath, map);

        List<String> actual = new ArrayList<>();
        try {
            actual = Files.readAllLines(new File(resultPath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void incorrectOperationTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("item_1", 0);
        map.put("item_2", 0);
        map.put("item_3", 0);

        Assertions.assertThrows(RuntimeException.class, () -> {
            new DoOperationImpl().doOperation(map, "H", "key", "123");
        });
    }
}
