package core.basesyntax.services.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> list) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        final String String_Separator = ",";
        try {
            for (String line : list) {
                String[] values = line.split(String_Separator);
                fruitTransactionList.add(new FruitTransaction(
                        values[0],
                        values[1],
                        Integer.parseInt(values[2])
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException("Invalid data", e);
        }
        return fruitTransactionList;
    }

}
