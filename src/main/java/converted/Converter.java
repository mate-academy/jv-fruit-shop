package converted;

import transaction.FruitTransaction;

import java.util.List;

public interface Converter {
    List<FruitTransaction> converterToTransaction(List<String> listIn);
}
