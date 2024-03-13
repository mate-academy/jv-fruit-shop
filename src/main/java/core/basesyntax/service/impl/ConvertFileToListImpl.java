package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertFileToList;
import core.basesyntax.service.ConvertLineToObject;
import java.util.ArrayList;
import java.util.List;

public class ConvertFileToListImpl implements ConvertFileToList {
    public static final String INCORRECT_LINE_BEGINNING = "type";
    public static final ConvertLineToObject CONVERT_LINE_TO_OBJECT = new ConvertLineToObjectImpl();
    public static final List<FruitTransaction> FRUIT_TRANSACTIONS = new ArrayList<>();

    @Override
    public List<FruitTransaction> convert(List<String> list) {
        if (list == null) {
            throw new RuntimeException("File is empty");
        }
        for (String line : list) {
            if (line.contains(INCORRECT_LINE_BEGINNING)) {
                continue;
            }
            FruitTransaction data = CONVERT_LINE_TO_OBJECT.getData(line);
            FRUIT_TRANSACTIONS.add(data);
        }
        return FRUIT_TRANSACTIONS;
    }
}
