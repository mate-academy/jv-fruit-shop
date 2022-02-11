package fruitshop.processingdata;

import fruitshop.database.TransactionService;
import fruitshop.dataservice.DataServiceImp;
import fruitshop.dataservice.WorkWithFile;
import fruitshop.model.FruitTransaction;
import fruitshop.model.SaveData;
import fruitshop.strategy.BalanceActivity;
import fruitshop.strategy.PurchaseActivity;
import fruitshop.strategy.SupplyActivity;
import fruitshop.strategy.TypeOfActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainShop {
    private static final String readFromFileName = "src/main/resources/dayFile";
    private static final String writeToFileName = "src/main/resources/fileToreport";
    private static final String PURCHASE_ACTIVITY = "p";
    private static final String BALANCE_ACTIVITY = "b";
    private static final String SUPPLY_ACTIVITY = "s";
    private static final String RETURN_ACTIVITY = "r";

    public static void main(String[] args) {
        Map<String, TypeOfActivity> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(PURCHASE_ACTIVITY, new PurchaseActivity());
        operationHandlerMap.put(BALANCE_ACTIVITY, new BalanceActivity());
        operationHandlerMap.put(SUPPLY_ACTIVITY, new SupplyActivity());
        operationHandlerMap.put(RETURN_ACTIVITY, new SupplyActivity());
        WorkWithFile withFile = new DataServiceImp();
        List<String> fromFileList = withFile.getDataFromFile(readFromFileName);
        SaveData saveData = new TransactionService();
        List<FruitTransaction> fruitTransactionList = saveData.transactionData(fromFileList);
        for (FruitTransaction fruitTransact : fruitTransactionList) {
            String activity = fruitTransact.getOperation();
            TypeOfActivity typeActivity = operationHandlerMap.get(activity);
            typeActivity.realizeType(fruitTransact);
        }
        withFile.writeDataToFile(writeToFileName);
    }
}
