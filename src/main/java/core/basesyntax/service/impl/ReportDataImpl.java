package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTranzactionDao;
import core.basesyntax.dao.impl.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportData;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportDataImpl implements ReportData {
    private static final String COMMA = ",";
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private final FruitTranzactionDao fruitTranzactionDao = new FruitTransactionDaoImpl();
    private final OperationStrategy operationStrategy = new OperationStrategyImpl();
    
    @Override
    public String generateReport() {
        List<String> fruitName = getFruitName();
        
        StringBuilder reportData = new StringBuilder()
                .append(FRUIT)
                .append(COMMA)
                .append(QUANTITY);
        int balance = 0;
        
        for (String name : fruitName) {
            for (int i = 0; i < fruitTranzactionDao.getSizeStorage(); i++) {
                if (fruitTranzactionDao.get(i).getFruit().equals(name)) {
                    FruitTransaction transaction = fruitTranzactionDao.get(i);
                    balance = operationStrategy.get(transaction.getOperation())
                            .calculationData(balance, transaction);
                }
            }
            reportData.append(System.lineSeparator())
                    .append(name)
                    .append(COMMA)
                    .append(balance);
        }
        return reportData.toString();
    }
    
    private List<String> getFruitName() {
        List<String> newFruitName = new ArrayList<>();
        for (int i = 0; i < fruitTranzactionDao.getSizeStorage(); i++) {
            newFruitName.add(fruitTranzactionDao.get(i).getFruit());
        }
        return newFruitName.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
