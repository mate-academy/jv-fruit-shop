package myFruitShop.Parser;

import myFruitShop.ValidationProces.Validator;
import myFruitShop.model.Fruit;
import myFruitShop.model.OperationType;
import myFruitShop.model.TransactionDto;
import myFruitShop.ValidationProces.ValidatorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FruitRecordToDto2 implements DtoCreator {
  //  ReadInfoImpl1 dataInStringList = new ReadInfoImpl1();
  //  ValidatorImpl fruitRecordsValidator = new ValidatorImpl(dataInStringList.g);
   // TransactionDto dataInDtoLineOfList = new TransactionDto();
    public List<TransactionDto> toDtoDataFormatter(List<String> rawRecords) {
        List<TransactionDto> parsedToDtoData = new ArrayList<>();
        Validator inputValidator = new ValidatorImpl();
        List<String> validData = inputValidator.validator(rawRecords);             //Validate;
        for (String fruitRecordLine : validData) {
            String standartRecordLine = fruitRecordLine.toLowerCase(Locale.ROOT);
            String [] fruitsRecordPart = standartRecordLine.split(",");
            TransactionDto fruitRecordLineDto = new TransactionDto();
              fruitRecordLineDto.setOperationType(OperationType.valueOf(fruitsRecordPart[1]));    // set walue to enum anf from enum to field
              fruitRecordLineDto.setFruitType(new Fruit(fruitsRecordPart[1]));                 // set name;
              fruitRecordLineDto.setAmount(Integer.parseInt(fruitsRecordPart[2]));
            parsedToDtoData.add(fruitRecordLineDto);
        }
        return parsedToDtoData;
    }
}
