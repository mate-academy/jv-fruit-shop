package myFruitShop.Service;

import myFruitShop.Parser.DtoCreator;
import myFruitShop.ReportGenerator;
import myFruitShop.ReportGeneratorImpl;
import myFruitShop.ReportSupplier;
import myFruitShop.RepotrToFIleConverter;
import myFruitShop.model.TransactionDto;

import java.io.File;
import java.util.List;

public class FruitShopServiceImpl {
    private OperationStrategy operationStrategy;
    private DtoCreator dataInDto;


    public FruitShopServiceImpl(OperationStrategy operationStrategy, DtoCreator dataInDto) {
        this.operationStrategy = operationStrategy;
        this.dataInDto = dataInDto;
    }

    void fruitStorageModifier(List<TransactionDto> dataInDto) {
        for (TransactionDto infoLine : dataInDto) {
            operationStrategy.get(infoLine.getOperationType()).applyOperation(infoLine);      //applying logic to infoLone.
        }                                                                                     // after loop, storage will be changed
    }
    File fileReportBuilder() {
        ReportGenerator stringReport = new ReportGeneratorImpl();          // this needs nothing, he already have access to changed map in storage
        ReportSupplier fileReport = new RepotrToFIleConverter();            // this work only with result of previous one;
        return fileReport.writeToFile(stringReport);
    }                                                                       //IMPORTANT First fruitStorageModifier  Then fileReportBuilder








}
