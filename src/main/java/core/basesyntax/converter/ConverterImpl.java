package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.TypeOfTransaction;
import java.util.List;

public class ConverterImpl implements ConverterService {

    @Override
    public List<FruitTransaction> convertStringToTransaction(List<String> lines) {

        return lines.stream()
                .map(this::stringToTransaction)
                .toList();
    }

    private FruitTransaction stringToTransaction(String line) {
        String[] splitLine = line.split(",");
        FruitTransaction transaction = new FruitTransaction();
        transaction.setTypeOfTransaction(TypeOfTransaction.valueOf(splitLine[0]));
        transaction.setFruit(splitLine[1]);
        transaction.setQuantity(Integer.parseInt(splitLine[2]));

        return transaction;
    }
}
