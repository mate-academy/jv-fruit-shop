package core.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CsvFileReaderServiceTest {
    private static FileReaderService fileReaderService;

    @Before
    public void beforeClass() {
        fileReaderService = new CsvFileReaderService();
    }

    @Test
    public void testForCorrectData() {
        List<String> expected = List.of("b,banana,20", "b,apple,100", "b,kiwi,50", "b,mango,60",
                "b,lemon,70", "s,banana,100", "p,banana,13", "p,kiwi,30", "r,apple,10",
                "p,apple,20", "p,lemon,20", "p,banana,5", "s,banana,50", "s,lemon,10",
                "p,mango,30");
        List<String> actual = fileReaderService.read(
                "src/test/resources/FruitShopUshakova.csv");
        assertEquals(expected, actual);

    }

    @Test
    public void testForCorrectDataSecond() {
        List<String> expected = List.of("b,banana,20", "b,apple,100", "s,banana,100", "p,banana,13",
                "r,apple,10", "p,apple,20", "p,banana,5", "s,banana,50");
        List<String> actual = fileReaderService.read(
                "src/test/resources/FruitShopChornovola.csv");
        assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectData() {
        fileReaderService.read("src/test/resources/TestTestTest.csv");
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectDataSecond() {
        fileReaderService.read("");
    }
}
