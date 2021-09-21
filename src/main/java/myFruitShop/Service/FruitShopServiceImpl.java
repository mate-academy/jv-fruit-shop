package myFruitShop.Service;

import myFruitShop.model.OperationsDto;

import java.io.File;
import java.util.List;

public class FruitShopServiceImpl implements  FruitShopService{
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

   public void fruitStorageModifier(List<OperationsDto> dataInDto) {
        for (OperationsDto infoLine : dataInDto) {
            operationStrategy.get(infoLine.getOperationType()).applyOperation(infoLine);      //applying logic to infoLone.
        }                                                                                     // after loop, storage will be changed
    }
   public File fileReportBuilder(String reportFileName) {
        ReportGenerator stringReport = new ReportGeneratorImpl();          // this needs nothing, he already have access to changed map in storage
        ReportSupplier fileReport = new RepotrToFIleConverter();            // this work only with result of previous one;
        return fileReport.writeToFile(stringReport, reportFileName);
    }                                                                       //IMPORTANT First fruitStorageModifier  Then fileReportBuilder








}
