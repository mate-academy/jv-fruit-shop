package core.basesyntax.service;

import core.basesyntax.products.FruitDto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class FruitDtoService {
    private static final int OPERATION_POSITION = 0;
    private static final int NAME_POSITION = 1;
    private static final int AMOUNT_POSITION = 2;
    private static final int DATE_POSITION = 3;

    public List<FruitDto> convertToFruitDto(List<String[]> fruitsFromFile) {
        List<FruitDto> fruitDtoList = new ArrayList<>();
        for (String[] fruit : fruitsFromFile) {
            FruitDto fruitDto = new FruitDto();
            fruitDto.setOperation(fruit[OPERATION_POSITION].toLowerCase());
            fruitDto.setName(fruit[NAME_POSITION]);
            fruitDto.setAmount(Integer.parseInt(fruit[AMOUNT_POSITION]));
            try {
                fruitDto.setExpiredDate(LocalDate.parse(
                        fruit[DATE_POSITION], DateTimeFormatter.ISO_LOCAL_DATE));
            } catch (Exception e) {
                throw new DateTimeParseException("Error in parsing ",
                        fruit[DATE_POSITION] == null ? "null"
                                : fruit[DATE_POSITION], DATE_POSITION);
            }
            fruitDtoList.add(fruitDto);
        }
        return fruitDtoList;
    }
}
