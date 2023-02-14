package core.basesyntax.service.parser;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.entity.FruitTransaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {

    public static final int ACTIVITY_POSITION = 0;
    public static final int FRUIT_POSITION = 1;
    public static final int QUANTITY_POSITION = 2;
    private final FruitsDao fruitsDao;

    public TransactionParserImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    public void parse(List<String> str, String nameFruit) {
        BigDecimal bigDecimal = new BigDecimal(0);
        List<FruitTransaction> result = new ArrayList<>();
        Map<String, List<FruitTransaction>> mapFruits = processingStringList(str).stream()
                .filter(t -> t.getFruit()
                        .equalsIgnoreCase(nameFruit.trim()))
                .collect(Collectors.groupingBy(FruitTransaction::getActivity));
        for (Map.Entry<String, List<FruitTransaction>> map : mapFruits.entrySet()) {
            for (int i = 0; i < map.getValue().size(); i++) {
                bigDecimal = bigDecimal.add(map.getValue().get(i).getQuantity());
            }
            FruitTransaction fruit = new FruitTransaction();
            fruit.setFruit(nameFruit);
            fruit.setActivity(map.getKey());
            fruit.setQuantity(bigDecimal);
            result.add(fruit);
            fruitsDao.addFruitsStorage(fruit);
            bigDecimal = new BigDecimal(0);
        }
    }

    private List<FruitTransaction> processingStringList(List<String> str) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String d : str) {
            String[] split = d.split(",");
            if (d.trim().matches("\\w{1},[a-z]*,\\d*")) {
                FruitTransaction fruitTransaction = new FruitTransaction();
                String activity = split[ACTIVITY_POSITION];
                String fruit = split[FRUIT_POSITION];
                BigDecimal quantity = BigDecimal.valueOf(Long.parseLong(split[QUANTITY_POSITION]));
                fruitTransaction.setActivity(activity.trim());
                fruitTransaction.setFruit(fruit.trim());
                fruitTransaction.setQuantity(quantity);
                fruitTransactionList.add(fruitTransaction);
            }
        }
        return fruitTransactionList;
    }
}

