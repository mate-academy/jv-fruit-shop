package dao;

import bd.Storage;
import model.FruitRecordDto;

public class FruitRecordDaoUseFileImpl implements FruitRecordDao {

    @Override
    public void add(FruitRecordDto fruitRecordDto) {
        Storage.records.add(fruitRecordDto);
    }
}
