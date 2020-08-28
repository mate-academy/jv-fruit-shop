package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.operations.OperationConverter;
import core.basesyntax.service.ReadFileService;
import core.basesyntax.service.ReadFileServiceImpl;
import core.basesyntax.service.WriteFileService;
import core.basesyntax.service.WriteFileServiceImpl;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path: ");
        String path = scanner.nextLine();
        ReadFileService readFileService = new ReadFileServiceImpl();
        List<TransactionDto> fileData = readFileService.readFile(path);
        OperationConverter operationConverter = new OperationConverter();
        for (TransactionDto fruit : fileData) {
            operationConverter.convert(fruit);
        }
        WriteFileService fileWriteService = new WriteFileServiceImpl();
        fileWriteService.writeFile(FruitStore.fruitStorage);
    }
}
