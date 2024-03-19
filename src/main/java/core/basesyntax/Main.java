package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.impl.FruitFileReaderImpl;
import core.basesyntax.service.impl.FruitFileSaverImpl;
import core.basesyntax.service.impl.FruitRawStringParserImpl;
import core.basesyntax.service.impl.FruitReportCreateImpl;
import core.basesyntax.service.interfaces.FruitFileReader;
import core.basesyntax.service.interfaces.FruitReportCreate;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.impl.BalanceOperationHandler;
import core.basesyntax.service.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.service.strategy.impl.ReturnOperationHandler;
import core.basesyntax.service.strategy.impl.SupplyOperationHandler;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FruitFileReader reader = new FruitFileReaderImpl();
        List<String> fileString = reader.readFile("src/main/resources/fruitts.csv");
        FruitRawStringParserImpl parser = new FruitRawStringParserImpl();
        var readerService = parser.parsedFruitData(fileString);
        var balance = new BalanceOperationHandler();
        var supply = new SupplyOperationHandler();
        var returns = new ReturnOperationHandler();
        var purchase = new PurchaseOperationHandler();
        List<OperationHandler> handlers = List.of(balance,returns,purchase,supply);
        OperationStrategy strategy = new OperationStrategy(handlers);
        List<FruitTransactionDto> dtos = readerService;
        for (var dto : dtos) {
            strategy.getHandlers(dto).forEach(oh -> oh.apply(dto));
        }
        System.out.println(Storage.fruitsQuantity);
        FruitReportCreate prapaireReport = new FruitReportCreateImpl();
        String report = prapaireReport.createReport(Storage.fruitsQuantity);
        System.out.println(report);
        FruitFileSaverImpl saver = new FruitFileSaverImpl();
        saver.saveToFile(report,"src/main/resources/report.csv");
    }
}
