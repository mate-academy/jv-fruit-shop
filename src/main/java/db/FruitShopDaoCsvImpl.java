package db;

import model.FruitTransaction;
import storage.Storage;
import strategy.FruitStrategy;

public class FruitShopDaoCsvImpl implements FruitShopDao {
    private FruitStrategy fruitStrategy;

    public FruitShopDaoCsvImpl(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        if (!Storage.transactions.contains(fruitTransaction)) {
            Storage.transactions.add(fruitTransaction);
            return;
        }
        update(fruitTransaction);
    }

    @Override
    public void update(FruitTransaction fruitTransaction) {

    }
}























//    private Account getFromCsvRow(String line) {
//        String[] fields = line.split(",");
//        Account account = new Account();
//        account.setAccountNumber(fields[0]);
//        account.setAmount(new BigDecimal(fields[1]));
//        account.setType(Account.Type.valueOf(fields[2]));
//        return account;
//    }



