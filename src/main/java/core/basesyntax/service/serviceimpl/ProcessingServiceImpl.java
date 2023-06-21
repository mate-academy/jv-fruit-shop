package core.basesyntax.service.serviceimpl;

import core.basesyntax.model.Activities;
import core.basesyntax.model.ItemActivities;
import core.basesyntax.service.ActivitiesService;
import core.basesyntax.service.ProcessingService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.fileservice.impl.FileReaderServiceImpl;
import core.basesyntax.service.fileservice.impl.FileWriterServiceImpl;
import core.basesyntax.service.strategy.ActivitiesHandler;
import core.basesyntax.service.strategy.ActivitiesStrategy;
import core.basesyntax.service.strategy.ActivitiesStrategyImpl;
import java.util.List;
import java.util.Map;

public class ProcessingServiceImpl implements ProcessingService {
    private final ActivitiesStrategy activitiesStrategy;
    private final FileReaderServiceImpl fileReader;
    private final ActivitiesService activitiesService;
    private final FileWriterServiceImpl fileWriter;
    private final ReportService reportService;

    public ProcessingServiceImpl(Map<Activities, ActivitiesHandler> map) {
        this.activitiesStrategy = new ActivitiesStrategyImpl(map);
        this.fileReader = new FileReaderServiceImpl();
        this.activitiesService = new ActivitiesServiceImpl();
        this.fileWriter = new FileWriterServiceImpl();
        this.reportService = new ReportServiceImpl();
    }

    @Override
    public void processReport(String fileFrom, String fileTo) {
        List<String> dataFromFile = fileReader.getData(fileFrom);
        processTransaction(activitiesService.createActivitiesList(dataFromFile));
        fileWriter.setData(reportService.getReport(), fileTo);
    }

    private void processTransaction(List<ItemActivities> transactions) {
        transactions
                .forEach(transaction ->
                        activitiesStrategy.get(transaction.getOperation()).update(transaction));
    }
}
