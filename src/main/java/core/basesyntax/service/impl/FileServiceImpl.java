package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParser;
import core.basesyntax.service.FileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    private static final String INPUT_HEADER = "type,fruit,quantity";
    private FileParser fileParser;

    public FileServiceImpl(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    @Override
    public List<FruitTransaction> readFile(String fileName) {
        List<String> data;

        try {
            data = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from the file " + fileName);
        }

        return data.stream()
                .filter(line -> !line.equals(INPUT_HEADER))
                .map(fileParser::parseData)
                .map(line -> new FruitTransaction(
                        FruitTransaction.Operation.fromCode(line[0]),
                        line[1],
                        Integer.parseInt(line[2])
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void writeToFile(String fileName, String data) {
        try {
            Files.writeString(Path.of(fileName), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + fileName);
        }
    }
}
