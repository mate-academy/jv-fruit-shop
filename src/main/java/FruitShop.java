import csv.CsvReadProcessor;
import csv.CsvWriteProcessor;
import dao.ProductAccountDaoImpl;
import db.Storage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import model.ProductAccount;
import service.AmountHandler;
import service.AmountHandlerBalance;
import service.AmountHandlerPurchase;
import service.AmountHandlerReturn;
import service.AmountHandlerSupply;
import service.AmountStrategyImpl;
import service.InFields;
import service.Operation;
import service.ShopReportService;
import service.ShopReportServiceImpl;
import service.ShopServiceImpl;

public class FruitShop {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("you should to use : FruitShop.jar [input.csv] [output.csv]");
            return;
        }

        //initialize map for AmountStrategy
        Map<Operation,AmountHandler> amountHandlerMap = new HashMap<Operation, AmountHandler>();
        amountHandlerMap.put(Operation.BALANCE,new AmountHandlerBalance());
        amountHandlerMap.put(Operation.SUPPLY,new AmountHandlerSupply());
        amountHandlerMap.put(Operation.PURCHASE,new AmountHandlerPurchase());
        amountHandlerMap.put(Operation.RETURN,new AmountHandlerReturn());

        AmountStrategyImpl amountStrategy = new AmountStrategyImpl(amountHandlerMap);

        //initialize storage
        Storage memdb = new Storage();
        String delimiter = ",";
        ProductAccountDaoImpl dao = new ProductAccountDaoImpl(memdb);
        ShopServiceImpl fruitShop = new ShopServiceImpl(dao, amountStrategy);
        ShopReportService reportService = new ShopReportServiceImpl(dao);

        //Start read input csv record by record
        String inputCsvFilePath = args[0];
        CsvReadProcessor csvProcessorRead = new CsvReadProcessor();
        csvProcessorRead.openCsv(inputCsvFilePath,delimiter);

        do {
            String fruitName = csvProcessorRead.getField(InFields.fruit.name());
            Double quantity = Double.parseDouble(csvProcessorRead
                    .getField(InFields.quantity.name()));
            String opType = csvProcessorRead.getField(InFields.type.name());
            ;
            fruitShop.productTransaction(fruitName,
                    quantity,
                    Arrays.stream(Operation.values())
                            .filter(o -> opType.equals(o.getOperation()))
                            .findFirst()
                            .get());
        } while (csvProcessorRead.readNext());

        ArrayList<ProductAccount> balanceReport;
        balanceReport = (ArrayList<ProductAccount>)reportService.getShopBalanceReport();
        //prepare csv object to write
        String outCsvFilePath = args[1];
        CsvWriteProcessor csvProcessorWrite = new CsvWriteProcessor();
        csvProcessorWrite.createCsv(outCsvFilePath,
                new String[]{InFields.fruit.name(),
                InFields.quantity.name()},delimiter);
        for (ProductAccount productAccount:balanceReport) {
            csvProcessorWrite.setField(InFields.fruit.name(),productAccount.getName());
            csvProcessorWrite.setField(InFields.quantity.name(),
                    productAccount.getAmount().toString());
            csvProcessorWrite.write();
        }
    }
}
