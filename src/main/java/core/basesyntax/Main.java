package core.basesyntax;

import core.basesyntax.model.Transaktion;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("r", new ReturnOperationHandler());
        map.put("s", new SupplyOperationStrategy());

        OperationStrategy strategy = new OperationStrategy(map);

        ReaderService readerService = new ReaderServiceImpl();
        List<String> lines = readerService.readFromFile("src/main/resourses/Input.csv");

        List<Transaktion> transaktions = new ParserImpl().parse(lines);

        for (Transaktion transaktion : transaktions) {
            OperationHandler handler = strategy.getByOperation(transaktion.getOperation());
            handler.apply(transaktion);
        }

        String report = new ReportServiceImpl().getReport();

        new WriterServiceImpl().writeToFile(report, "src/main/resourses/output.csv");
    }
}
