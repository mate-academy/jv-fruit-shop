package service;

import java.util.List;
import model.FruitTransaction;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport(List<FruitTransaction> fruitTransactions) {

        StringBuilder builder = new StringBuilder();
        builder.append(HEADER)
                .append(System.lineSeparator());
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            builder.append(fruitTransaction.getFruit())
                    .append(",")
                    .append(fruitTransaction.getQuantity())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
