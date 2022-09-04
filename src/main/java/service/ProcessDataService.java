package service;

import java.util.List;
import model.FruitTransaction;

public interface ProcessDataService {
    List<FruitTransaction> processData(List<String> dataFromInputFile);
}
