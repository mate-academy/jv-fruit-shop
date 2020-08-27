package core.basesyntax.service;

import core.basesyntax.FruitDto;
import core.basesyntax.FruitStorage;
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
        fruitDtoTwo.setTransaction(TRANSACTION_TYPE_BUY);
        fruitDtoTwo.setFruitType(FRUIT_TYPE);
        fruitDtoTwo.setQuantity(QUANTITY_TWO);
        fruitDtoTwo.setDate(DATE_TWO);
        FruitDto fruitDtoThree = new FruitDto();
        fruitDtoThree.setTransaction(TRANSACTION_TYPE_RETURN);
        fruitDtoThree.setFruitType(FRUIT_TYPE);
        fruitDtoThree.setQuantity(QUANTITY_THREE);
        fruitDtoThree.setDate(DATE_ONE);
        expectedFruitDtos.add(fruitDtoOne);
        expectedFruitDtos.add(fruitDtoTwo);
        expectedFruitDtos.add(fruitDtoThree);
        FruitStorage.clearStock();
        List<FruitDto> actualFruitDtos = dataParser.parseData(data);
        int actualSize = expectedFruitDtos.size();
        int expectedSize = 3;
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedFruitDtos.get(0), actualFruitDtos.get(0));
        Assert.assertEquals(expectedFruitDtos.get(1), actualFruitDtos.get(1));
        Assert.assertEquals(expectedFruitDtos.get(2), actualFruitDtos.get(2));
    }
}
