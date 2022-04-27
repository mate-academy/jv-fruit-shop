package core.basesyntax.service.parse;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEADER_INDEX = 0;
    private static final String COMA = ",";

    @Override
    public List<FruitTransaction> parse(List<String> sourceCsvData) {
        sourceCsvData.remove(HEADER_INDEX);
        return sourceCsvData.stream()
                .map(this::createTransactionFromLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransactionFromLine(String line) {
        String[] data = line.split(COMA);
        return new FruitTransaction(data[OPERATION_INDEX],
                data[FRUIT_INDEX],
                Integer.parseInt(data[QUANTITY_INDEX]));
    }
}
