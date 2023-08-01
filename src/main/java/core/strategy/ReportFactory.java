package core.strategy;

import core.service.DataSpliterator;
import core.service.FruitStore;
import core.service.OperationData;
import core.service.ReaderFile;
import core.service.ReportWriter;
import java.util.List;

public class ReportFactory implements Strategy {
    private static final ReaderFile readerFile = new ReaderFile();
    private static final DataSpliterator dataSpliterator = new DataSpliterator();
    private static final FruitStore fruitStore = new FruitStore();
    private static final ReportWriter reportWriter = new ReportWriter();

    @Override
    public void start(String fromPath, String toPath) {
        String data = readerFile.read(fromPath);
        List<OperationData> splitData = dataSpliterator.splitData(data);
        List<OperationData> report = fruitStore.processOperations(splitData);
        String reportInString = fruitStore.convertListToString(report);
        reportWriter.createReport(toPath, reportInString);
    }
}
