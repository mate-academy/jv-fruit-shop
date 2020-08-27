package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataParserTest {
    private static DataParser dataParser = new DataParser();
    private static List<String[]> data = new ArrayList<>();
    private static String TRANSACTION_TYPE_BUY = "b";
    private static final String TRANSACTION_TYPE_SUPPLY = "s";
    private static final String TRANSACTION_TYPE_RETURN = "r";
    private static final String FRUIT_TYPE = "banana";
    private static final int QUANTITY_ONE = 100;
    private static final int QUANTITY_TWO = 15;
    private static final int QUANTITY_THREE = 2;
    private static final LocalDate DATE_ONE = LocalDate.of(2020, 11, 1);
    private static final LocalDate DATE_TWO = LocalDate.of(2020, 10, 10);

    @BeforeClass
    public static void setUp() {
        String[] FirstLine = new String[]{"s", "banana", "100", "2020-11-01"};
        String[] SecondLine = new String[]{"b", "banana", "15", "2020-10-10"};
        String[] ThirdLine = new String[]{"r", "banana", "2", "2020-11-01"};
        data.add(FirstLine);
        data.add(SecondLine);
        data.add(ThirdLine);
    }

    @Test
    public void parseData_correctWork() {
        List<FruitDto> expectedFruitDtos = new ArrayList<>();
        FruitDto fruitDtoOne = new FruitDto();
        fruitDtoOne.setTransaction(TRANSACTION_TYPE_SUPPLY);
        fruitDtoOne.setFruitType(FRUIT_TYPE);
        fruitDtoOne.setQuantity(QUANTITY_ONE);
        fruitDtoOne.setDate(DATE_ONE);
        FruitDto fruitDtoTwo = new FruitDto();
        fruitDtoOne.setTransaction(TRANSACTION_TYPE_BUY);
        fruitDtoOne.setFruitType(FRUIT_TYPE);
        fruitDtoOne.setQuantity(QUANTITY_TWO);
        fruitDtoOne.setDate(DATE_TWO);
        FruitDto fruitDtoThree = new FruitDto();
        fruitDtoOne.setTransaction(TRANSACTION_TYPE_RETURN);
        fruitDtoOne.setFruitType(FRUIT_TYPE);
        fruitDtoOne.setQuantity(QUANTITY_THREE);
        fruitDtoOne.setDate(DATE_ONE);
        expectedFruitDtos.add(fruitDtoOne);
        expectedFruitDtos.add(fruitDtoTwo);
        expectedFruitDtos.add(fruitDtoThree);
        List<FruitDto> actualFruitDtos = dataParser.parseData(data);
        int actualSize = expectedFruitDtos.size();
        int expectedSize = 3;
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(DATE_ONE, actualFruitDtos.get(0).getDate());
        Assert.assertEquals(DATE_TWO, actualFruitDtos.get(1).getDate());
        Assert.assertEquals(DATE_ONE, actualFruitDtos.get(2).getDate());
    }
}
