package core.basesyntax.shop.impl;

import core.basesyntax.shop.ReadFromFile;
import core.basesyntax.shop.WriteToFile;
import core.basesyntax.shop.strategy.FileReadStrategy;
import core.basesyntax.shop.strategy.FileWriteStrategy;
import java.util.Map;

public class Report {
    private ParseData parseData;
    private ReadFromFile readFromFile;
    private WriteToFile writeToFile;

    public Report() {
        parseData = new ParseData();
    }

    public boolean createReport(String fromFilename, String toFilename) {
        readFromFile = FileReadStrategy.chooseReadFileFormat(fromFilename);
        writeToFile = FileWriteStrategy.chooseWriteFileFormat(toFilename);
        Map<String, Integer> map = parseData.parse(fromFilename, readFromFile);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return writeToFile.write(toFilename, stringBuilder.toString());
    }
}
