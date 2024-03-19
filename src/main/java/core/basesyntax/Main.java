package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.impl.FruitFileReaderImpl;
import core.basesyntax.service.impl.FruitFileSaverImpl;
import core.basesyntax.service.impl.FruitRawStringParserImpl;
import core.basesyntax.service.impl.FruitReportCreateImpl;
import core.basesyntax.service.interfaces.FruitFileReader;
import core.basesyntax.service.interfaces.FruitReportCreate;
import core.basesyntax.service.strategy.FruitStrategy;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.impl.BalanceOperation;
import core.basesyntax.service.strategy.impl.PurchaseOperation;
import core.basesyntax.service.strategy.impl.ReturnOperation;
import core.basesyntax.service.strategy.impl.SupplyOperation;
import java.util.List;

public class Main {
    private static String fileOpen = "src/main/resources/fruitts.csv";
    //    private static String fileOpen = "src/main/resources/fruitsWithNulls.csv";
    private static String fileSave = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitFileReader reader = new FruitFileReaderImpl();
        List<String> fileString = reader.readFile(fileOpen);
        System.out.println(fileString);
        FruitRawStringParserImpl parser = new FruitRawStringParserImpl();
        var readerService = parser.parsedFruitData(fileString);
        System.out.println(readerService);
        var balance = new BalanceOperation();
        var supply = new SupplyOperation();
        var returns = new ReturnOperation();
        var purchase = new PurchaseOperation();
        List<OperationHandler> handlers = List.of(balance,returns,purchase,supply);
        FruitStrategy strategy = new FruitStrategy(handlers);
        List<FruitTransactionDto> dtos = readerService;
        for (var dto : dtos) {
            strategy.getHandlers(dto).forEach(oh -> oh.apply(dto));
        }
        System.out.println(Storage.fruitsQuantity);
        FruitReportCreate prapaireReport = new FruitReportCreateImpl();
        String report = prapaireReport.createReport(Storage.fruitsQuantity);
        System.out.println(report);
        FruitFileSaverImpl saver = new FruitFileSaverImpl();
        saver.saveToFile(report,fileSave);
    }
}
