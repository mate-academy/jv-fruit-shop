import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitMapper;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FROM = "inputData.csv";
    private static final String WRITE_TO = "report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader();
        List<String> linesFromFile = fileReader.read(READ_FROM);
        FruitMapper fruitMapper = new FruitMapper();
        List<FruitTransaction> fruitTransactions = fruitMapper.mapData(linesFromFile);
        OperationStrategy operationStrategy = new OperationStrategy(Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler()
        ));

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.processOperation(fruitTransaction);
        }
        ReportCreator reportCreator = new ReportCreator();
        String report = reportCreator.createReport(Storage.FRUITS);
        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.write(report,WRITE_TO);
    }
}
