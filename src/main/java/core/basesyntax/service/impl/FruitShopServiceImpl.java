package core.basesyntax.service.impl;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitsHolderService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.strategy.OperationStrategy;

import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    public static final int OPERATION_TYPE_ROW = 0;
    public static final int FRUIT_NAME_ROW = 1;
    public static final int QUANTITY_ROW = 2;
    private final ParserService parserService;
    private final FruitsHolderService fruitsHolderService;
    private final OperationStrategy operationStrategy;
    private final ReportMakerService reportMakerService;

    public FruitShopServiceImpl(ParserService parserService,
                                FruitsHolderService fruitsHolderService,
                                OperationStrategy operationStrategy,
                                ReportMakerService reportMakerService) {
        this.parserService = parserService;
        this.fruitsHolderService = fruitsHolderService;
        this.operationStrategy = operationStrategy;
        this.reportMakerService = reportMakerService;
    }

    @Override
    public void report(String inputFilePath, String outputFilePath) {
        if (inputFilePath == null || outputFilePath == null) {
            throw new FruitShopException("None of the arguments must be null");
        }
        List<List<String>> parsed = parserService.parseDataFromCsv(inputFilePath);
        parsed.forEach(row -> {
            String operationType = row.get(OPERATION_TYPE_ROW);
            String fruitName = row.get(FRUIT_NAME_ROW);
            int quantity = Integer.parseInt(row.get(QUANTITY_ROW));
            int amount = fruitsHolderService.getFruitAmount(fruitName);
            fruitsHolderService.putFruit(fruitName,
                    operationStrategy.get(operationType).operation(amount, quantity));
        });
        reportMakerService.generateReport(fruitsHolderService.getAllFruits(), outputFilePath);
    }
}
