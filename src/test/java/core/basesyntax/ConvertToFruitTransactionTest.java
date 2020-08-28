package core.basesyntax;

import core.basesyntax.service.impl.ConvertToFruitTransaction;
import core.basesyntax.service.impl.FileServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConvertToFruitTransactionTest {

    private static FileServiceImpl fileService;
    private static String[] row;
    private static ConvertToFruitTransaction converter;
    private static List<String[]> fileData;


    @BeforeClass
    public static void setUp() {
        fileService = new FileServiceImpl();
        row = new String[] {"s","banana","100","2020-10-17"};
        converter = new ConvertToFruitTransaction();
        fileData = fileService.fileReader("src\\test\\java\\core\\basesyntax\\resources\\test0.csv");
    }

    @Test
    public void convertOk() {
        FruitTransaction actual = converter.convert(row);
        FruitTransaction expected = new FruitTransaction("s","banana",100, LocalDate.parse("2020-10-17"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fileDataToListOk() {
        List<FruitTransaction> expected = new ArrayList<>();
        expected.add(new FruitTransaction("s","banana",100,LocalDate.parse("2020-10-17")));
        expected.add(new FruitTransaction("b","banana",13,LocalDate.parse("2020-10-15")));
        expected.add(new FruitTransaction("r","banana",10,LocalDate.parse("2020-10-17")));
        List<FruitTransaction> actual = converter.fileDataToList(fileData);
        Assert.assertEquals(expected, actual);
    }
}