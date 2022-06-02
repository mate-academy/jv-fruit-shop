import csv.FileServiceImpl;
import dao.ProductAccountDaoImpl;
import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.AmountHandler;
import service.AmountHandlerBalance;
import service.AmountHandlerPurchase;
import service.AmountHandlerReturn;
import service.AmountHandlerSupply;
import service.Operation;
import service.OperationHandlerStrategyImpl;
import service.ShopReportServiceImpl;
import service.ShopServiceImpl;

public class FruitShop {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("you should to use : FruitShop.jar [input.csv] [output.csv]");
            return;
        }

        //initialize map for OperationHandlerStrategy
        Map<Operation, AmountHandler> amountHandlerMap = new HashMap<Operation, AmountHandler>();
        amountHandlerMap.put(Operation.BALANCE,new AmountHandlerBalance());
        amountHandlerMap.put(Operation.SUPPLY,new AmountHandlerSupply());
        amountHandlerMap.put(Operation.PURCHASE,new AmountHandlerPurchase());
        amountHandlerMap.put(Operation.RETURN,new AmountHandlerReturn());

        OperationHandlerStrategyImpl amountStrategy =
                new OperationHandlerStrategyImpl(amountHandlerMap);

        //initialize storage
        Storage memdb = new Storage();

        ProductAccountDaoImpl dao = new ProductAccountDaoImpl(memdb);
        ShopServiceImpl fruitShop = new ShopServiceImpl(dao, amountStrategy);
        ShopReportServiceImpl reportService = new ShopReportServiceImpl(dao);
        FileServiceImpl csvFileService = new FileServiceImpl();

        //Start read input csv record by record
        String inputCsvFilePath = args[0];
        List<String> inputList = csvFileService.readFile(inputCsvFilePath);

        for (String inCsvString: inputList) {
            String[] inArray = inCsvString.split(",");
            fruitShop.execProductTransaction(inArray[1],Double.valueOf(inArray[2]),inArray[0]);
        }

        List<String> outStringList = reportService.getShopBalanceReport();
        String outCsvFilePath = args[1];
        csvFileService.writeFile(outCsvFilePath,outStringList);

    }
}
