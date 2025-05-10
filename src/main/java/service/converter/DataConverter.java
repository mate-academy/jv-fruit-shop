package service.converter;

import java.util.List;
import model.FruitTransaction;

public interface DataConverter {
    List<FruitTransaction> convertToTransactionList(List<String> inputReport);
}
