package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.TypeOfTransaction;
import java.util.List;

public class ConverterImpl implements ConverterService {

    @Override
    public List<FruitTransaction> convertStringToTransaction(List<String> lines) {

        return lines.stream()
                .filter(l -> !l.startsWith("type"))
                .map(this::stringToTransaction)
                .toList();
    }

    private FruitTransaction stringToTransaction(String line) {
        String lineWithoutWhiteSpace = line.replaceAll("\\s", "");
        String[] splitLine = lineWithoutWhiteSpace.split(",");
        FruitTransaction transaction = new FruitTransaction();
        if ((splitLine.length != 3)) {
            throw new RuntimeException("Data is invalid.");
        }
        try {
            transaction.setTypeOfTransaction(TypeOfTransaction.valueOf(splitLine[0].toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("The type of transaction is incorrect", e);
        }
        transaction.setFruit(splitLine[1]);
        transaction.setQuantity(Integer.parseInt(splitLine[2]));

        return transaction;
    }
}
