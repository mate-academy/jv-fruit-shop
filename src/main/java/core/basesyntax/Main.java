package core.basesyntax;

import core.basesyntax.model.ItemTransaction;
import core.basesyntax.service.Converter;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.Handler;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.ConverterImpl;
import core.basesyntax.service.impl.DataWriterImpl;
import core.basesyntax.service.impl.HandlerImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader csvReader = new ReaderImpl();
        List<String> strings = csvReader.read("src/main/resources/input.csv");
        Converter converter = new ConverterImpl();
        List<ItemTransaction> itemTransactions = converter.convert(strings);

        Handler handler = new HandlerImpl();
        handler.handle(itemTransactions);

        ReportCreator reportCreator = new ReportCreatorImpl();
        List<String> report = reportCreator.report();

        DataWriter dataWriter = new DataWriterImpl();
        dataWriter.write(report, "report.csv");
    }
}
