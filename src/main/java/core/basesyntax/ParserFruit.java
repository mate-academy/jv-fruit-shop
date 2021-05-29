package core.basesyntax;

import core.basesyntax.exeptions.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

public class ParserFruit {
    public List<FruitDto> parserFruit(List<String> databaseInfo) throws AuthenticationException {
        databaseInfo.remove(0);
        List<FruitDto> fruitDtoList = new ArrayList<>();
        for (String s : databaseInfo) {
            FruitDto fruitDto = new FruitDto();
            String[] splitString = s.split(",");
            if (splitString.length > 1) {
                fruitDto.setType(splitString[0]);
                fruitDto.setFruit(splitString[1]);
                if (Integer.parseInt(splitString[2]) < 0) {
                    throw new AuthenticationException("Value of quantity is not correct!");
                }
                fruitDto.setQuantity(splitString[2]);
                fruitDtoList.add(fruitDto);
            } else {
                throw new AuthenticationException("File have a mistakes!");
            }
        }
        return fruitDtoList;
    }

}
