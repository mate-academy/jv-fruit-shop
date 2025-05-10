package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderServ;
import core.basesyntax.service.FileWriterServ;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.FruitTransactionProcessorImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src\\main\\resources\\inputFile.csv";
    private static final String OUTPUT_FILE_PATH = "src\\main\\resources\\outputFile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategy =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        FileReaderServ readerFromFile = new CsvFileReader();

        List<String> dataFromFile = readerFromFile
                .read(INPUT_FILE_PATH);

        TransactionParser parser = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitTransactions = parser.converterToTransactions(dataFromFile);

        TransactionProcessor processor = new FruitTransactionProcessorImpl();
        processor.process(fruitTransactions, strategy);

        ReportCreator report = new ReportCreatorImpl();
        String string = report.reportCreator(FruitStorage.fruitTransactionStorage);

        FileWriterServ writerService = new CsvFileWriter();
        writerService.write(string, OUTPUT_FILE_PATH);
    }
}
