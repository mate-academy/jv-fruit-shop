package converted;

import transaction.FruitTransaction;

import java.util.ArrayList;
import java.util.List;

public class ConverterImpl implements Converter{
    @Override
    public List<FruitTransaction> converterToTransaction(List<String> listIn) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String lines : listIn.subList(1, listIn.size())) {
            String[] parts = lines.split(",");
            transactions.add(new FruitTransaction(
                    FruitTransaction.Operation.checkCode(parts[0]),
                    Integer.parseInt(parts[2]),
                    parts[1]));
        }
        return transactions;
    }
}
