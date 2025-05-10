package core.basesyntax.dao;

import core.basesyntax.models.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    private static final int INDEX_TYPE = 0;
    private static final int INDEX_NAME = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final int HEADER_LINE_INDEX = 1;
    private static final String SPLITTER = ",";

    public List<FruitTransaction> convertToTransaction(List<String> productsInString) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = HEADER_LINE_INDEX; i < productsInString.size(); i++) {

            String[] splitString = productsInString.get(i).split(SPLITTER);

            FruitTransaction.TypeOfActivity typeOfActivity =
                    FruitTransaction.TypeOfActivity.fromCode(splitString[INDEX_TYPE]);

            fruitTransactions.add(FruitTransaction.of(
                    typeOfActivity,
                    splitString[INDEX_NAME],
                    Integer.parseInt(splitString[INDEX_QUANTITY]))
            );
        }
        return fruitTransactions;
    }
}
