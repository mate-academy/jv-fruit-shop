package servicecsv;

import java.util.List;
import model.FruitTransaction;

public interface DataOperating {
    List<FruitTransaction> passFruitData(List<String> dataFromFile);
}
