package dao;

import bd.Storage;
import model.FruitRecordDto;

public class OperationDaoUseFileImpl implements OperationDao {

    @Override
    public void add(FruitRecordDto fruitRecordDto) {
        Storage.storageFruitShop.add(fruitRecordDto);
    }
}
