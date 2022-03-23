import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import operation.BalanceHandler;
import operation.Operation;
import operation.PurchaseHandler;
import operation.ReturnHandler;
import operation.SupplyHandler;
import service.FruitParser;
import service.FruitParserImpl;
import service.Reader;
import service.ReaderImpl;
import service.ReportCreator;
import service.ReportCreatorImpl;
import service.Writer;
import service.WriterImpl;
import strategy.FruitStrategy;
import strategy.FruitStrategyImpl;

public class Main {
    private static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();
    private static final String INPUT_FILE = "src" + FILE_SEPARATOR
            + "main" + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "input.csv";
    private static final String OUTPUT_FILE = "src" + FILE_SEPARATOR
            + "main" + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, Operation> operationHashMap = new HashMap<>();
        operationHashMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHashMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHashMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHashMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        Reader reader = new ReaderImpl();
        FruitParser parser = new FruitParserImpl();
        List<String> stringList = reader.read(INPUT_FILE);
        for (String string : stringList) {
            List<FruitTransaction> fruitTransactionList = new ArrayList<>();
            FruitTransaction fruitTransaction = parser.getFromCsvRow(string);
            fruitTransactionList.add(fruitTransaction);
            for (FruitTransaction transaction : fruitTransactionList) {
                FruitStrategy fruitStrategy = new FruitStrategyImpl(operationHashMap);
                fruitStrategy.proceed(transaction);
            }
        }
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        List<FruitTransaction> fruitTransactionList = fruitShopDao.getAll();
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(fruitTransactionList);
        Writer writer = new WriterImpl();
        writer.write(report, OUTPUT_FILE);
    }
}
