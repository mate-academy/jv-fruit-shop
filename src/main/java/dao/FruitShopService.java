package dao;

import java.util.List;
import model.FruitTransaction;

public interface FruitShopService {
    void addDataToStorage(List<FruitTransaction> dataList);
}
