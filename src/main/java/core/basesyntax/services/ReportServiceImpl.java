package core.basesyntax.services;

import core.basesyntax.dao.TransactionsDao;
import core.basesyntax.dao.TransactionsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private TransactionsDao transactionsDao;
    private FruitService fruitService;
    private BalanceService balanceService;
    private ReadFromFileService readFromFileService;
    private WriteToFileService writeToFileService;

    public ReportServiceImpl() {
        this.transactionsDao = new TransactionsDaoImpl();
        this.fruitService = new FruitServiceImpl();
        this.balanceService = new BalanceServiceImpl();
        this.readFromFileService = new ReadFromFileServiceImpl();
        this.writeToFileService = new WriteToFileServiceImpl();
    }

    public void createReport(String inputFileName, String reportFileName) {
        List<FruitTransaction> fruitTransactionList = fruitService
                .getListOfTransactions(readFromFileService.getDbFromFile(inputFileName));
        fruitService.getMapOfUniqueFruits(fruitTransactionList);
        balanceService.balance(fruitTransactionList);
        writeToFileService.putDbToFile(transactionsDao.get(), reportFileName);
    }
}
