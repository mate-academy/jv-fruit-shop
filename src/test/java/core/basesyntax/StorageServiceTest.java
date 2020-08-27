package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.servise.StorageService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class StorageServiceTest {
    private static final FruitDto FRUIT_DTO = new FruitDto.FruitDtoBuilder()
            .setName("banana")
            .setDate(LocalDate.parse("2017-10-12"))
            .setQuantity(120)
            .build();
    private static final FruitDto FRUIT_DTO2 = new FruitDto.FruitDtoBuilder()
            .setName("banana")
            .setDate(LocalDate.parse("2017-10-10"))
            .setQuantity(150)
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
    private StorageService storageService;

    @Before
    public void init() {
        storageService = new StorageService();
    }

    @Test(expected = NoSuchElementException.class)
    public void checkRemoveItemDataFromEmptyStorage() {
        storageService.removeItemData(FRUIT_DTO);
    }

    @Test(expected = NoSuchElementException.class)
    public void checkGetListInfoFromEmptyStorage() {
        storageService.getListInfo();
    }

    @Test
    public void checkAddItemData() {
        storageService.addItemData(FRUIT_DTO);
        Assert.assertEquals(storageService.getFruitsStorage().size(), 1);
    }

    @Test(expected = NoSuchElementException.class)
    public void checkRemoveItemDataFromStorage() {
        storageService.addItemData(FRUIT_DTO);
        storageService.removeItemData(FRUIT_DTO);
    }

    @Test(expected = NoSuchElementException.class)
    public void checkRemoveEmptyItemDataFromStorage() {
        storageService.addItemData(FRUIT_DTO);
        storageService.removeItemData(INCORRECT_FRUIT_DTO);
    }

    @Test
    public void checkGetListInfoCorrect() {
        storageService.addItemData(FRUIT_DTO);
        Assert.assertEquals(2, storageService.getListInfo().size());
    }

    @Test
    public void checkRemoveItemDataCorrect() {
        storageService.addItemData(FRUIT_DTO);
        try {
            storageService.removeItemData(FRUIT_DTO2);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(e.getMessage(), "Can get only 120 banana");
        }
        List<String> listInfo = storageService.getListInfo();
        Assert.assertEquals(List.of("fruit,quantity","banana,120"), listInfo);
    }

    @Test
    public void checkRemoveItemDataWithDifferentParams() {
        storageService.addItemData(FRUIT_DTO);
        storageService.addItemData(FRUIT_DTO_THIRD);
        storageService.addItemData(FRUIT_DTO_SECOND);
        storageService.removeItemData(FRUIT_DTO);
        List<String> actual = storageService.getListInfo();
        List<String> expected = List.of("fruit,quantity", "banana,130");
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(2, actual.size());
    }
}