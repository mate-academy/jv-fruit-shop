package fruitshop.processingdata;

import fruitshop.database.TransactionService;
import fruitshop.dataservice.DataServiceImp;
import fruitshop.dataservice.SupplierReport;
import fruitshop.dataservice.WorkWithFile;
import fruitshop.dataservice.WorkWithReport;
import fruitshop.model.FruitTransaction;
import fruitshop.model.Operation;
import fruitshop.model.SaveData;
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
    private static final Map<Operation, TypeOfActivity> operationHandlerMap = new HashMap<>();
    private static final WorkWithFile withFile = new DataServiceImp();
    private static final SaveData saveData = new TransactionService();
    private static final WorkWithReport withReport = new SupplierReport();

    public static void main(String[] args) {
        putOperationInMap();
        List<String> fromFileList = withFile.getDataFromFile(readFromFileName);
        List<FruitTransaction> fruitTransactionList = saveData.transactionData(fromFileList);
        for (FruitTransaction fruitTransact : fruitTransactionList) {
            Operation activity = fruitTransact.getOperation();
            TypeOfActivity typeActivity = operationHandlerMap.get(activity);
            typeActivity.realizeType(fruitTransact);
        }
        withFile.writeDataToFile(writeToFileName,withReport.createReport());
    }

    public static void putOperationInMap() {
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseActivity());
        operationHandlerMap.put(Operation.BALANCE, new BalanceActivity());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyActivity());
        operationHandlerMap.put(Operation.RETURN, new SupplyActivity());
    }
}
