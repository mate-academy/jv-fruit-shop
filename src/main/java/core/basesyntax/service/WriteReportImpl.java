package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteReportImpl implements WriteReport {
    @Override
    public void writeReport(List<Fruit> inputList) {
        String newFileName = "fileReport.csv";
        File fileReport = new File(newFileName);
        try {
            fileReport.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create a new file!");
        }
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(newFileName));
            bufferedWriter.write("fruit,quantity" + System.lineSeparator());
            for (Fruit fruit : inputList) {
                bufferedWriter.write(fruit.getName() + "," + fruit.getAmount()
                        + System.lineSeparator());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
