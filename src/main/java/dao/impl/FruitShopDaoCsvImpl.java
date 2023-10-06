package dao.impl;

import dao.FruitShopDao;
import java.util.List;
import model.FruitTransaction;
import service.ActivitiesStrategy;
import service.ReaderFileService;

public class FruitShopDaoCsvImpl implements FruitShopDao {
    private ActivitiesStrategy activitiesStrategy;
    private ReaderFileService readerFileService;

    public FruitShopDaoCsvImpl(ActivitiesStrategy activitiesStrategy,
                               ReaderFileService readerFileService) {
        this.activitiesStrategy = activitiesStrategy;
        this.readerFileService = readerFileService;
    }

//    @Override
//    public void add(FruitTransaction fruitTransaction) {
//        FruitShop.fruitShop.add(fruitTransaction);
//        activitiesStrategy.get(fruitTransaction.getOperation())
//                .executeTransaction(fruitTransaction);
//    }
//
//    @Override
//    public FruitTransaction get(String fruit) {
//        List<String> fruitList;
//        fruitList = readerFileService.readFromFile();
//        return fruitList.stream()
//                .filter(line -> line.startsWith(fruit,1))
//                        .map(this::getFromCvsRow)
//                        .findFirst()
//                        .get();
//    }
//
//    @Override
//    public List<FruitTransaction> getAll() {
//        return FruitShop.fruitShop;
//    }

    public void processTransactions(List<String> transactionLines) {
        for (int i = 1; i < transactionLines.size(); i++) {
            FruitTransaction fruitTransactionFromCvsRow = getFromCvsRow(transactionLines.get(i));
            activitiesStrategy.get(fruitTransactionFromCvsRow
                            .getOperation())
                    .executeTransaction(fruitTransactionFromCvsRow);
        }
    }

    private FruitTransaction getFromCvsRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        String operationCode = fields[0].trim();
        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(operationCode);

        fruitTransaction.setOperation(operation);
        //fruitTransaction.setOperation(FruitTransaction.Operation.valueOf(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }
}
