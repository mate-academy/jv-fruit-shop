package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ServiceReader;
import core.basesyntax.service.ServiceWriter;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.validation.OperationValidation;
import core.basesyntax.validation.OperationValidationImpl;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final int INDEX_FRUIT_AMOUNT = 2;
    private static final int INDEX_FRUIT_TYPE = 1;
    private static final int INDEX_OPERATION_TYPE = 0;

    private ServiceReader serviceReader = new ServiceReaderImpl();
    private ServiceWriter serviceWriter = new ServiceWriterImpl();
    private FruitDao fruitDao = new FruitDaoImpl();
    private OperationValidation operationValidation = new OperationValidationImpl();

    @Override
    public String getReportService(String fromFileName,
                                   String toFileName,
                                   OperationStrategy operationStrategy) {
        List<String> fruitData = serviceReader.readFile(fromFileName);
        for (String fruitDataRow : fruitData) {
            String[] fruitDataSplitted = fruitDataRow.split(",");
            operationValidation
                    .isOperationValid(fruitDataSplitted, fromFileName);
            fruitDao.add(Fruit.Type.valueOf(fruitDataSplitted[INDEX_FRUIT_TYPE]),
                    operationStrategy
                            .get(Operation.OperationKind
                                    .valueOf(fruitDataSplitted[INDEX_OPERATION_TYPE]))
                            .getShopOperation(
                                    new BigDecimal(fruitDataSplitted[INDEX_FRUIT_AMOUNT])));
        }
        String report = fruitDao.getStorage().entrySet().stream()
                .map(e -> "" + e.getKey() + "," + e.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
        serviceWriter.writeFile(toFileName, report);
        return report;
    }
}
