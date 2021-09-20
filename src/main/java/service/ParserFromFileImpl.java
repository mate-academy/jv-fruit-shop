package service;

import model.FruitRecordDto;

public class ParserFromFileImpl implements Parser {
    private static final int ACTIVITIES_TYPE = 0;
    private static final int NAME_GOODS = 1;
    private static final int AMOUNT = 2;

    @Override
    public FruitRecordDto pars(String line) {
        FruitRecordDto fruitRecordDto = new FruitRecordDto();
        String[] lineSplit = line.split(",");
        fruitRecordDto.setType(Validator.checkType(lineSplit[ACTIVITIES_TYPE]));
        fruitRecordDto.setNameGoods(Validator.checkNameGoods(line.split(",")[NAME_GOODS]));
        fruitRecordDto.setAmount(Validator.checkAmount(Integer.parseInt(line.split(",")[AMOUNT])));
        return fruitRecordDto;
    }
}
