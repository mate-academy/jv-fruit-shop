package core.basesyntax;

import static core.basesyntax.model.TypeOfOperation.b;
import static core.basesyntax.model.TypeOfOperation.p;
import static core.basesyntax.model.TypeOfOperation.r;
import static core.basesyntax.model.TypeOfOperation.s;

import core.basesyntax.filereader.FileReaderService;
import core.basesyntax.filereader.FileReaderServiceImpl;
import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.raportcreator.ReportCreator;
import core.basesyntax.raportcreator.ReportCreatorImpl;
import core.basesyntax.typeofoperationhandler.BalanceService;
import core.basesyntax.typeofoperationhandler.PurchaseService;
import core.basesyntax.typeofoperationhandler.ReturnService;
import core.basesyntax.typeofoperationhandler.SupplyService;
import core.basesyntax.typeofoperationhandler.TypeOfOperationService;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not
    // write any business logic in the `main` method!

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        fileReaderService.readFromCsvFile();
        Map<TypeOfOperation, TypeOfOperationService>
                typeOfOpeAndTypeOfOpeHandlerMap = new HashMap<>();
        TypeOfOperationService balanceHandler = new BalanceService();
        typeOfOpeAndTypeOfOpeHandlerMap.put(b, balanceHandler);
        TypeOfOperationService supplyHandler = new SupplyService();
        typeOfOpeAndTypeOfOpeHandlerMap.put(s, supplyHandler);
        TypeOfOperationService returnHandler = new ReturnService();
        typeOfOpeAndTypeOfOpeHandlerMap.put(r, returnHandler);
        TypeOfOperationService purchaseHandler = new PurchaseService();
        typeOfOpeAndTypeOfOpeHandlerMap.put(p, purchaseHandler);
        ReportCreator reportCreator = new ReportCreatorImpl();
        reportCreator.createReport();
    }
}
