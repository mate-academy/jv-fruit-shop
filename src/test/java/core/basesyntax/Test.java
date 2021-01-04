package core.basesyntax;

import core.basesyntax.service.ReadFromFileImpl;
import core.basesyntax.service.SetDataIntoMapImpl;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Test {
    @org.junit.jupiter.api.Test
    void usualTest() {
        new Shop("data", "result");
        List<String> expected = new ArrayList<>();
        expected.add("fruit,quantity");
        expected.add("banana,152");
        expected.add("apple,90");

        List<String> actual = new ArrayList<>();
        try {
            actual = Files.readAllLines(new File("result").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actual);
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

        List<String> actual = new ReadFromFileImpl().readFromFile("data");
        
        Assert.assertEquals(expected, actual);
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

        Assert.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void writeToFileImplTest() {

    }
}