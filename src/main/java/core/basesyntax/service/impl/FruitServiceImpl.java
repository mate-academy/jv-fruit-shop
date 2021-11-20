package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.interfaces.FruitService;
import core.basesyntax.service.interfaces.OperationStrategy;
import core.basesyntax.service.interfaces.ParserService;
import core.basesyntax.service.interfaces.ReportGeneratorService;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final ReportGeneratorService reportGeneratorService;
    private final OperationStrategy operationStrategy;
    private final ParserService parserService;

    public FruitServiceImpl(ReportGeneratorService reportGeneratorService,
                            OperationStrategy operationStrategy,
                            ParserService parserService) {
        this.reportGeneratorService = reportGeneratorService;
        this.operationStrategy = operationStrategy;
        this.parserService = parserService;
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
