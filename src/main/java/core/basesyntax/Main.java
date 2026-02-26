package core.basesyntax;

import core.basesyntax.parser.DataConverter;
import core.basesyntax.parser.DataConverterImpl;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.transaction.FruitTransaction;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    //TODO: Використовувати Reader/Writer інтерфейси замість прямого Files/FileWriter;
    // закривати ресурси через try-with-resources.
    //TODO: Не читати жорстко "data.csv" — передавати шлях через args або конфігурацію.
    //TODO: Не кастити List<?> — змінити сигнатуру DataConverter на List<FruitTransaction>.

    public static void main(String[] arg) throws IOException {
        // 1. Read the data from the input CSV file
        List<String> lines = Files.readAllLines(Path.of("data.csv"));
        // 2. Convert the incoming data into FruitTransactions list
        DataConverter converter = new DataConverterImpl();
        List<FruitTransaction> transactions
                = (List<FruitTransaction>) converter.convertToTransaction(lines);
        // 3. Create and feel the map with all OperationHandler implementations
        // 4. Process the incoming transactions with applicable OperationHandler implementations
        for (FruitTransaction tx : transactions) {
            tx.execute();
        }
        // 5.Generate report based on the current Storage state
        ReportGenerator generator = new ReportGeneratorImpl();
        String report = generator.getReport();
        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriter("finalReport.csv");
        fileWriter.write(report);
    }
}
