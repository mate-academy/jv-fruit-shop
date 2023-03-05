package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    @Override
    public void writeReport(String fileName, Fruit[] fruits) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(fruitToReport(fruits));
        } catch (IOException e) {
            throw new RuntimeException("Can`t put data to file!" + fileName,e);
        }
    }

    private String fruitToReport(Fruit[] fruits) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Fruit element: fruits) {
            stringBuilder.append(element.getFruit()).append(",")
                    .append(element.getQuantity()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
