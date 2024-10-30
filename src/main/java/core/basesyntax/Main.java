package core.basesyntax;

import core.basesyntax.dao.FruitFileDaoReader;
import core.basesyntax.dao.FruitFileDaoReaderImpl;
import core.basesyntax.dao.FruitFileDaoWriter;
import core.basesyntax.dao.FruitFileDaoWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.FruitReportService;
import core.basesyntax.report.FruitReportServiceImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.servicehandler.BalanceHandler;
import core.basesyntax.servicehandler.FruitOperationHandler;
import core.basesyntax.servicehandler.PurchaseHandler;
import core.basesyntax.servicehandler.ReturnHandler;
import core.basesyntax.servicehandler.SupplyHandler;
import core.basesyntax.serviceparser.FruitTransactionParser;
import core.basesyntax.serviceparser.FruitTransactionParserImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitFileDaoReader fileReader = new FruitFileDaoReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        FruitTransactionParser parser = new FruitTransactionParserImpl();

        Map<String, Integer> fruitStorage = new HashMap<>();

        Map<FruitTransaction.Operation, FruitOperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(fruitStorage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(fruitStorage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandler(fruitStorage));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler(fruitStorage));

        List<FruitTransaction> transactions = parser.parse(inputReport);

        ShopService shopService = new ShopServiceImpl(operationHandlers);
        shopService.process(transactions);

        FruitReportService reportService = new FruitReportServiceImpl(fruitStorage);
        String report = reportService.getReport();

        FruitFileDaoWriter fileWriter = new FruitFileDaoWriterImpl();
        fileWriter.write(report, "finalReport.csv");
    }
}
