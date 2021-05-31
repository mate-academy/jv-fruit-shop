package core.basesyntax;

import core.basesyntax.exeptions.WrongQuantityException;
import java.util.ArrayList;
import java.util.List;

public class ParserFruit {
    public List<FruitDto> parserFruit(List<String> databaseInfo) throws WrongQuantityException {
        if (databaseInfo.get(0).equals("type,fruit,quantity")) {
            databaseInfo.remove(0);
        }
        List<FruitDto> fruitDtoList = new ArrayList<>();
        for (String s : databaseInfo) {
            FruitDto fruitDto = new FruitDto();
            String[] splitString = s.split(",");
            if (splitString.length > 1) {
                fruitDto.setType(splitString[0]);
                fruitDto.setFruit(splitString[1]);
                if (Integer.parseInt(splitString[2]) < 0) {
                    throw new WrongQuantityException("Value of quantity is not correct!");
                }
                fruitDto.setQuantity(Integer.parseInt(splitString[2]));
                fruitDtoList.add(fruitDto);
            } else {
                throw new WrongQuantityException("File have a mistakes!");
            }
        }
        return fruitDtoList;
    }

}
