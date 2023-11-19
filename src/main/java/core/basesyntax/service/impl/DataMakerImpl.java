package core.basesyntax.service.impl;

import core.basesyntax.service.DataMaker;

public class DataMakerImpl implements DataMaker {
    private static final String FIRST_LINE = "Fruit,Value";
    private static final int FRUIT_INDEX = 0;
    private static final int QUANTITY_INDEX = 1;

    @Override
    public String getDataToWrite(String report) {
        StringBuilder data = new StringBuilder(FIRST_LINE);
        data.append(System.lineSeparator());
        String[] lines = report.split(System.lineSeparator());
        for (String line : lines) {
            String[] fields = line.split(",");
            data.append(fields[FRUIT_INDEX])
                    .append(",")
                    .append(Integer.parseInt(fields[QUANTITY_INDEX]))
                    .append(System.lineSeparator());
        }
        return data.toString();
    }
}
