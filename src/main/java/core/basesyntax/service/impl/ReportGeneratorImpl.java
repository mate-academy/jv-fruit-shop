package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHendler;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private FruitDao fruitDao;
    private Map<FruitTransaction.Operation, OperationHendler> operationHendlerMap;

    public ReportGeneratorImpl(FruitDao fruitDao,
                               Map<FruitTransaction.Operation,
                                      OperationHendler> operationHendlerMap) {
        this.fruitDao = fruitDao;
        this.operationHendlerMap = operationHendlerMap;
    }

    @Override
    public String reportGenerater() {
        return fruitDao.getAll()
                .entrySet()
                .stream()
                .map(m -> new StringBuilder()
                        .append(m.getKey())
                        .append(SEPARATOR)
                        .append(m.getValue()))
                                .collect(Collectors.joining(System.lineSeparator()));
    }
}
