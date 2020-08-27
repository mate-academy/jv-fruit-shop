package core.basesyntax.service;

import core.basesyntax.FruitDto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public List<FruitDto> parseData(List<String[]> lines) {
        List<FruitDto> fruitDtos = new ArrayList<>();
        for (String[] line : lines) {
            FruitDto fruitDto = new FruitDto();
            fruitDto.setTransaction(line[0]);
            fruitDto.setFruitType(line[1]);
            fruitDto.setQuantity(Integer.parseInt(line[2]));
            fruitDto.setDate(LocalDate.parse(line[3], DateTimeFormatter.ISO_LOCAL_DATE));
            fruitDtos.add(fruitDto);
        }
        return fruitDtos;
    }
}
