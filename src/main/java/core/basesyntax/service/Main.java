package core.basesyntax.service;

import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.service.model.FruitTransaction;
import core.basesyntax.service.service.ReaderService;
import core.basesyntax.service.service.ReportService;
import core.basesyntax.service.service.TransactionParserService;
import core.basesyntax.service.service.TransactionParserServiceImpl;
import core.basesyntax.service.service.WriteService;
import core.basesyntax.service.strategy.StrategyImpl;
import java.util.List;

public class Main {
    public static final String NAME_FILE_FROM =
            "src/main/java/core/basesyntax/service/resources/fruits.csv";
    public static final String NAME_FILE_TO =
            "src/main/java/core/basesyntax/service/resources/fruits_result.csv";
    private static final ReaderService readerService =
            new ReaderServiceImpl();
    private static final TransactionParserService transactionParserService =
            new TransactionParserServiceImpl();
    private static final FruitShopServiceImpl evaluateResultImpl =
            new FruitShopServiceImpl(new StrategyImpl());
    private static final ReportService reportService = new ReportServiceImpl();
    private static final WriteService writeService = new WriteServiceImpl();
    
    public static void main(String[] args) {
        List<String[]> infoFromFIle = readerService.read(NAME_FILE_FROM);
        List<FruitTransaction> report = transactionParserService.create(infoFromFIle);
        evaluateResultImpl.realizePattern(report);
        String result = reportService.createReport();
        writeService.writeToFile(result, NAME_FILE_TO);
    }
}
