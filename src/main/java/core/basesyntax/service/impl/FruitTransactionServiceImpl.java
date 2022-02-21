package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitDto;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionServiceImpl {
    private static final String COMMA_SEPARATOR = ",";

    public List<FruitDto> parser(String inputData) {
        String[] lines = inputData.split(System.lineSeparator());
        List<FruitDto> fruitList = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            String[] temp = lines[i].split(COMMA_SEPARATOR);
            FruitDto fruitDto = new FruitDto();
            fruitDto.setType(temp[0]);
            fruitDto.setName(temp[1]);
            fruitDto.setQuantity(Integer.parseInt(temp[2]));
            fruitList.add(fruitDto);
        }
        return fruitList;
    }
}

