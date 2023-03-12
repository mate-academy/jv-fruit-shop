package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessService;

import java.util.List;
import java.util.stream.Collectors;

public class ProcessServiceImpl implements ProcessService {
    @Override
    public List<FruitTransaction> process(List<String> list) {
        return list.stream()
                .map(s -> transformation(s))
                .collect(Collectors.toList());

    }

    private FruitTransaction transformation(String string) {
        String[] stringSplit = string.split(",");
        return new FruitTransaction(FruitTransaction.Operation.getOperationByCode(stringSplit[0]),
                stringSplit[1], Integer.parseInt(stringSplit[2]));
    }
}
