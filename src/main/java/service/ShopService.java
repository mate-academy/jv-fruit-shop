package service;

import java.util.List;
import model.FruitTransaction;

public interface ShopService {
    List<FruitTransaction> parse(List<String[]> list);

    List<String[]> doReport();
}
