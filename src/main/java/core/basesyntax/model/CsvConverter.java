package core.basesyntax.model;

import com.opencsv.bean.AbstractBeanField;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CsvConverter extends AbstractBeanField {
    private static final Operation[] operations = Operation.values();

    @Override
    protected Operation convert(String symbol) {
        Optional<Operation> operation = Arrays.stream(operations)
                .filter(o -> o.getOperation().equals(symbol))
                .findFirst();
        return operation.orElseThrow(() ->
                new NoSuchElementException("Cant find the operation by symbol: " + symbol));
    }
}
