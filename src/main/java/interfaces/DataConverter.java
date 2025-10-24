package interfaces;

import java.util.List;
import service.impl.FruitTransaction;

public interface DataConverter {
    public List<FruitTransaction> convertToTransaction(List<String> data);
}
