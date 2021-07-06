package core.basesyntax;

import core.basesyntax.dto.Transaction;
import core.basesyntax.service.FruitReportService;
import core.basesyntax.service.MyFileReader;
import core.basesyntax.service.MyFileWriter;
import core.basesyntax.service.ParserData;
import core.basesyntax.service.impl.FruitReportServiceImpl;
import core.basesyntax.service.impl.MyFileReaderImpl;
import core.basesyntax.service.impl.MyFileWriterImpl;
import core.basesyntax.service.impl.ParserDataImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationsMap = new HashMap<>();
        operationsMap.put("b", new BalanceOperation());
        operationsMap.put("s", new SupplyOperation());
        operationsMap.put("p", new PurchaseOperation());
        operationsMap.put("r", new SupplyOperation());

        MyFileReader reader = new MyFileReaderImpl();
        List<String> listData = reader.readFromFile("data.csv");
        listData.remove(0);

        ParserData parser = new ParserDataImpl();
        List<Transaction> transactionsList = new ArrayList<>();

        for (String line : listData) {
            Transaction transaction = parser.parseData(line);
            operationsMap.get(transaction.getOperation()).apply(transaction);
        }
        FruitReportService fruitReport = new FruitReportServiceImpl();
        MyFileWriter writer = new MyFileWriterImpl();
        writer.writeToFile("finalData.csv", fruitReport.report());

    }
}
