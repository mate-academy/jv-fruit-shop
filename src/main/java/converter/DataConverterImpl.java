package converter;

import java.util.List;
import model.FruitTransaction;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> converterToTransaction(List<String> data) {
        return data.stream()
                .skip(1) // Skip header
                .map(line -> {
                    String[] parts = line.split(",");
                    FruitTransaction.Operation operation
                            = FruitTransaction.Operation.fromCode(parts[0]);
                    return new FruitTransaction(operation, parts[1], Integer.parseInt(parts[2]));
                })
                .toList();
    }
}
