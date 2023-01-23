package core.basesyntax;

import core.basesyntax.model.FruitReport;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParserService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitTransactionParserServiceImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterImpl;
import java.util.List;

public class FruitShop {

    public void processing() {
        Reader reader = new ReaderImpl();
        String fromFilePath = "src/main/resources/input.csv";
        List<FruitTransaction> readFromFile = reader.readFromFile(fromFilePath);

        FruitTransactionParserService fruitTransactionParserService
                = new FruitTransactionParserServiceImpl();
        List<FruitReport> dataforReport =
                fruitTransactionParserService.prepareDataForReport(readFromFile);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(dataforReport);

        Writer writer = new WriterImpl();
        String toFilePath = "src/main/resources/report.csv";
        writer.writeInFile(report, toFilePath);
    }

    public static void main(String[] args) {
        FruitShop fruitShop = new FruitShop();
        fruitShop.processing();
    }
}
