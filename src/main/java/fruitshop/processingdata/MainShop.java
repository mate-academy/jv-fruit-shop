package fruitshop.processingdata;

import fruitshop.database.TransactionServiceImpl;
import fruitshop.dataservice.FileReaderService;
import fruitshop.dataservice.FileReaderServiceImpl;
import fruitshop.dataservice.FileWriterService;
import fruitshop.dataservice.FileWriterServiceImpl;
import fruitshop.dataservice.ReportCreator;
import fruitshop.dataservice.ReportCreatorImpl;
import fruitshop.model.FruitTransaction;
import fruitshop.model.TransactionService;
import fruitshop.strategy.BalanceActivity;
import fruitshop.strategy.PurchaseActivity;
import fruitshop.strategy.SupplyActivity;
import fruitshop.strategy.TypeOfActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainShop {
    private static final String readFromFileName = "src/main/resources/dayFile.csv";
    private static final String writeToFileName = "src/main/resources/fileToreport.csv";
    private static final Map<String, TypeOfActivity> operationHandlerMap = new HashMap<>();
    private static final FileReaderService readFromFile = new FileReaderServiceImpl();
    private static final FileWriterService writeToFile = new FileWriterServiceImpl();
    private static final TransactionService transactionService = new TransactionServiceImpl();
    private static final ReportCreator withReport = new ReportCreatorImpl();

    public static void main(String[] args) {
        putOperationInMap();
        List<String> fromFileList = readFromFile.getDataFromFile(readFromFileName);
        List<FruitTransaction> fruitTransactionList
                = transactionService.transactionData(fromFileList);
        for (FruitTransaction fruitTransact : fruitTransactionList) {
            String activity = fruitTransact.getOperation();
            TypeOfActivity typeActivity = operationHandlerMap.get(activity);
            typeActivity.realizeType(fruitTransact);
        }
        writeToFile.writeDataToFile(writeToFileName,withReport.createReport());
    }

    public static void putOperationInMap() {
        operationHandlerMap.put("p", new PurchaseActivity());
        operationHandlerMap.put("b", new BalanceActivity());
        operationHandlerMap.put("s", new SupplyActivity());
        operationHandlerMap.put("r", new SupplyActivity());
    }
}
