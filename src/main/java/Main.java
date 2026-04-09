import dao.FruitDao;
import dao.impl.FruitDaoImpl;
import exception.FruitStorageException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.FileReader;
import service.FileWriter;
import service.ReportGenerator;
import service.ShopService;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperation;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperation;
import strategy.impl.ReturnOperation;
import strategy.impl.SupplyOperation;

public class Main {
    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(fruitDao));
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitDao));
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(fruitDao));
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(fruitDao));

        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();
        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(strategy);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(fruitDao);
        FileWriter fileWriter = new FileWriterImpl();

        try {
            List<String> rawData = fileReader.read("reportToRead.csv");
            List<FruitTransaction> transactions = dataConverter.convertToTransaction(rawData);
            shopService.process(transactions);
            fileWriter.write(reportGenerator.getReport(), "finalReport.csv");
        } catch (FruitStorageException e) {
            System.err.println("Transaction error: " + e.getMessage());
        }
    }
}
