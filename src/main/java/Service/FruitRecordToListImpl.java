package Service;

import Service.fruitRecord.FruitRecord;
import validator.Validator;
import validator.ValidatorImpl;

import java.util.ArrayList;
import java.util.List;

public class FruitRecordToListImpl implements FruitRecordToList {
    @Override
    public List<FruitRecord> fruitRecordToList(String stringFruit) {
        List<FruitRecord> fruitRecordList = new ArrayList<>();
        Validator validator = new ValidatorImpl();
        String[] array = stringFruit.split(" ");
        for (String data : array) {
            String[] splitData = data.split(",");
            validator.validate(splitData);
            FruitRecord fruitRecord = new FruitRecord(splitData);
            fruitRecordList.add(fruitRecord);
        }
        return fruitRecordList;
    }

}
