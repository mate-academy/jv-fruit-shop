package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitShopService {

    List<FruitTransaction> processingData(List<FruitTransaction> parsedInfo);
}
