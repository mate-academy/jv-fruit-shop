package core.basesyntax;

import core.basesyntax.converter.Converter;
import core.basesyntax.converter.ConverterImpl;
import core.basesyntax.handler.Handler;
import core.basesyntax.handler.HandlerImpl;
import core.basesyntax.reader.Reader;
import core.basesyntax.reader.ReaderImpl;
import core.basesyntax.report.ReportCreator;
import core.basesyntax.report.ReportCreatorImpl;
import core.basesyntax.writer.DataWriter;
import core.basesyntax.writer.DataWriterImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader csvReader = new ReaderImpl();
        List<String> strings = csvReader.read("input.csv");

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
