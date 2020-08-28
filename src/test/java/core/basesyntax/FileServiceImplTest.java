package core.basesyntax;

import core.basesyntax.service.impl.ConvertToFruitTransaction;
import core.basesyntax.service.impl.FileServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImplTest {

    private static FileServiceImpl fileService;
    private static ConvertToFruitTransaction converter;

    @BeforeClass
    public static void createServices() {
        fileService = new FileServiceImpl();
        converter = new ConvertToFruitTransaction();
    }

    @Test
    public void fileReaderTestOk() {
        List<String[]> data = fileService.fileReader("src/test/java/core/basesyntax/resources/test0.csv");
        List<FruitTransaction> actual = converter.fileDataToList(data);
        List<FruitTransaction> expected = new ArrayList<>();
        expected.add(new FruitTransaction("s","banana",100, LocalDate.parse("2020-10-17")));
        expected.add(new FruitTransaction("b","banana",13,LocalDate.parse("2020-10-15")));
        expected.add(new FruitTransaction("r","banana",10,LocalDate.parse("2020-10-17")));
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RuntimeException.class)
    public void fileReaderTestFileNotExist() {
        fileService.fileReader("src\\test\\java\\core\\basesyntax\\resources\\noTest.csv");
    }
}