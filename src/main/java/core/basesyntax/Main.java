package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.operations.OperationConverter;
import core.basesyntax.service.ReadFileService;
import core.basesyntax.service.ReadFileServiceImpl;
import core.basesyntax.service.WriteFileService;
import core.basesyntax.service.WriteFileServiceImpl;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadFileService readFileService = new ReadFileServiceImpl();
        List<FruitDto> fileData = readFileService.readFile("src/resources/fruits.csv");
        OperationConverter operationConverter = new OperationConverter();
        for (FruitDto fruit : fileData) {
            operationConverter.convert(fruit);
        }
        WriteFileService fileWriteService = new WriteFileServiceImpl();
        fileWriteService.writeFile(FruitStore.fruitStorage);
    }
}
