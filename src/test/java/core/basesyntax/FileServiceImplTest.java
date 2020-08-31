package core.basesyntax;

import core.basesyntax.service.impl.FileServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImplTest {

    private static final Path FILE_PATH = Paths.get("src/test/resources/output.csv");
    private static FileServiceImpl fileService;

    @BeforeClass
    public static void createServices() {
        fileService = new FileServiceImpl();
    }

    @Test
    public void fileReaderTestOk() {
        List<FruitTransaction> actual = fileService.readFile("src/test/resources/test0.csv");
        List<FruitTransaction> expected = new ArrayList<>();
        expected.add(new FruitTransaction("s","banana",100, LocalDate.parse("2020-10-17")));
        expected.add(new FruitTransaction("b","banana",13,LocalDate.parse("2020-10-15")));
        expected.add(new FruitTransaction("r","banana",10,LocalDate.parse("2020-10-17")));
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RuntimeException.class)
    public void readFileTestFileNotExist() {
        fileService.readFile("src/test/resources/noFileTest.csv");
    }

    @Test
    public void fileWriterTest() {
        FruitStorage fruitStorage = new FruitStorage();
        Fruit fruitA = new Fruit();
        fruitA.setName("banana");
        fruitA.setDate(LocalDate.of(2020, 8, 20));
        Fruit fruitB = new Fruit();
        fruitB.setName("apple");
        fruitB.setDate(LocalDate.of(2020, 8, 24));
        fruitStorage.add(fruitA);
        fruitStorage.add(fruitB);
        List<String> outputData = fruitStorage.getReport();
        fileService.writeFile("src/test/resources/output.csv", outputData);
        Assert.assertTrue(Files.exists(FILE_PATH));
    }
}
