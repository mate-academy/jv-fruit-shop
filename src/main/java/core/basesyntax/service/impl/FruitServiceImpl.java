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
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final int INDEX_FRUIT_AMOUNT = 2;
    private static final int INDEX_FRUIT_TYPE = 1;
    private static final int INDEX_OPERATION_TYPE = 0;
    private static final String TITLE = "fruit,quantity";

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
            Fruit fruit = new Fruit(fruitDataSplitted[INDEX_FRUIT_TYPE]);
            operationValidation
                    .isOperationValid(fruitDataSplitted, fromFileName);
            fruitDao.add(fruit,operationStrategy.get(Operation
                    .valueOf(fruitDataSplitted[INDEX_OPERATION_TYPE]))
                    .getShopOperation(Integer.parseInt(fruitDataSplitted[INDEX_FRUIT_AMOUNT])));
        }
        String report = TITLE + System.lineSeparator() + fruitDao.getStorage().entrySet().stream()
                .map(e -> "" + e.getKey().getName() + "," + e.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
        serviceWriter.writeFile(toFileName, report);
        return report;
    }
}
