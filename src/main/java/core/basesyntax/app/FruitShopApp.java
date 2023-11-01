package core.basesyntax.app;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.file.FileReader;
import core.basesyntax.service.file.FileWriter;
import core.basesyntax.service.parser.DataParser;
import core.basesyntax.service.performer.Performer;
import core.basesyntax.service.reporter.Reporter;
import java.util.List;

public class FruitShopApp {
    private final String dataFile;
    private final String resultFile;
    private final FileWriter fileWriter;
    private final FileReader fileReader;
    private final Reporter reporter;
    private final Performer performer;
    private final DataParser dataParser;

    public FruitShopApp(String dataFile, String resultFile,
                        FileWriter fileWriter, FileReader fileReader,
                        Reporter reporter, Performer performer,
                        DataParser dataParser) {
        this.dataFile = dataFile;
        this.resultFile = resultFile;
        this.fileWriter = fileWriter;
        this.fileReader = fileReader;
        this.reporter = reporter;
        this.performer = performer;
        this.dataParser = dataParser;
    }

    public void createDailyReport() {
        List<FruitTransaction> fruitTransactions =
                dataParser.parseData(fileReader.readFromFile(dataFile));
        performer.performAll(fruitTransactions);
        fileWriter.writeIntoFile(resultFile, reporter.createReport());
    }
}
