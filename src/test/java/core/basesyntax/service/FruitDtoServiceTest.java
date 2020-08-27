package core.basesyntax.service;

import core.basesyntax.products.FruitDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FruitDtoServiceTest {
    public static final String LINE_ONE = "type,fruit,quantity,date";
    public static final String LINE_TWO = "s,banana,100,2020-10-17";
    public static final String LINE_THREE = "b,banana,50,2020-10-15";
    public static List<String[]> LIST_ARRAYS_OF_STRINGS = new ArrayList();
    public static FruitDto fruitDto = new FruitDto();

    @Before
    public void setUp() {
//        LIST_ARRAYS_OF_STRINGS.add(LINE_ONE.split(","));
        LIST_ARRAYS_OF_STRINGS.add(LINE_TWO.split(","));
        LIST_ARRAYS_OF_STRINGS.add(LINE_THREE.split(","));
        fruitDto.setOperation("s");
        fruitDto.setName("banana");
        fruitDto.setAmount(100);
        fruitDto.setExpiredDate(LocalDate.of(2020,10,17));
    }

    @Test
    public void converttoDtoOk() {
        FruitDtoService fruitDtoService = new FruitDtoService();
        List<FruitDto> fruitDtoList = fruitDtoService.convertToFruitDto(LIST_ARRAYS_OF_STRINGS);
        Assert.assertEquals(fruitDto, fruitDtoList.get(0));
    }

    @Test(expected = DateTimeException.class)
    public void dtoFalseDate() {
        fruitDto.setExpiredDate(LocalDate.of(2020, 12, 33));
        FruitDtoService fruitDtoService = new FruitDtoService();
        List<FruitDto> fruitDtoList = fruitDtoService.convertToFruitDto(LIST_ARRAYS_OF_STRINGS);
        Assert.assertEquals(fruitDto, fruitDtoList.get(0));
    }
}
