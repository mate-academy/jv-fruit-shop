package core.basesyntax.handlers.impl;

import core.basesyntax.handlers.DataConverter;
import core.basesyntax.handlers.FruitPars;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataConverterImpl implements DataConverter {
    private static final String SPLIT = ",";
    private static final int FRUIT_OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_QUANTITY = 2;
    private static FruitPars fruitPars;
    private static Map<FruitTransaction.Operation, OperationHandler> handler;

    public DataConverterImpl() {
        fruitPars = new FruitParsImpl();
    }

    @Override
    public List<FruitTransaction> convert(List<String> inputReport) {
        List<String> inputReportConvert = new ArrayList<>(inputReport);
        if (!inputReportConvert.isEmpty()) {
            inputReportConvert.remove(0);
        }
        return inputReportConvert.stream()
                .map(string -> string.split(SPLIT))
                .map(report -> new FruitTransaction(report[FRUIT_NAME],
                        Integer.parseInt(report[FRUIT_QUANTITY]),
                        fruitPars.parse(report[FRUIT_OPERATION])))
                .toList();
    }
}
