package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationName;
import core.basesyntax.service.ParserService;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int AMOUNT = 2;
    private static final int CODE = 0;
    private static final int FRUIT = 1;

    @Override
    public List<FruitTransaction> parseOperations(List<String> lines) {
        return lines.stream()
                .map(line -> {
                    String[] operationData = line.split(SEPARATOR);
                    if (Integer.parseInt(operationData[AMOUNT]) < 0) {
                        throw new IllegalArgumentException("You can't add negative "
                                + "amount of products!");
                    }
                    return new FruitTransaction(
                            OperationName.getByCode(operationData[CODE]),
                            operationData[FRUIT],
                            Integer.parseInt(operationData[AMOUNT])
                    );
                })
                .toList();
    }
}
