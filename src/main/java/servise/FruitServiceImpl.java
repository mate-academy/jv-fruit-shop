package servise;

import dao.TransactionsDao;
import dao.TransactionsDaoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.TransactionService;
import strategy.TransactionStrategy;

public class FruitServiceImpl implements FruitService {
    private static final int OPERATION_VALUE_INDEX = 0;
    private static final int FRUIT_VALUE_INDEX = 1;
    private static final int QUANTITY_VALUE_INDEX = 2;
    private static final String TITLE_STRING_OF_FILE = "type,fruit,quantity";
    private TransactionsDao transactionsDao;
    private FileService fileService;
    private Map<String, Integer> transactionsMap;

    public FruitServiceImpl() {
        this.transactionsDao = new TransactionsDaoImpl();
        this.fileService = new FileServiceImpl();
        this.transactionsMap = new HashMap<>();
    }

    @Override
    public void createReport(String fileName) {
        List<FruitTransaction> transactionList =
                getListOfTransactions(fileService.getDbFromFile(fileName));
        transactionsMap = getMapOfUniqueFruits(transactionList);
        for (FruitTransaction transaction: transactionList) {
            balance(transaction);
        }
        transactionsDao.add(transactionsMap);
        fileService.putDbToFile(transactionsDao.get());
    }

    private List<FruitTransaction> getListOfTransactions(List<String> inputFromFile) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        FruitTransaction transaction;
        for (String input: inputFromFile) {
            if (input.equals(TITLE_STRING_OF_FILE)) {
                continue;
            }
            String[] valueToMath = input.split(",");
            transaction = new FruitTransaction(FruitTransaction.Operation
                    .findOperation(valueToMath[OPERATION_VALUE_INDEX]),
                    valueToMath[FRUIT_VALUE_INDEX],
                    Integer.parseInt(valueToMath[QUANTITY_VALUE_INDEX]));
            fruitTransactionList.add(transaction);
        }
        return fruitTransactionList;
    }

    private Map<String, Integer> getMapOfUniqueFruits(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction: transactions) {
            if (transaction.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
                transactionsMap.put(transaction.getFruit(), transaction.getQuantity());
            }
        }
        return transactionsMap;
    }

    private void balance(FruitTransaction transaction) {
        TransactionStrategy strategy = new TransactionStrategy();
        TransactionService transactionService =
                strategy.getTransactionService(transaction.getOperation());
        for (Map.Entry<String, Integer> entry: transactionsMap.entrySet()) {
            if (entry.getKey().equals(transaction.getFruit())) {
                entry.setValue(transactionService
                        .dayResult(entry.getValue(), transaction.getQuantity()));
            }
        }
    }
}
