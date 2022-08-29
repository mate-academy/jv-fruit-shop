package core.basesyntax.model.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.service.DataParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .map(s -> s.split(SPLITTER))
                .map(DataParserImpl::parsingOperation)
                .collect(Collectors.toList());
    }

    private static FruitTransaction parsingOperation(String[] lines) {
        return new FruitTransaction(
                Arrays.stream(FruitTransaction.Operation.values())
                        .filter(operation -> operation.getOperation()
                                .equals(lines[OPERATION_INDEX]))
                        .findFirst().get(),lines[FRUIT_INDEX],
                                Integer.parseInt(lines[QUANTITY_INDEX]));
    }

}
