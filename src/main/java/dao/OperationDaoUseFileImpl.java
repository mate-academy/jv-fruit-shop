package dao;

import bd.Storage;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitRecordDto;

public class OperationDaoUseFileImpl implements OperationDao {

    @Override
    public void add(FruitRecordDto fruitRecordDto) {
        Storage.storageFruitShop.add(fruitRecordDto);
        Storage.setOfName.add(fruitRecordDto.getNameGoods());
    }

    @Override
    public List<FruitRecordDto> getByNameGoods(String nameGoods) {
        return Storage.storageFruitShop
                .stream()
                .filter(f -> f.getNameGoods().equals(nameGoods))
                .collect(Collectors.toList());
    }
}
