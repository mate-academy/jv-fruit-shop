package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import servece.impl.DataReaderServiceImpl;
import servece.impl.DataWriterServiceImpl;
import servece.impl.ProcessorServiceImpl;
import service.handler.BalanceHandler;
import service.handler.OperationHandler;
import service.handler.PurchaseHandler;
import service.handler.ReturnHandler;
import service.handler.SupplyHandler;


public class ProductsShop {
    private static final String PATH_TO_READ_FILE = "src/main/java/resorces/store.txt";
    private static final String PATH_TO_FILE_WRITE = "src/main/java/resorces/productsAfterDay.txt";

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

