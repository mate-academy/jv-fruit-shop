package core.basesyntax.service.parse;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {

    @Override
    public List<FruitTransaction> parse(List<String> list) {
        list.remove(0);
        return list.stream()
                .map(this::createTransactionFromLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransactionFromLine(String line) {
        String[] temp = line.split(",");
        return new FruitTransaction(temp[0], temp[1], Integer.parseInt(temp[2]));
    }
}
