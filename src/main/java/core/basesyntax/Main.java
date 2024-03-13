package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.GenerateReportService;
import core.basesyntax.service.ParseDataService;
import core.basesyntax.service.ReaderFileService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.GenerateReportServiceImpl;
import core.basesyntax.service.impl.ParseDataServiceImpl;
import core.basesyntax.service.impl.ReaderFileServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.TransactionProcessor;
import core.basesyntax.strategy.impl.BalanceCodeService;
import core.basesyntax.strategy.impl.PurchaseCodeService;
import core.basesyntax.strategy.impl.ReturnCodeService;
import core.basesyntax.strategy.impl.SupplyCodeService;
import java.util.List;
import java.util.Map;

public class Main {
    private static String pathFileRead = "src/main/resources/text.csv";
    private static String pathFileWrite = "src/main/resources/textResult.csv";
    private static ReaderFileService csvReaderService = new ReaderFileServiceImpl();
    private static ParseDataService parseDataService = new ParseDataServiceImpl();
    private static Map<FruitTransaction.Operation, TransactionProcessor> codeServiceMap = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceCodeService(),
            FruitTransaction.Operation.PURCHASE, new PurchaseCodeService(),
            FruitTransaction.Operation.RETURN, new ReturnCodeService(),
            FruitTransaction.Operation.SUPPLY, new SupplyCodeService()
    );
    private static OperationStrategy operationStrategy = new OperationStrategyImpl(codeServiceMap);
    private static TransactionService transactionService =
            new TransactionServiceImpl(operationStrategy);
    private static FruitDao fruitDao = new FruitDaoImpl();
    private static GenerateReportService generateReportService =
            new GenerateReportServiceImpl(fruitDao);
    private static WriterService csvWriterService = new WriterServiceImpl();

    public static void main(String[] args) {
        String dataFromFile = csvReaderService.readFile(pathFileRead);
        List<FruitTransaction> fruitList = parseDataService.parseData(dataFromFile);
        transactionService.processTransactions(fruitList);
        String generateReport = generateReportService.generateReport();
        csvWriterService.writeToFile(pathFileWrite, generateReport);
    }
}
