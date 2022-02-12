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

    public static void main(String[] args) {
        Map<Operation, TypeOfActivity> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseActivity());
        operationHandlerMap.put(Operation.BALANCE, new BalanceActivity());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyActivity());
        operationHandlerMap.put(Operation.RETURN, new SupplyActivity());
        WorkWithFile withFile = new DataServiceImp();
        List<String> fromFileList = withFile.getDataFromFile(readFromFileName);
        SaveData saveData = new TransactionService();
        List<FruitTransaction> fruitTransactionList = saveData.transactionData(fromFileList);
        for (FruitTransaction fruitTransact : fruitTransactionList) {
            Operation activity = fruitTransact.getOperation();
            TypeOfActivity typeActivity = operationHandlerMap.get(activity);
            typeActivity.realizeType(fruitTransact);
        }
        WorkWithReport withReport = new SupplierReport();
        withFile.writeDataToFile(writeToFileName,withReport.createReport());
    }
}
