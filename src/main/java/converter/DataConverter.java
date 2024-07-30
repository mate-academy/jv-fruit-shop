package converter;

import java.util.List;
import model.FruitTransaction;

public interface DataConverter {
    List<FruitTransaction> converterToTransaction(List<String> inputReport);
}
