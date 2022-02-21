package core.basesyntax.sevice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertReadedDataServiceImpl implements ConvertReadedDataService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_SIMBOL = ",";
    private static final int REMOVE_INDEX = 0;

    @Override
    public List<FruitTransaction> convertDataFromFile(List<String> list) {
        list.remove(REMOVE_INDEX);
        return list.stream()
                .map(s -> s.split(SPLIT_SIMBOL))
                .map(s -> new FruitTransaction(s[OPERATION_INDEX], s[FRUIT_NAME_INDEX],
                        Integer.parseInt(s[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
