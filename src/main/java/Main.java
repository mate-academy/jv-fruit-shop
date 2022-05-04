import dao.FruitsDao;
import dao.FruitsDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransferDto;
import service.implementations.BalanceOperationHandlerImpl;
import service.implementations.PurchaseOperationHandlerImpl;
import service.implementations.ReadServiceImpl;
import service.implementations.ReportMakerImpl;
import service.implementations.ReturnOperationHandlerImpl;
import service.implementations.SupplyOperationHandlerImpl;
import service.implementations.TransferServiceImpl;
import service.implementations.ValidateImpl;
import service.implementations.WriteServiceImpl;
import service.inerfaces.OperationHandler;
import service.inerfaces.ReadService;
import service.inerfaces.ReportMaker;
import service.inerfaces.TransferService;
import service.inerfaces.Validate;
import service.inerfaces.WriteService;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    public static final String PATH_FROM = "src/main/java/resources/FileFrom.csv";
    public static final String PATH_WHERE = "src/main/java/resources/FileWhere.csv";

    public static void main(String[] args) {
        ReadService readService = new ReadServiceImpl();
        Validate validator = new ValidateImpl();
        List<String> listOfProducts = readService.readFile(PATH_FROM);
        validator.validate(listOfProducts);
        FruitsDao fruitsDao = new FruitsDaoImpl();
        Map<String, OperationHandler> operationMap = new HashMap<>();
        operationMap.put("b", new BalanceOperationHandlerImpl(fruitsDao));
        operationMap.put("s", new SupplyOperationHandlerImpl(fruitsDao));
        operationMap.put("p", new PurchaseOperationHandlerImpl(fruitsDao));
        operationMap.put("r", new ReturnOperationHandlerImpl(fruitsDao));
        OperationStrategy strategy = new OperationStrategyImpl(operationMap);
        TransferService transferService = new TransferServiceImpl();
        List<FruitTransferDto> dtos = transferService.parse(listOfProducts);
        for (int i = 0; i < dtos.size(); i++) {
            FruitTransferDto dto = dtos.get(i);
            strategy.handle(dto);
        }
        ReportMaker maker = new ReportMakerImpl();
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(PATH_WHERE, maker.formReport());
    }
}
