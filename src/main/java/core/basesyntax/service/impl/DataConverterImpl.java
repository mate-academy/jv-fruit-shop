package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("Input list can't be null");
        }
        return lines.stream()
                .map(this::convertToFruitTransaction)
                .toList();
    }

    private FruitTransaction convertToFruitTransaction(String line) {
        String[] fields = line.split(",");
        if (fields.length != 3) {
            throw new IllegalArgumentException("Invalid line format: " + line);
        }

        try {
            return new FruitTransaction(
                    Operation.fromCode(fields[0]),
                    fields[1],
                    Integer.parseInt(fields[2])
            );
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity format in line: " + line, e);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid operation code in line: " + line, e);
        }
    }

}
