package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ProcessDataFromFile;
import core.basesyntax.service.ReadDataFromFile;
import core.basesyntax.service.WriteReportToFile;
import core.basesyntax.service.impl.ProcessDataFromFileImpl;
import core.basesyntax.service.impl.ReadDataFromFileImpl;
import core.basesyntax.service.impl.WriteReportToFileImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.strategy.handlers.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Integer OPERATION_INDEX = 0;
    private static final Integer FRUIT_INDEX = 1;
    private static final Integer QUANTITY_INDEX = 2;
    private static final String FILE_PATH_TO_READ =
            "src/main/java/core/basesyntax/resources/input.csv";
    private static final String FILE_PATH_TO_WRITE =
            "src/main/java/core/basesyntax/resources/report.csv";

    public static void main(String[] args) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler()
        ));

        ReadDataFromFile readDataFromFile = new ReadDataFromFileImpl();
        final List<String> readData = readDataFromFile.readData(FILE_PATH_TO_READ);

        ProcessDataFromFile processDataFromFile = new ProcessDataFromFileImpl();
        final List<String[]> processData = processDataFromFile.processData(readData);

        for (String[] item : processData) {
            operationStrategy.get(Operation.getByCode(item[OPERATION_INDEX]))
                    .apply(item[FRUIT_INDEX], Integer.parseInt(item[QUANTITY_INDEX]));
        }

        WriteReportToFile writeReportToFile = new WriteReportToFileImpl();
        writeReportToFile.writeData(Storage.fruits, FILE_PATH_TO_WRITE);
    }
}
