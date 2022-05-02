package core.basesyntax;

import java.util.List;
import model.FruitTransaction;
import service.FileReader;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.ParserImpl;
import service.impl.ReportMakerImpl;
import storage.Storage;
import strategy.OperationHandler;
import strategy.Strategy;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/InputFile.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/ExpectingReportFile.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> data = fileReader.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = new ParserImpl().parse(data);
        Strategy strategy = new Strategy();
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = strategy.get(fruitTransaction.getOperation());
            operationHandler.apply(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
        new FileWriterImpl().writeToFile(OUTPUT_FILE_PATH,
                new ReportMakerImpl().createReport(Storage.data.entrySet()));
    }
}
