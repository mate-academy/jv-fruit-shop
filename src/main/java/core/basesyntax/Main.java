package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateBalance;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriterFile;
import core.basesyntax.service.impl.CalculateBalanceImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WriterFileImpl;
import core.basesyntax.strategy.OperationHandlerBalance;
import core.basesyntax.strategy.OperationHandlerIn;
import core.basesyntax.strategy.OperationHandlerOut;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> correspondenceTable = Map.of(
                FruitTransaction.Operation.BALANCE, new OperationHandlerBalance(),
                FruitTransaction.Operation.SUPPLY, new OperationHandlerIn(),
                FruitTransaction.Operation.RETURN, new OperationHandlerIn(),
                FruitTransaction.Operation.PURCHASE, new OperationHandlerOut());
        String outFileName = "src/main/resources/report.csv";
        FileReader fileReader = new FileReaderImpl();
        WriterFile fileWriter = new WriterFileImpl();
        CalculateBalance calculateBalance = new CalculateBalanceImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        calculateBalance.calculateBalance(transactionParser.parseTransaction(
                fileReader.readFile()), correspondenceTable);
        fileWriter.writeToFile(reportGenerator.makeReport(), outFileName);
    }
}


