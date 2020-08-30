package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.products.FruitDto;
import core.basesyntax.storage.ListShopStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperationHandlerTest {
    public static final FruitDto DTO_FRUIT_S = new FruitDto();
    public static final FruitDto DTO_APPLE_S = new FruitDto();
    public static final FruitDto DTO_FRUIT_B = new FruitDto();
    public static final FruitDto DTO_FRUIT_R = new FruitDto();
    public static List<FruitDto> FRUIT_DTO_LIST = new ArrayList<>();
    public static final String BANANA = "banana";
    public static final String ORANGE = "orange";
    public static final String APPLE = "apple";


    @Before
    public void setUp() {
        ListShopStorage.listStorage.clear();
        DTO_FRUIT_S.setOperation("s");
        DTO_FRUIT_S.setName(BANANA);
        DTO_FRUIT_S.setAmount(10);
        DTO_FRUIT_S.setExpiredDate(LocalDate.of(2020, 1, 5));
        DTO_FRUIT_B.setOperation("b");
        DTO_FRUIT_B.setName(BANANA);
        DTO_FRUIT_B.setAmount(6);
        DTO_FRUIT_B.setExpiredDate(LocalDate.of(2020, 1, 4));
        DTO_FRUIT_R.setOperation("r");
        DTO_FRUIT_R.setName(BANANA);
        DTO_FRUIT_R.setAmount(2);
        DTO_FRUIT_R.setExpiredDate(LocalDate.of(2020, 1, 5));
        DTO_APPLE_S.setOperation("s");
        DTO_APPLE_S.setName(APPLE);
        DTO_APPLE_S.setAmount(10);
        DTO_APPLE_S.setExpiredDate(LocalDate.of(2020,12,25));
        FRUIT_DTO_LIST.add(DTO_FRUIT_S);
        FRUIT_DTO_LIST.add(DTO_FRUIT_B);
        FRUIT_DTO_LIST.add(DTO_FRUIT_R);
    }

    @Test
    public void operationWithProductOk() {
        OperationHandler operationHandler = new OperationHandler();
        operationHandler.handlingProduct(FRUIT_DTO_LIST);
        Assert.assertEquals(6, sumOfFruit(BANANA));
    }

    @Test(expected = IllegalArgumentException.class)
    public void operationWithWrongOperand() {
        DTO_FRUIT_S.setOperation("g");
        FRUIT_DTO_LIST.add(DTO_FRUIT_S);
        OperationHandler operationHandler = new OperationHandler();
        operationHandler.handlingProduct(FRUIT_DTO_LIST);
    }

    @Test(expected = DateTimeException.class)
    public void operationWithWrongDate() {
        DTO_FRUIT_S.setExpiredDate(LocalDate.of(2020,10,36));
        FRUIT_DTO_LIST.add(DTO_FRUIT_S);
        OperationHandler operationHandler = new OperationHandler();
        operationHandler.handlingProduct(FRUIT_DTO_LIST);
    }

    @Test
    public void operationWithTwoFruits() {
        FRUIT_DTO_LIST.add(DTO_APPLE_S);
        OperationHandler operationHandler = new OperationHandler();
        operationHandler.handlingProduct(FRUIT_DTO_LIST);
        Assert.assertEquals(10, sumOfFruit(APPLE));
    }

    public int sumOfFruit(String name) {
        Map<String, Integer> mapToFile = ListShopStorage.listStorage.stream()
                .collect(Collectors.groupingBy(Fruit::getName,
                        Collectors.summingInt(Fruit::getAmount)));
        return mapToFile.get(name);
    }
}
