package core.basesyntax;

import model.FruitTransaction;
import servece.impl.DataReaderServiceImpl;
import servece.impl.DataWriterServiceImpl;
import servece.impl.ProcessorServiceImpl;
import service.Handler.service.OperationHandler;
import service.Handler.service.BalanceHandler;
import service.Handler.service.PurchaseHandler;
import service.Handler.service.ReturnHandler;
import service.Handler.service.SupplyHandler;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    private static final String PATH_TO_READ_FILE = "src/main/java/resorces/store.txt";
    private static final String PATH_TO_FILE_WRITE = "src/main/java/resorces/productsAfterDay.txt";
    // HINT: In the `public static void main(String[] args)` it is better to create instances of your classes, 
    // and call their methods, but do not write any business logic in the `main` method!

    public static void main(String[] args) {

        DataReaderServiceImpl dataReaderService = new DataReaderServiceImpl();
        DataWriterServiceImpl dataWriterService = new DataWriterServiceImpl();
        ProcessorServiceImpl processorService = new ProcessorServiceImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        List<FruitTransaction> fruitTransactionList =
                dataReaderService.readDataInFile(PATH_TO_READ_FILE);
        Map<String, Integer> processedData =
                processorService.processOnData(fruitTransactionList, handlerMap);
        dataWriterService.writeProcessedDataToFile(PATH_TO_FILE_WRITE, processedData);
    }
}

