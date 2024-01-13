package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.BalanceHandler;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.PurchaseHandler;
import core.basesyntax.operations.ReturnHandler;
import core.basesyntax.operations.SupplyHandler;
import core.basesyntax.service.RapportCreator;
import core.basesyntax.service.convertator.DataConvertor;
import core.basesyntax.service.convertator.DataConvertorImpl;
import core.basesyntax.service.file.FileReader;
import core.basesyntax.service.file.FileReaderImpl;
import core.basesyntax.service.processor.DataProcessor;
import core.basesyntax.service.processor.DataProcessorImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        String fileToString = fileReader.readFromFile("src/main/resources/fruitsRapport.csv");

        DataConvertor dataConvertor = new DataConvertorImpl();
        List<FruitTransaction> convertedData = dataConvertor.convertData(fileToString);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        DataProcessor dataProcessor = new DataProcessorImpl(operationStrategy);
        String result = dataProcessor.calculateData(convertedData);

        RapportCreator rapportCreator = new RapportCreator();
        rapportCreator.createRapport("src/main/resources/rapport.csv", result);

    }

}
