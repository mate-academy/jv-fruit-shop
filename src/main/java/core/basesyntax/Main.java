package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.StorageFilling;
import core.basesyntax.serviceimpl.DataParsesImpl;
import core.basesyntax.serviceimpl.DataReaderImpl;
import core.basesyntax.serviceimpl.ReportCreatorImpl;
import core.basesyntax.serviceimpl.ReportWriterImpl;
import core.basesyntax.serviceimpl.StorageFillingImpl;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        final String inputDbPath = "src/main/resources/inputDB.csv";
        final String reportPath = "src/main/resources/report.csv";
        Storage storage = new Storage(new HashMap<>());
        DataReader dataReader = new DataReaderImpl();
        DataParser dataParser = new DataParsesImpl();
        StorageFilling storageFilling = new StorageFillingImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();
        ReportWriter reportWriter = new ReportWriterImpl();
        String dataFromFile = dataReader.readDataFromFile(inputDbPath);
        String[] parsedData = dataParser.getParsedData(dataFromFile);
        storageFilling.addToStorage(parsedData, storage);
        String report = reportCreator.createReport(storage);
        reportWriter.writeReportToFile(report, reportPath);
    }
}
