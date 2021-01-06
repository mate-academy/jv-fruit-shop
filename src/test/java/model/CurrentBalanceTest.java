package model;

import exception.FruitShopException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CurrentBalanceTest {
    @Test
    public void checkBalanceWriter_Ok() {
        final String filePath = "src/test/resources/Output_file.csv";
        CurrentBalance currentBalance = new CurrentBalance();
        currentBalance.addBalance(new Fruit("banana"), 100);
        currentBalance.addBalance(new Fruit("apple"), 150);
        currentBalance.saveOutPut(filePath);
        List<String> actual = new ArrayList<String>();
        try {
            actual = Files.readAllLines(Path.of(filePath));
        } catch (IOException ignored) {
            throw new FruitShopException("Wrong data");
        }
        List<String> expected = Arrays.asList("fruit,quantity", "banana,100", "apple,150");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = FruitShopException.class)
    public void checkSaveWrongFile_NotOk() {
        CurrentBalance currentBalance = new CurrentBalance();
        currentBalance.saveOutPut("file name can't be with \0");
    }
}
