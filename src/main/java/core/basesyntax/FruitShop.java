package core.basesyntax;

import core.basesyntax.dto.Transaction;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.FruitReportService;
import core.basesyntax.service.MyFileReader;
import core.basesyntax.service.MyFileWriter;
import core.basesyntax.service.impl.DataValidatorServiceImpl;
import core.basesyntax.service.impl.FruitReportServiceImpl;
import core.basesyntax.service.impl.MyFileReaderImpl;
import core.basesyntax.service.impl.MyFileWriterImpl;
import core.basesyntax.service.impl.ParserDataImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationsMap = new HashMap<>();
        operationsMap.put("b", new BalanceOperationHandler());
        operationsMap.put("s", new SupplyOperationHandler());
        operationsMap.put("p", new PurchaseOperationHandler());
        operationsMap.put("r", new SupplyOperationHandler());
        MyFileReader reader = new MyFileReaderImpl();
        List<String> listData = reader.readFromFile("src/main/resources/data.csv");
        listData.remove(0);
        DataValidatorServiceImpl validator = new DataValidatorServiceImpl();

        DataParser parser = new ParserDataImpl();
        for (String line : listData) {
            validator.checkDataInput(line.split(","));
            Transaction transaction = parser.parseData(line);
            operationsMap.get(transaction.getOperation()).apply(transaction);
        }
        FruitReportService fruitReport = new FruitReportServiceImpl();
        MyFileWriter writer = new MyFileWriterImpl();
        writer.writeToFile("src/main/resources/finalData.csv", fruitReport.getReport());
    }
}
