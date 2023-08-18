package core.basesyntax;

import core.basesyntax.impl.DataConverterToObject;
import core.basesyntax.impl.OperationProcess;
import core.basesyntax.impl.ReadFileFromCsv;
import core.basesyntax.impl.ReportCreator;
import core.basesyntax.impl.WriteToCsv;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataProcesser;
import core.basesyntax.service.ReadFileService;
import core.basesyntax.service.WriteDataToFileService;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";
    private static final Map<Operation, OperationHandler> operationDefiner = Map.of(
            Operation.BALANCE, new BalanceOperationHandler(),
            Operation.PURCHASE, new PurchaseOperationHandler(),
            Operation.RETURN, new ReturnOperationHandler(),
            Operation.SUPPLY, new SupplyOperationHandler());

    public static void main(String[] args) {
        ReadFileService readFileService = new ReadFileFromCsv();
        List<String> inputData = readFileService.readFromFile(INPUT_FILE_PATH);
        DataConverter dataConverter = new DataConverterToObject();
        List<FruitTransaction> transactions = dataConverter.convert(inputData);
        DataProcesser operationProcess = new OperationProcess();
        operationProcess.processData(transactions, operationDefiner);
        ReportCreator reportCreator = new ReportCreator();
        WriteDataToFileService writeDataToFileService = new WriteToCsv();
        writeDataToFileService.writeToFile(reportCreator.prepare(), OUTPUT_FILE_PATH);
    }
}
