package fruitshop.sevice;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface TextProcessorService {
    List<FruitTransaction> format(List<String> dataFromFile);
}
