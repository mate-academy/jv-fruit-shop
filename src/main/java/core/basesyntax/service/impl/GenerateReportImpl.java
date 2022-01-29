package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.GenerateReport;
import core.basesyntax.service.OperationHendler;
import java.util.Map;
import java.util.stream.Collectors;

public class GenerateReportImpl implements GenerateReport {
    private static final String SEPARATOR = ",";
    private FruitDao fruitDao;
    private Map<FruitTransaction.Operation, OperationHendler> operationHendlerMap;

    public GenerateReportImpl(FruitDao fruitDao,
                              Map<FruitTransaction.Operation,
                                      OperationHendler> operationHendlerMap) {
        this.fruitDao = fruitDao;
        this.operationHendlerMap = operationHendlerMap;
    }

    @Override
    public String reportGenerater() {
        return fruitDao.getAll().stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                                                    Collectors.summingInt(this::summFruits)))
                .entrySet()
                .stream().map(m -> new StringBuilder()
                        .append(m.getKey())
                        .append(SEPARATOR)
                        .append(m.getValue())).collect(Collectors.joining(System.lineSeparator()));
    }

    private int summFruits(FruitTransaction fruitTransaction) {
        return operationHendlerMap.get(fruitTransaction.getOperation())
                                        .getOperation(fruitTransaction);
    }
}
