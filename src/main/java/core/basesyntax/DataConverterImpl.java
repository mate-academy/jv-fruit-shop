package core.basesyntax;

import java.util.List;
import java.util.stream.Collectors;

class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        // Пропускаем первую строку с заголовками
        return data.stream()
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(",");
                    String opCode = parts[0];
                    FruitTransaction.Operation op = switch (opCode) {
                        case "b" -> FruitTransaction.Operation.BALANCE;
                        case "s" -> FruitTransaction.Operation.SUPPLY;
                        case "p" -> FruitTransaction.Operation.PURCHASE;
                        case "r" -> FruitTransaction.Operation.RETURN;
                        default -> throw new IllegalArgumentException("Invalid operation code: "
                                + opCode);
                    };
                    String fruit = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    return new FruitTransaction(op, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}


