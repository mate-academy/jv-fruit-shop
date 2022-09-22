package core.basesyntax.service;

import core.basesyntax.exeptions.ValidationException;
import core.basesyntax.model.FruitDto;
import java.util.ArrayList;
import java.util.List;

public class FruitParser {
    private static final String HEADER = "type,fruit,quantity";

    public List<FruitDto> parserFruit(List<String> databaseInfo) throws ValidationException {
        if (databaseInfo.get(0).equals(HEADER)) {
            databaseInfo.remove(0);
        }
        List<FruitDto> fruitDtoList = new ArrayList<>();
        for (String s : databaseInfo) {
            FruitDto fruitDto = new FruitDto();
            String[] splitString = s.split(",");
            if (splitString.length > 1) {
                fruitDto.setType(splitString[0]);
                fruitDto.setFruit(splitString[1]);
                if (splitString.length == 2) {
                    throw new ValidationException("Value of quantity is not correct!");
                }
                if (Integer.parseInt(splitString[2]) == 0) {
                    throw new ValidationException("Value of quantity is not correct!");
                }
                fruitDto.setQuantity(Integer.parseInt(splitString[2]));
                fruitDtoList.add(fruitDto);
            } else {
                throw new ValidationException("File have a mistakes!");
            }
        }
        return fruitDtoList;
    }
}
