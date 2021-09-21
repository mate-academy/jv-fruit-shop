package myFruitShop.Parser;

import myFruitShop.ValidationProces.Validator;
import myFruitShop.model.Fruit;
import myFruitShop.model.OperationType;
import myFruitShop.model.OperationsDto;
import myFruitShop.ValidationProces.ValidatorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DtoCreationImpl implements DtoCreator {

    public List<OperationsDto> toDtoDataFormatter(List<String> stringsRecords) {
        List<OperationsDto> parsedToDtoData = new ArrayList<>();

        for (String fruitRecordLine : stringsRecords) {
            String standartRecordLine = fruitRecordLine.toLowerCase(Locale.ROOT);
            String [] fruitsRecordPart = standartRecordLine.split(",");
            if (OperationType.valueOfLabel(fruitsRecordPart[0].trim()) == null) {           // if its's not value about operation, scip It
                continue;
            }
            OperationsDto fruitRecordLineDto = new OperationsDto();
              fruitRecordLineDto.setOperationType(OperationType.valueOfLabel(fruitsRecordPart[0].trim()));
              fruitRecordLineDto.setFruitType(new Fruit(fruitsRecordPart[1]));                 // set name;
              fruitRecordLineDto.setAmount(Integer.parseInt(fruitsRecordPart[2]));
            parsedToDtoData.add(fruitRecordLineDto);
        }
        return parsedToDtoData;
    }
}
