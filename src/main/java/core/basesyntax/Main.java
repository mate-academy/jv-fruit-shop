package core.basesyntax;

import db.impl.FileReaderImpl;
import db.impl.FileWriterImpl;
import db.impl.ParserImpl;
import db.impl.ReportMakerImpl;
import java.util.List;
import model.FruitTransaction;
import storege.Storege;
import strategy.OperationHandler;
import strategy.Strategy;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/InputFile.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/ExpectingReportFile.csv";

    public static void main(String[] args) {
        FileReaderImpl fileReader = new FileReaderImpl();
        List<String> data = fileReader.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = new ParserImpl().parse(data);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            Strategy strategy = new Strategy();
            OperationHandler operationHandler = strategy.get(fruitTransaction.getOperation());
            operationHandler.apply(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
        new FileWriterImpl().writeToFile(OUTPUT_FILE_PATH,
                new ReportMakerImpl().reportMaker(Storege.data.entrySet()));
    }
}
