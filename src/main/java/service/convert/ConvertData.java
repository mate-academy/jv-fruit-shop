package service.convert;

import java.util.List;
import model.FruitTransaction;

public interface ConvertData {
    List<FruitTransaction> convert(List<String> data);
}
