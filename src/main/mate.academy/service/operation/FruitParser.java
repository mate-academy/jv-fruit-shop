package service.operation;

import dao.Validator;
import dao.ValidatorImpl;
import model.Fruit;
import model.FruitRecord;
import java.util.ArrayList;
import java.util.List;

public class FruitParser {
    private static final int TYPE_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SPLIT_SYMBOL = ",";
    Validator lineValidator = new ValidatorImpl();

    public List<FruitRecord> createDto(List<String> list) {
        String[] split;
        List<FruitRecord> fruitRecords = new ArrayList<>();
        for (String newSplit : list) {
            split = newSplit.split(SPLIT_SYMBOL);
            lineValidator.validator(split);
            fruitRecords.add(new FruitRecord(split[TYPE_INDEX],
                    new Fruit(split[NAME_INDEX]),
                    Integer.parseInt(split[AMOUNT_INDEX])));
        }
        return fruitRecords;
    }
}