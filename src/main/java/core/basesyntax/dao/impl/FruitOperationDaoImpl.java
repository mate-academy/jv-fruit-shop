package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.io.FileReader;
import core.basesyntax.io.FileWriter;
import core.basesyntax.model.FruitReport;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitOperationDaoImpl implements FruitOperationDao {
    private FileReader fileReader;
    private FileWriter fileWriter;

    public FruitOperationDaoImpl(FileReader fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    @Override
    public List<FruitTransaction> readFile() {
        return fileReader.readFile();
    }

    @Override
    public void writeToFile(List<FruitReport> reports) {
        fileWriter.writeToFile(reports);
    }
}
