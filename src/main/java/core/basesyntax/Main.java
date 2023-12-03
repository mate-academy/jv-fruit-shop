package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitTransactionMapper;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import core.basesyntax.strategy.impl.TradeOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE =
            "src/main/java/core/basesyntax/resourses/inputData.csv";
    private static final String OUTPUT_FILE = "report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader();
        List<String> linesFromFile = fileReader.read(INPUT_FILE);
        FruitTransactionMapper fruitMapper = new FruitTransactionMapper();
        List<FruitTransaction> fruitTransactions = fruitMapper.mapData(linesFromFile);
        OperationStrategy operationStrategy = new OperationStrategy(Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new TradeOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler()
        ));

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.processOperation(fruitTransaction);
        }
        ReportCreator reportCreator = new ReportCreator();
        String report = reportCreator.createReport();
        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.write(report, OUTPUT_FILE);
    }
}
