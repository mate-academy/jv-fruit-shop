package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransactionsList(List<String> input) {
        return IntStream.range(1, input.size())
                .mapToObj(i -> convertToTransaction(input.get(i)))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public FruitTransaction convertToTransaction(String input) {

        String[] split = input.split(",");

        FruitTransaction.Operation operation = FruitTransaction.Operation.getByCode(split[0]);

        return new FruitTransaction(operation, split[1], Integer.parseInt(split[2]));
    }
}
