package core.dao;

import core.db.Storage;
import core.exception.ValidationException;
import core.model.FruitRecord;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDaoImpl implements FruitRecordDao {
    private ValidatorImpl validator = new ValidatorImpl();

    @Override
    public void add(FruitRecord fruitRecord) {
        for (FruitRecord record : Storage.getListFruits()) {
            if (record.getFruit() != null && isPresentInDB(fruitRecord)) {
                int currentAmount = record.getAmount();
                record.setAmount(currentAmount + fruitRecord.getAmount());
                return;
            }
        }
        Storage.getListFruits().add(fruitRecord);
    }

    public boolean isPresentInDB(FruitRecord fruitRecord) {
        for (FruitRecord record : Storage.getListFruits()) {
            if (record != null && record.equals(fruitRecord)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<FruitRecord> parseFruitRecords(List<String> rawRecords) throws ValidationException {
        List<FruitRecord> fruitRecordList = new ArrayList<>();
        for (int i = 0; i < rawRecords.size(); i++) {
            fruitRecordList.add(mapToFruit(rawRecords.get(i)));
        }
        return fruitRecordList;
    }

    public FruitRecord mapToFruit(String record) throws ValidationException {
        validator.validate(record);
        String[] splitRecord = record.split(",");
        FruitRecord fruitRecord = new FruitRecord();
        fruitRecord.setFruit(splitRecord[1]);
        fruitRecord.setOperationType(splitRecord[0]);
        fruitRecord.setAmount(Integer.parseInt(splitRecord[2]));
        return fruitRecord;
    }
}
