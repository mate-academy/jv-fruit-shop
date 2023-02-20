package core.basesyntax.service.nio;

import core.basesyntax.dao.FruitsDao;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    private FruitsDao fruitsDao;

    public FileServiceImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public List<String> read(String pathFromRepository) {
        try {
            List<String> collect = Files.readAllLines(Path.of(pathFromRepository)).stream()
                    .collect(Collectors.toList());
            return collect;
        } catch (IOException e) {
            throw new RuntimeException("is not correct file " + e);
        }
    }

    @Override
    public void write(String path) {
        fruitsDao.getAllFruits().forEach(t -> {
            try {
                Files.write(Path.of(path), t.replace(" ", ",")
                                .concat("\n").getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("is not correct url... " + e);
            }
        });
    }
}
