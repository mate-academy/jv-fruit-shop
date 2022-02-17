package core.basesyntax.sevice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertReadedDataServiceImpl implements ConvertReadedDataService {

    @Override
    public List<FruitTransaction> convertDataFromFile(List<String> list) {
        list.remove(0);
        return list.stream()
                .map(s -> s.split(","))
                .map(s ->
                        new FruitTransaction(FruitTransaction.Operation.getFullOperationName(s[0]),
                                s[1], Integer.parseInt(s[2])))
                .collect(Collectors.toList());

    }
}
