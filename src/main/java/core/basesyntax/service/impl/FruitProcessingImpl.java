package core.basesyntax.service.impl;

import core.basesyntax.service.FruitDao;
import core.basesyntax.service.FruitProcessing;

import java.math.BigDecimal;
import java.util.List;

public class FruitProcessingImpl implements FruitProcessing {
    private static final String DELIMITER_REGEX = ",";
    private static final int FRUIT_NAME_INDEX = 1;


    @Override
    public void fruitProcessing(String fileName) {
        FruitDao fruitDao = new FruitDaoImpl();
        List<String> fruitsForProcessing = fruitDao.getInputData(fileName);
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        while (fruitsForProcessing.size() != 1) {
            String[] fruitName = fruitsForProcessing.get(1).split(DELIMITER_REGEX);
            int balance = 0;

            List<String> oneTypeFruit = fruitsForProcessing.stream()
                    .filter(fr -> fr.contains(fruitName[FRUIT_NAME_INDEX]))
                    .toList();

            for (String fruit: oneTypeFruit) {
                String[] getQuantity = fruit.split(DELIMITER_REGEX);
                if (getQuantity[0].contains("s") || getQuantity[0].contains("r")) {
                    balance += Integer.parseInt(getQuantity[2]);
                } else if (getQuantity[0].contains("p")) {
                    balance -= Integer.parseInt(getQuantity[2]);
                } else if (getQuantity[0].contains("b")) {
                    balance = Integer.parseInt(getQuantity[2]);
                }
            }
            fruitsForProcessing.removeAll(oneTypeFruit);
            report.append(fruitName[FRUIT_NAME_INDEX]).append(",")
                    .append(balance)
                    .append(System.lineSeparator());
        }
        fruitDao.sendResultData(report.toString());
    }
}
