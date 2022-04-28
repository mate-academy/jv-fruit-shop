package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportCreator;
import java.util.List;

public class ReportCreatorImpl implements ReportCreator {

    @Override
    public String createReport(List<FruitTransaction> fruitTransactions) {

        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity")
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
