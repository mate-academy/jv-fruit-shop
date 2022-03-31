package service.convert;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class ConvertDataImpl implements ConvertData {
    private static final int LETTER_ACTIVITIES_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_FRUIT_INDEX = 2;
    private static final String COMMA = ",";
    private List<FruitTransaction> fruitTransactions = new ArrayList<>();

    @Override
    public List<FruitTransaction> convert(List<String> data) {
        for (String stringData : data) {
            String[] temporaryArr = stringData.split(COMMA);
            fruitTransactions.add(new FruitTransaction(temporaryArr[LETTER_ACTIVITIES_INDEX],
                    temporaryArr[FRUIT_NAME_INDEX],
                    Integer.parseInt(temporaryArr[QUANTITY_FRUIT_INDEX])));
        }
        return fruitTransactions;
    }
}
