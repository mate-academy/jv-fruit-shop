package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterImpl implements Converter {
    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        if (lines == null) {
            throw new RuntimeException("Input list cannot be null");
        }
        return lines.stream()
                .skip(1)
                .map(line -> {
                    try {
                        String[] data = line.split(",");
                        String code = data[0];
                        String fruit = data[1];
                        int quantity = Integer.parseInt(data[2]);

                        if (quantity < 0) {
                            throw new RuntimeException("Quantity cannot be negative");
                        }

                        FruitTransaction transaction = new FruitTransaction();
                        transaction.setOperation(FruitTransaction.Operation.fromCodeToOp(code));
                        transaction.setFruit(fruit);
                        transaction.setQuantity(quantity);
                        return transaction;
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        throw new RuntimeException("Error while converting data line " + line, e);
                    }
                })
                .collect(Collectors.toList());
    }
}
