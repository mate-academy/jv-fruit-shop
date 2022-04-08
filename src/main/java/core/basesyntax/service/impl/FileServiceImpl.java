package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileDao;
import core.basesyntax.service.FileService;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {

    private FileDao fileDao = new FileDaoImpl();

    @Override
    public List<FruitTransaction> getData(String filePath) {
        List<String> records = fileDao.getData(filePath);
        return records.stream()
                .skip(1)
                .map(s -> new FruitTransaction(
                        FruitTransaction.Operation.of(s.split(",")[0]),
                        new Fruit(s.split(",")[1]),
                        Integer.parseInt(s.split(",")[2])))
                .collect(Collectors.toList());
    }

    @Override
    public void writeData(String newFileName, List<String> records) {
        fileDao.writeData(newFileName, records);
    }
}
