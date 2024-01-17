package core.basesyntax.main;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReporterService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationServiceStrategy;
import core.basesyntax.service.UniqueFruitsAdderService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileReporterServiceImpl;
import core.basesyntax.service.impl.CsvFileUniqueFruitsServiceAdder;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.OperationStrategyServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<FruitTransaction.Operation, OperationHandler> operationProviderMap =
            Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                    FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                    FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                    FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
    private static final OperationServiceStrategy operationStrategy =
            new OperationStrategyServiceImpl(operationProviderMap);
    private static final String PATH_TO_INPUT_FILE =
            "src/main/resources/input.csv";
    private static final String PATH_TO_OUTPUT_FILE =
            "src/main/resources/output.csv";
    private static final String PATH_TO_NON_VALID_STRATEGY_FILE =
            "src/main/resources/nonValidStrategyFile.csv";
    private static final String PATH_TO_NON_VALID_STRUCTURE_FILE =
            "src/main/resources/non-validStructure.csv";
    private static final String PATH_TO_NON_VALID_TRANSACTION_FILE =
            "src/main/resources/non-validStructureInTransactions.csv";
    private static final String PATH_TO_NON_VALID_QUANTITY_FILE =
            "src/main/resources/non-validQuantity.csv";
    private static final Storage storage = new Storage();

    public static void main(String[] args) {
        File fileToRead = new File(PATH_TO_INPUT_FILE);
        File fileToWrite = new File(PATH_TO_OUTPUT_FILE);
        FileReaderService fileReader = new CsvFileReaderServiceImpl();
        List<String> transactions = fileReader.readFile(fileToRead);
        UniqueFruitsAdderService uniqueFruitsAdder = new CsvFileUniqueFruitsServiceAdder(storage);
        uniqueFruitsAdder.add(transactions, storage);
        FileReporterService fileReporter =
                new CsvFileReporterServiceImpl(operationStrategy, storage);
        fileReporter.getReport(transactions);
        FileWriterService fileWriter = new CsvFileWriterServiceImpl();
        fileWriter.write(fileToWrite, storage.getFruitQuantityMap());
    }
}
