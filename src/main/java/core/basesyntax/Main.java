package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        Map<String, OperationHandler> operationData = fileService.prepareAndGetOperationData();
        String dataFromFile = fileService.readData();
        String report = fileService.processFruitsData(operationData, dataFromFile);
        fileService.createResultFile(report);
    }
}

