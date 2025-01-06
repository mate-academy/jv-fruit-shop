package converted;

import java.util.List;
import transaction.FruitTransaction;

public interface Converter {
    List<FruitTransaction> converterToTransaction(List<String> listIn);
}
