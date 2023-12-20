package core.basesyntax.service.file;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.convertator.DataConvertor;
import core.basesyntax.service.convertator.DataConvertorImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderHandlerImpl implements FileReaderHandler {
    private static final String FILE_PATH = "fruitsRaport.csv";
    private final StorageDao storageDao = new StorageDaoImpl();
    private final DataConvertor dataConvertor = new DataConvertorImpl();

    @Override
    public void readFromFile() {
        boolean firstLine = true;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String fruitInfo = bufferedReader.readLine();

            while (fruitInfo != null) {
                if (firstLine) {
                    firstLine = false;
                    fruitInfo = bufferedReader.readLine();
                    continue;
                }
                storageDao.add(dataConvertor.convertData(fruitInfo));
                fruitInfo = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + FILE_PATH);
        }
    }

}
