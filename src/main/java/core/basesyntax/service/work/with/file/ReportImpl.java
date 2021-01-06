package core.basesyntax.service.work.with.file;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportImpl implements Report {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String writeReportToString() {
        FruitDao fruitDao = new FruitDaoImpl();
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        int counter = 0;
        for (Map.Entry<Fruit, Integer> entry : fruitDao.getAllFruits()) {
            report.append(fruitDao.getFruit(entry.getKey().getFruitName())
                    .getFruitName()).append(",")
                    .append(fruitDao.getAmount(entry.getKey().getFruitName()));
            counter++;
            if (counter < fruitDao.getSize()) {
                report.append(System.lineSeparator());
            }
        }
        return report.toString();
    }

    @Override
    public void writeReportToFile(String report, String toFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file", e);
        }
    }
}

