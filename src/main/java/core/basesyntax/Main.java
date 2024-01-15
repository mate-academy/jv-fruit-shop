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
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        String fileToString = fileReader.readFromFile(INPUT_PATH);

        DataConvertor dataConvertor = new DataConvertorImpl();
        List<FruitTransaction> convertedData = dataConvertor.convertData(fileToString);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        DataProcessor dataProcessor = new DataProcessorImpl(operationStrategy);
        String result = dataProcessor.calculateData(convertedData);

        RapportCreator rapportCreator = new RapportCreator();
        rapportCreator.createRapport(OUTPUT_PATH, result);
    }
}
