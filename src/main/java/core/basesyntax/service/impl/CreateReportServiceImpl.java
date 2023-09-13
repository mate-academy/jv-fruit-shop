package core.basesyntax.service.impl;

import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.FruitService;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String HEADER = "fruit,quantity";
    private FruitService fruitService;

    public CreateReportServiceImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public String createReport() {
        String report = fruitService.getAll();
        return HEADER + report;
    }
}
