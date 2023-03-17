package core.basesyntax;

import core.basesyntax.model.FruitTransfer;
import core.basesyntax.operationhandler.BalanceOperationHandler;
import core.basesyntax.operationhandler.OperationHandler;
import core.basesyntax.operationhandler.PurchaseOperationHandler;
import core.basesyntax.operationhandler.ReturnOperationHandler;
import core.basesyntax.operationhandler.SupplyOperationHandler;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.servise.ParseService;
import core.basesyntax.servise.ReaderService;
import core.basesyntax.servise.WriteService;
import core.basesyntax.strategy.FruitOperationStrategy;
import core.basesyntax.strategy.FruitOperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FROM_FILE = "src/main/resources/InputFile.csv";
    public static final String TO_FILE = "src/main/resources/ReportFile.csv";

    public static void main(String[] args) {
        Map<FruitTransfer.Operation, OperationHandler> operationStrategyMap = Map.of(
                FruitTransfer.Operation.BALANCE,new BalanceOperationHandler(),
                FruitTransfer.Operation.PURCHASE,new PurchaseOperationHandler(),
                FruitTransfer.Operation.RETURN, new ReturnOperationHandler(),
                FruitTransfer.Operation.SUPPLY, new SupplyOperationHandler()
        );

        ReaderService readerService = new ReaderServiceImpl();
        List<String> inputInform = readerService.readFromFile(FROM_FILE);

        ParseService parseService = new ParseServiceImpl();
        List<FruitTransfer> fruitTransfersList = parseService.parseFruitTransfers(inputInform);
        FruitOperationStrategy fruitOperationStrategy =
                new FruitOperationStrategyImpl(operationStrategyMap);
        for (FruitTransfer transfer: fruitTransfersList) {
            OperationHandler operationHandler = fruitOperationStrategy.get(transfer.getOperation());
            operationHandler.apply(transfer);
        }
        String report = new ReportServiceImpl().generateReport();
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(report,TO_FILE);
    }
}
