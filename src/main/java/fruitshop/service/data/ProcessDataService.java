package fruitshop.service.data;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface ProcessDataService {
    void process(List<FruitTransaction> list);
}
