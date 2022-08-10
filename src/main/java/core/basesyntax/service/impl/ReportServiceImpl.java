package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(FruitDao fruitDao) {
//        Set<String> fruitNames = new HashSet<>();
//        List<FruitTransaction> fruitsList = fruitDao.getAll();
//
//        for (FruitTransaction fruit : fruitsList) {
//            fruitNames.add(fruit.getFruit());
//        }
//
//        StringBuilder builder = new StringBuilder();
//
//        for (String fruitName : fruitNames) {
//            List<FruitTransaction> oneFruit = fruitsList.stream()
//                    .filter(x -> x.getFruit().equals(fruitName))
//                    .collect(Collectors.toList());
//            int sumQuantity = 0;
//            for (FruitTransaction fruit : oneFruit) {
//                sumQuantity += operationStrategy.get(fruit.getOperation())
//                        .getQuantity(fruit.getQuantity());
//            }
//            builder.append(fruitName).append(",")
//                    .append(sumQuantity).append(System.lineSeparator());
//        }
//        return builder.toString();
        return "";
    }
}
