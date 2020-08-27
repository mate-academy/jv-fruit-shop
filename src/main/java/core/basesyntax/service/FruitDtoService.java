package core.basesyntax.service;

import core.basesyntax.products.FruitDto;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class FruitDtoService {
    public List<FruitDto> convertToFruitDto(List<String[]> fruitsFromFile) {
        List<FruitDto> fruitDtoList = new ArrayList<>();
        for (String[] fruit : fruitsFromFile) {
            FruitDto fruitDto = new FruitDto();
            fruitDto.setOperation(fruit[0].toLowerCase());
            fruitDto.setName(fruit[1]);
            fruitDto.setAmount(Integer.parseInt(fruit[2]));
            try {
                fruitDto.setExpiredDate(LocalDate.parse(fruit[3]));
            } catch (Exception e) {
                throw new DateTimeParseException("Error in parsing ",
                        fruit[3] == null ? "null" : fruit[3], 3);
            }
            fruitDtoList.add(fruitDto);
        }
        return fruitDtoList;
    }
}
