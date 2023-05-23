package core.basesyntax.service;

import core.basesyntax.fileserve.FileService;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.process.FruitReportMaker;
import core.basesyntax.process.FruitTransactionService;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private FileService fileService;
    private FruitTransactionService fruitTransactionService;
    private FruitReportMaker fruitReportMaker;

    public FruitShopServiceImpl(FileService fruitsDao,
                                FruitTransactionService fruitTransactionService,
                                FruitReportMaker fruitReportMaker) {
        this.fileService = fruitsDao;
        this.fruitTransactionService = fruitTransactionService;
        this.fruitReportMaker = fruitReportMaker;
    }

    @Override
    public String serviceFruitsShop(String fromFile, String toFile) {
        String fruitsData = fileService.getFruitData(fromFile);
        List<FruitTransaction> transactionList = fruitTransactionService
                .parseFruitData(fruitsData);
        fruitTransactionService.processTransactionList(transactionList);
        String fruitReport = fruitReportMaker.makeFruitReport();
        fileService.writeToFile(fruitReport, toFile);
        return fruitReport;
    }
}
