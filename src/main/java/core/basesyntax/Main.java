package core.basesyntax;

import db.FileReader;
import db.FileWriter;
import db.Parser;
import db.ReportMaker;
import java.util.List;
import model.FruitTransaction;
import storege.Storege;
import strategy.OperationHandler;
import strategy.Strategy;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/InputFile.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/ExpectingReportFile.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> data = fileReader.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = new Parser().parse(data);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            Strategy strategy = new Strategy();
            OperationHandler operationHandler = strategy.get(fruitTransaction.getOperation());
            operationHandler.apply(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
        new FileWriter().writeToFile(OUTPUT_FILE_PATH,
                new ReportMaker().reportMaker(Storege.data.entrySet()));
    }
}
