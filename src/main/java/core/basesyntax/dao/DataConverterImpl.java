package core.basesyntax.dao;

import core.basesyntax.models.FruitTransaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String HEADER = "type,product,quantity";
    private static final String SPLITTER = ",";

    public List<FruitTransaction> convertToTransaction(List<String> productsInString) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String productStr : productsInString) {
            if (productStr.equals(HEADER)) {
                continue;
            }
            String[] splitString = productStr.split(SPLITTER);

            FruitTransaction.TypeOfActivity typeOfActivity = Arrays.stream(
                        FruitTransaction.TypeOfActivity.values())
                    .filter(type -> type.getCode().equals(splitString[0]))
                    .findFirst()
                    .orElseThrow(() ->
                            new IllegalArgumentException("Unknown type of activity: "
                                    + splitString[0]));

            fruitTransactions.add(FruitTransaction.of(
                    typeOfActivity,
                    splitString[1],
                    Integer.parseInt(splitString[2]))
            );

        }
        return fruitTransactions;
    }
}
