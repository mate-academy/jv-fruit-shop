package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvReaderService;
import core.basesyntax.service.CsvWriteService;
import core.basesyntax.service.CsvWriterCreateService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriteServiceImpl;
import core.basesyntax.service.impl.CsvWriterCreateServiceImpl;
import core.basesyntax.service.impl.HandlerWriteDataServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.CodeService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.impl.BalanceCodeService;
import core.basesyntax.strategy.impl.PurchaseCodeService;
import core.basesyntax.strategy.impl.ReturnCodeService;
import core.basesyntax.strategy.impl.SupplyCodeService;
import java.util.List;
import java.util.Map;

public class Main {
    private static String pathFileRead = "src/main/resources/text.csv";
    private static String pathFileWrite = "src/main/resources/textResult.csv";
    private static CsvReaderService csvReaderService = new CsvReaderServiceImpl();
    private static CsvWriteService csvWriteService = new CsvWriteServiceImpl();
    private static CsvWriterCreateService csvWriterService =
            new CsvWriterCreateServiceImpl(csvWriteService);

    private static Map<FruitTransaction.Operation, CodeService> codeServiceMap = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceCodeService(),
            FruitTransaction.Operation.PURCHASE, new PurchaseCodeService(),
            FruitTransaction.Operation.RETURN, new ReturnCodeService(),
            FruitTransaction.Operation.SUPPLY, new SupplyCodeService()
    );
    private static OperationStrategy operationStrategy = new OperationStrategyImpl(codeServiceMap);
    private static TransactionService processData =
            new TransactionServiceImpl(operationStrategy);

    public static void main(String[] args) {
        List<FruitTransaction> fruitTransactionList = csvReaderService.readCsv(pathFileRead);
        processData.processTransactions(fruitTransactionList);
        csvWriterService.createWriteCsv(pathFileWrite,
                new HandlerWriteDataServiceImpl().handlerDataToWrite());
    }
}
