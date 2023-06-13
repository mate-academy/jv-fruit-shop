package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitTransactionParseService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private FruitDao fruitDao;
    private FileService fileService;
    private FruitTransactionParseService fruitTransactionParseService;
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(FruitDao fruitDao, FileService fileService,
                                FruitTransactionParseService fruitTransactionParseService,
                                OperationStrategy operationStrategy) {

        this.fruitDao = fruitDao;
        this.fileService = fileService;
        this.fruitTransactionParseService = fruitTransactionParseService;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void generateRreport(String pathFrom, String pathTo) {
        List<String> records = fileService.readFromFile(pathFrom);
        List<FruitTransaction> transactions =
                fruitTransactionParseService.parseFruitTransaction(records);

        for (FruitTransaction transaction : transactions) {
            int currentQuantity = 0;
            if (fruitDao.containsFruit(transaction.getFruit())) {
                currentQuantity = fruitDao.get(transaction.getFruit());
            }
            int newQuantity = operationStrategy.get(transaction.getOperation())
                    .execudeOperation(currentQuantity, transaction.getQuantity());
            if (newQuantity < 0) {
                throw new RuntimeException("Quantity can't be less than zero");
            } else {
                fruitDao.add(transaction.getFruit(), newQuantity);
            }
        }

        fileService.writeToFile(pathTo, fruitDao.getDataForReportFile());

    }
}
