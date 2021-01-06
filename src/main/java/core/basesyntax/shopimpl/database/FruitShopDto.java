package core.basesyntax.shopimpl.database;

import core.basesyntax.model.shopdao.ShopDto;
import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitShopDto implements ShopDto<DataRecord> {
    private final List<DataRecord> transactionHistory = new ArrayList<>();
    
    @Override
    public List<DataRecord> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
    
    @Override
    public List<DataRecord> getItemTransactionHistory(String item) {
        return transactionHistory.stream()
                .filter(data -> data.getItem().getItemName().equalsIgnoreCase(item))
                .collect(Collectors.toList());
    }
    
    @Override
    public void addTransaction(DataRecord action) {
        transactionHistory.add(action);
    }
    
    @Override
    public void addAll(List<DataRecord> lines) {
        transactionHistory.addAll(lines);
    }
    
    public void addAction(ShopTransactionsType action, String item, Integer amount) {
        transactionHistory.add(new DataRecord(action, new Fruit(item), amount));
    }
}
