package dao;

import java.util.List;
import model.FruitRecordDto;

public interface OperationDao {
    void add(FruitRecordDto fruitRecordDto);

    List<FruitRecordDto> getByNameGoods(String nameGoods);
}
