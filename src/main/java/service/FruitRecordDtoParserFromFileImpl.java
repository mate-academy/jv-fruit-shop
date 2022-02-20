package service;

import model.FruitRecordDto;

public class FruitRecordDtoParserFromFileImpl implements FruitRecordDtoParser {
    private static final int ACTIVITIES_TYPE = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;

    @Override
    public FruitRecordDto parse(String line) {
        FruitRecordDto fruitRecordDto = new FruitRecordDto();
        String[] lineSplit = line.split(",");
        fruitRecordDto.setType(Validator.checkType(lineSplit[ACTIVITIES_TYPE]));
        fruitRecordDto.setFruit(Validator.checkFruitName(line.split(",")[FRUIT]));
        fruitRecordDto.setAmount(Validator.checkAmount(Integer.parseInt(line.split(",")[AMOUNT])));
        return fruitRecordDto;
    }
}
