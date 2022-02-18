package fruitshop.service.impl;

import fruitshop.db.Storage;
import fruitshop.model.Operation;
import fruitshop.service.FruitService;
import fruitshop.service.OperationStrategy;
import fruitshop.service.ReaderService;
import fruitshop.service.WriterService;
import fruitshop.strategy.BalanceOperationHandler;
import fruitshop.strategy.PurchaseOperationHandler;
import fruitshop.strategy.ReturnOperationHandler;
import fruitshop.strategy.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    public static final String COMMA_SEPARATOR = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final String FRUIT_WORD = "fruit";
    public static final String QUANTITY_WORD = "quantity";
    private final ReaderService readerService;
    private final WriterService writerService;
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(ReaderService readerService, WriterService writerService,
                            OperationStrategy operationStrategy) {
        this.readerService = readerService;
        this.writerService = writerService;
        this.operationStrategy = operationStrategy;
    }

    private void putStrategies() {
        OperationStrategyImpl.operationHandlerMap.put(Operation.BALANCE,
                new BalanceOperationHandler());
        OperationStrategyImpl.operationHandlerMap.put(Operation.SUPPLY,
                new SupplyOperationHandler());
        OperationStrategyImpl.operationHandlerMap.put(Operation.PURCHASE,
                new PurchaseOperationHandler());
        OperationStrategyImpl.operationHandlerMap.put(Operation.RETURN,
                new ReturnOperationHandler());
    }

    private void parseDataFromList(List<String> fruits) {
        String[] arrayOfFruits = new String[fruits.size() - 1];
        for (int i = 0; i < fruits.size() - 1; i++) {
            arrayOfFruits[i] = fruits.get(i + 1);
        }
        for (int i = 0; i < arrayOfFruits.length; i++) {
            String[] fruit = arrayOfFruits[i].split(COMMA_SEPARATOR);
            operationStrategy.chooseStrategy(Operation.parse(fruit[OPERATION_INDEX]),
                    fruit[FRUIT_INDEX], Integer.parseInt(fruit[QUANTITY_INDEX]));
        }
    }

    private byte[] generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FRUIT_WORD).append(COMMA_SEPARATOR).append(QUANTITY_WORD);
        for (Map.Entry<String, Integer> mapEntry : Storage.fruitList.entrySet()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(mapEntry.getKey()).append(COMMA_SEPARATOR)
                    .append(mapEntry.getValue());
        }
        return stringBuilder.toString().getBytes();
    }

    @Override
    public void makeReportAtTheEndOfTheDay(String fileInput, String fileOutput) {
        List<String> inputData = readerService.readFromFile(fileInput);
        putStrategies();
        parseDataFromList(inputData);
        byte[] outputData = generateReport();
        writerService.writeToFile(outputData, fileOutput);
    }
}
