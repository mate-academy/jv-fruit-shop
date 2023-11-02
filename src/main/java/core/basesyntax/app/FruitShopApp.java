package core.basesyntax.app;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.file.FileReader;
import core.basesyntax.service.file.FileWriter;
import core.basesyntax.service.parser.DataParser;
import core.basesyntax.service.performer.Performer;
import core.basesyntax.service.reporter.Reporter;
import java.util.List;

public class FruitShopApp {
    private final FileWriter fileWriter;
    private final FileReader fileReader;
    private final Reporter reporter;
    private final Performer performer;
    private final DataParser dataParser;

    public FruitShopApp(FileWriter fileWriter, FileReader fileReader,
                        Reporter reporter, Performer performer,
                        DataParser dataParser) {
        this.fileWriter = fileWriter;
        this.fileReader = fileReader;
        this.reporter = reporter;
        this.performer = performer;
        this.dataParser = dataParser;
    }

    public void createDailyReport(String fromFile, String toFile) {
        List<FruitTransaction> fruitTransactions =
                dataParser.parseData(fileReader.readFromFile(fromFile));
        performer.performAll(fruitTransactions);
        fileWriter.writeIntoFile(toFile, reporter.createReport());
    }
}
