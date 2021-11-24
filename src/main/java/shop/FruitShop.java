package shop;

import java.util.HashMap;
import java.util.List;
import shop.model.ActionType;
import shop.service.Reader;
import shop.service.UpdateDbService;
import shop.service.Validator;
import shop.service.Writer;
import shop.service.action.ActionHandler;
import shop.service.action.DecreaseActionHandler;
import shop.service.action.IncreaseActionHandler;
import shop.service.impl.CsvReaderImpl;
import shop.service.impl.CsvWriterImpl;
import shop.service.impl.UpdateDbServiceImpl;
import shop.service.impl.ValidatorImpl;

public class FruitShop {
    private static final String INPUT_FILE_NAME = "src\\main\\resources\\input.csv";
    private static final String OUTPUT_FILE_NAME = "src\\main\\resources\\output.csv";

    public static void main(String[] args) {
        HashMap<String, ActionHandler> actionMap = new HashMap<>();
        actionMap.put(ActionType.BALANCE.getAlias(), new IncreaseActionHandler());
        actionMap.put(ActionType.SUPPLY.getAlias(), new IncreaseActionHandler());
        actionMap.put(ActionType.RETURN.getAlias(), new IncreaseActionHandler());
        actionMap.put(ActionType.PURCHASE.getAlias(), new DecreaseActionHandler());

        UpdateDbService updateDbService = new UpdateDbServiceImpl(actionMap);
        Reader reader = new CsvReaderImpl();
        Writer writer = new CsvWriterImpl();
        Validator validator = new ValidatorImpl();

        List<String> parsedData = reader.read(INPUT_FILE_NAME);
        if (validator.valid(parsedData)) {
            updateDbService.updateStorage(parsedData);
            writer.write(OUTPUT_FILE_NAME);
        }
    }

}
