package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitNegotiation;
import core.basesyntax.service.FruitEvaluator;
import core.basesyntax.service.NegotiationParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerateService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitEvaluatorImpl;
import core.basesyntax.service.impl.NegotiationParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGenerateServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class MainApp {
    private static final String INPUT_CSV = "input.csv";
    private static final String OTPUT_CSV = "results.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        NegotiationParserService parser = new NegotiationParserServiceImpl();
        FruitEvaluator evaluationFruits = new FruitEvaluatorImpl();
        ReportGenerateService reportGenerateService = new ReportGenerateServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        List<String> recordsOfData = readerService.readFileToList(INPUT_CSV);
        List<FruitNegotiation> parsedData = parser.createNegotiation(recordsOfData);
        evaluationFruits.evaluate(parsedData);
        String dataOfReport = reportGenerateService.generateReportText(Storage.storage);
        writerService.writeReportToFile(OTPUT_CSV, dataOfReport);
    }
}
