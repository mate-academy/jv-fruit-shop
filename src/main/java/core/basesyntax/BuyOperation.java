package core.basesyntax;

import java.util.Map;

public class BuyOperation<K, V> implements Operational<K, V> {

    @Override
    public void operation(Transaction transaction, Map<String, Integer> map) {
        if (map.get(transaction.getFruit()) != null) {
            Integer quantity = map.get(transaction.getFruit())
                    - Integer.parseInt(transaction.getQuantity());
            map.put(transaction.getFruit(), quantity);
        } else {
            throw new IllegalArgumentException("Store is empty yet");
        }
    }
}
