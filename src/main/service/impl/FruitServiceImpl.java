package main.service.impl;

import main.model.dto.FruitRecordDto;
import main.service.interfaces.FruitService;
import main.service.interfaces.OperationStrategy;
import main.service.interfaces.ParserService;
import main.service.interfaces.ReportGeneratorService;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final ReportGeneratorService reportGeneratorService;
    private final OperationStrategy operationStrategy;
    private final ParserService parserService;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        parserService = new ParserServiceImpl();
        reportGeneratorService = new ReportGeneratorServiceImpl();
    }

    @Override
    public void saveData(List<String> data) {
        data.stream()
                .skip(1)
                .map(parserService::parse)
                .forEach(this::applyStrategy);
    }

    @Override
    public String getReport() {
        return reportGeneratorService.generateReport();
    }

    private void applyStrategy(FruitRecordDto fruitRecord) {
        operationStrategy.get(fruitRecord.getOperation()).apply(fruitRecord);
    }
}
