package serviceCSV;

import model.FruitTransaction;

import java.util.List;

public interface DataOperating {
    List<FruitTransaction> passFruitData(List<String> dataFromFile);
}
