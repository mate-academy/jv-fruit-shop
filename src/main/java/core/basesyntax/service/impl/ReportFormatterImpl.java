package core.basesyntax.service.impl;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportFormatter;

import java.util.Map;

public class ReportFormatterImpl implements ReportFormatter {

        @Override
        public String formatReportAsCsvString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fruit,quantity\n");
            for (Map.Entry<Fruit, Integer> entry : Warehouse.getWarehouse().entrySet()) {
                stringBuilder.append(entry.getKey().getName());
                stringBuilder.append(",");
                stringBuilder.append(entry.getValue());
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
    }