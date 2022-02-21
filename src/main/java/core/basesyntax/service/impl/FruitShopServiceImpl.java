package core.basesyntax.service.impl;

import core.basesyntax.service.DataHandler;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportCreateService;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final DataHandler dataHandler;
    private final ReportCreateService reportCreateService;

    public FruitShopServiceImpl(DataHandler dataHandler,
                                ReportCreateService reportCreateService) {
        this.dataHandler = dataHandler;
        this.reportCreateService = reportCreateService;
    }

    @Override
    public String makeDailyReport(List<String> dataFromFile) {
        dataHandler.processData(dataFromFile);
        return reportCreateService.createReport();
    }
}
