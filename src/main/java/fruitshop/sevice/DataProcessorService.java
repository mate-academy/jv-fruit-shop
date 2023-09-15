package fruitshop.sevice;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface DataProcessorService {
    List<FruitTransaction> processInputData(List<String> dataFromFile);
}
