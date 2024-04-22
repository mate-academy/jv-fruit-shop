package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<String> solveReport(String filePath) {
        FruitDao fruitDao = new FruitDaoImpl();
        File fileInput = new File(filePath);
        List<String> readFromFile;
        try {
            readFromFile = Files.readAllLines(fileInput.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read fileInput: " + fileInput.getName());
        }
        for (int i = 1; i < readFromFile.size(); i++) {
            if (fruitDao.getFruit(readFromFile.get(i)) == null) {
                fruitDao.addFruit(readFromFile.get(i));
            } else {
                fruitDao.upDateAMount(readFromFile.get(i));
            }
        }
        return null;
    }
}
