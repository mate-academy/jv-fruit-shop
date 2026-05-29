package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.converting.DataConverter;
import core.basesyntax.service.converting.DataConverterImpl;
import core.basesyntax.service.converting.ReportGenerator;
import core.basesyntax.service.converting.ReportGeneratorImpl;
import core.basesyntax.service.operation.OperationType;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;
    private String inputDataFileName;
    private String reportFileName;
    private DataConverter converter;
    private ReportGenerator reportGenerator;

    public ShopServiceImpl(Map<FruitTransaction.Operation, OperationType> map,
                           String inputDataFileName) {
        this.strategy = new OperationStrategyImpl(map);
        this.inputDataFileName = inputDataFileName;
        this.converter = new DataConverterImpl();
        this.reportGenerator = new ReportGeneratorImpl();
        this.reportFileName = "src/main/resources/report.csv";
    }

    @Override
    public void reportMaker() {
        List<String> linesOfData = converter.getInfoFromFile(inputDataFileName);

        String purchaseCode = FruitTransaction.Operation.PURCHASE.getCode();
        String supplyCode = FruitTransaction.Operation.SUPPLY.getCode();
        String balanceCode = FruitTransaction.Operation.BALANCE.getCode();
        String returnCode = FruitTransaction.Operation.RETURN.getCode();

        for (int i = 1; i < linesOfData.size(); i++) {
            String[] splitLine = linesOfData.get(i).split(",");

            if (splitLine[0].equals(balanceCode)) {
                OperationType operationType =
                        strategy.operationHandler(FruitTransaction.Operation.BALANCE);
                operationType.handle(linesOfData.get(i));
            }
            if (splitLine[0].equals(supplyCode)) {
                OperationType operationType =
                        strategy.operationHandler(FruitTransaction.Operation.SUPPLY);
                operationType.handle(linesOfData.get(i));
            }
            if (splitLine[0].equals(purchaseCode)) {
                OperationType operationType =
                        strategy.operationHandler(FruitTransaction.Operation.PURCHASE);
                operationType.handle(linesOfData.get(i));
            }
            if (splitLine[0].equals(returnCode)) {
                OperationType operationType =
                        strategy.operationHandler(FruitTransaction.Operation.RETURN);
                operationType.handle(linesOfData.get(i));
            }
        }

        reportGenerator.getReport(reportFileName);
    }
}
