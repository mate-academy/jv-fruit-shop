package core.basesyntax;

import core.basesyntax.filerider.CsvFileReaderServiceImpl;
import core.basesyntax.filewriter.FileWriterService;
import core.basesyntax.operationhandler.BalanceHandler;
import core.basesyntax.operationhandler.OperationHandler;
import core.basesyntax.operationhandler.PurchaseHandler;
import core.basesyntax.operationhandler.ReturnHandler;
import core.basesyntax.operationhandler.SupplyHandler;
import core.basesyntax.reportcreator.ReportCreator;
import core.basesyntax.transactionparser.CsvTransactionParser;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Storage storage = new Storage();

        final OperationHandler purchaseHandler = new PurchaseHandler();

        final OperationHandler returnHandler = new ReturnHandler();

        final OperationHandler supplyHandler = new SupplyHandler();

        final OperationHandler balanceHandler = new BalanceHandler();

        supplyHandler.handleOperation(new FruitTransaction(Operation
                .SUPPLY,"Orange", 20), storage);
        supplyHandler.handleOperation(new FruitTransaction(Operation
                .SUPPLY,"Orange", 20), storage);
        supplyHandler.handleOperation(new FruitTransaction(Operation
                .SUPPLY,"Orange", 20), storage);
        supplyHandler.handleOperation(new FruitTransaction(Operation
                .SUPPLY,"Apple", 20), storage);
        supplyHandler.handleOperation(new FruitTransaction(Operation
                .SUPPLY,"Apple", 20), storage);
        supplyHandler.handleOperation(new FruitTransaction(Operation
                .SUPPLY,"Pea", 20), storage);
        supplyHandler.handleOperation(new FruitTransaction(Operation
                .SUPPLY,"Pea", 20), storage);
        purchaseHandler.handleOperation(new FruitTransaction(Operation
                .PURCHASE,"Apple", 10), storage);
        returnHandler.handleOperation(new FruitTransaction(Operation
                .RETURN,"Apple", 5), storage);
        returnHandler.handleOperation(new FruitTransaction(Operation
                .RETURN,"Apple", 10), storage);
        supplyHandler.handleOperation(new FruitTransaction(Operation
                .SUPPLY, "Kiwi", 20), storage);

        balanceHandler.handleOperation(null, storage);

        CsvFileReaderServiceImpl fileReader = new CsvFileReaderServiceImpl();
        CsvTransactionParser transactionParser = new CsvTransactionParser();
        List<String> lines = fileReader.readData("src/main/resources/input.csv");
        List<FruitTransaction> transactions = transactionParser.parseTransactions(lines);
        ReportCreator reportCreator = new ReportCreator();
        FileWriterService fileWriter = new FileWriterService();
        for (FruitTransaction transaction : transactions) {
            if (transaction.getOperation().equals(Operation.BALANCE)) {
                balanceHandler.handleOperation(transaction, storage);
            } else {
                returnHandler.handleOperation(transaction, storage);
            }
        }
        String report = reportCreator.generateReport();
        fileWriter.writeToFile(report, "src/main/resources/report.csv");
    }
}
