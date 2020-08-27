package core.basesyntax.operations;

import core.basesyntax.service.CsvFileReaderImpl;
import core.basesyntax.storage.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class FruitActionTest {
    private static FruitAction act;
    private static CsvFileReaderImpl fileReader;

    @BeforeClass
    public static void beforeClass() {
        act = new FruitAction();
        fileReader = new CsvFileReaderImpl();
    }

    @Before
    public void before() {
        Storage.getStockBalance().clear();
    }

    @Test
    public void actionSupplyTest() {
        List<List<String>> testList;
        String path = "src/main/resources/supplyCorrect.csv";
        testList = fileReader.readFile(path);
        act.action(testList);
        Assert.assertTrue(act.result);
    }

    @Test
    public void actionBuyTest() {
        List<List<String>> testList;
        String path = "src/main/resources/buyCorrect.csv";
        testList = fileReader.readFile(path);
        act.action(testList);
        Assert.assertTrue(act.result);
    }

    @Test
    public void actionReturnTest() {
        List<List<String>> testList;
        String path = "src/main/resources/returnCorrect.csv";
        testList = fileReader.readFile(path);
        act.action(testList);
        Assert.assertTrue(act.result);
    }

    @Test
    public void isEmptyListTest() {
        List<List<String>> testList = new ArrayList<>();
        List<String> emptyList = new ArrayList<>();
        testList.add(emptyList);
        Assert.assertFalse(act.action(testList));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void soldOutFruitTest() {
        List<List<String>> testList;
        String path = "src/main/resources/unsupportedOperation.csv";
        testList = fileReader.readFile(path);
        act.action(testList);
    }
}
