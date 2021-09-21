package fruitshop.service;

import fruitshop.model.OperationsDto;
import fruitshop.service.reporthandlers.ReportGenerator;
import fruitshop.service.reporthandlers.ReportGeneratorImpl;
import fruitshop.service.reporthandlers.ReportSupplier;
import fruitshop.service.reporthandlers.RepotrToFIleConverter;
import java.io.File;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void fruitStorageModifier(List<OperationsDto> dataInDto) {
        for (OperationsDto infoLine : dataInDto) {
            operationStrategy.get(infoLine.getOperationType()).applyOperation(infoLine);
        }
    }

    public File fileReportBuilder(String reportFileName) {
        ReportGenerator stringReport = new ReportGeneratorImpl();
        ReportSupplier fileReport = new RepotrToFIleConverter();
        return fileReport.writeToFile(stringReport, reportFileName);
    }
}
