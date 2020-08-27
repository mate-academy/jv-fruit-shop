package core.basesyntax;

import core.basesyntax.model.FruitDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class StorageTest {
    private static final FruitDto FRUIT_DTO = new FruitDto.FruitDtoBuilder()
            .setName("banana")
            .setDate(LocalDate.parse("2017-10-12"))
            .setQuantity(120)
            .build();
    private static final FruitDto FRUIT_DTO_SECOND = new FruitDto.FruitDtoBuilder()
            .setName("banana")
            .setDate(LocalDate.parse("2017-10-13"))
            .setQuantity(100)
            .build();
    private static final FruitDto INCORRECT_FRUIT_DTO = new FruitDto.FruitDtoBuilder()
            .setName("orange")
            .setDate(LocalDate.parse("2017-10-12"))
            .setQuantity(120)
            .build();
    private static final FruitDto FRUIT_DTO_THIRD = new FruitDto.FruitDtoBuilder()
            .setName("banana")
            .setDate(LocalDate.parse("2017-10-15"))
            .setQuantity(150)
            .build();
    private Storage storage;

    @Before
    public void init() {
        storage = new Storage();
    }

    @Test(expected = NoSuchElementException.class)
    public void checkRemoveItemDataFromEmptyStorage() {
        storage.removeItemData(FRUIT_DTO);
    }

    @Test(expected = NoSuchElementException.class)
    public void checkGetListInfoFromEmptyStorage() {
        storage.getListInfo();
    }

    @Test
    public void checkAddItemData() {
        storage.addItemData(FRUIT_DTO);
        Assert.assertEquals(storage.getFruitsStorage().size(), 1);
    }

    @Test(expected = NoSuchElementException.class)
    public void checkRemoveItemDataFromStorage() {
        storage.addItemData(FRUIT_DTO);
        storage.removeItemData(FRUIT_DTO);
    }

    @Test(expected = NoSuchElementException.class)
    public void checkRemoveEmptyItemDataFromStorage() {
        storage.addItemData(FRUIT_DTO);
        storage.removeItemData(INCORRECT_FRUIT_DTO);
    }

    @Test
    public void checkGetListInfoCorrect() {
        storage.addItemData(FRUIT_DTO);
        Assert.assertEquals(2, storage.getListInfo().size());
    }

    @Test
    public void checkRemoveItemDataWithDifferentParams() {
        storage.addItemData(FRUIT_DTO);
        storage.addItemData(FRUIT_DTO_THIRD);
        storage.addItemData(FRUIT_DTO_SECOND);
        storage.removeItemData(FRUIT_DTO);
        List<String> actual = storage.getListInfo();
        List<String> expected = List.of("fruit,quantity", "banana,130");
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(2, actual.size());
    }
}