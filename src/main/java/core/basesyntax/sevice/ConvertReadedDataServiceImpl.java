package core.basesyntax.sevice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertReadedDataServiceImpl implements ConvertReadedDataService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertDataFromFile(List<String> list) {
        list.remove(0);
        return list.stream()
                .map(s -> s.split(","))
                .map(s -> new FruitTransaction(s[OPERATION_INDEX], s[FRUIT_NAME_INDEX],
                        Integer.parseInt(s[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
