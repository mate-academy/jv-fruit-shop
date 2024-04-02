package core.basesyntax;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.handler.OperationHandler;
import service.handler.BalanceHandler;
import service.handler.PurchaseHandler;
import service.handler.ReturnHandler;
import service.handler.SupplyHandler;
import service.impl.DataReaderServiceImpl;
import service.impl.DataWriterServiceImpl;
import service.impl.ProcessorServiceImpl;

public class ProductsShop {
    private static final String PATH_TO_READ_FILE =
            "src/main/java/resources/input.txt";
    private static final String PATH_TO_FILE_WRITE =
            "src/main/java/resources/output.txt";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                FruitTransaction.Operation.RETURN, new ReturnHandler()
        );

        DataReaderServiceImpl dataReaderService = new DataReaderServiceImpl();
        List<FruitTransaction> fruitTransactionList =
                dataReaderService.readDataInFile(PATH_TO_READ_FILE);

        ProcessorServiceImpl processorService = new ProcessorServiceImpl();
        processorService.processOnData(fruitTransactionList, handlerMap);

        DataWriterServiceImpl dataWriterService = new DataWriterServiceImpl();
        dataWriterService.writeProcessedDataToFile(PATH_TO_FILE_WRITE);
    }
}
