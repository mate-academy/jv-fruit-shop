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
        if (splitLine.length == 3) {
            if ((splitLine[0].startsWith("b")) || (splitLine[0].startsWith("s"))
                    || (splitLine[0].startsWith("r")) || (splitLine[0]).startsWith("p")) {
                transaction.setTypeOfTransaction(TypeOfTransaction.valueOf(splitLine[0]));
                transaction.setFruit(splitLine[1]);
                transaction.setQuantity(Integer.parseInt(splitLine[2]));
            } else {
                throw new RuntimeException("Data is invalid");
            }
        } return transaction;
    }
}
