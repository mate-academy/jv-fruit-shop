package core.basesyntax.mainoperation;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.model.dto.impl.ReadFromFileImpl;
import core.basesyntax.model.dto.impl.WriteToFileImpl;
import core.basesyntax.service.fileservice.impl.FileParserImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.storage.DataBase;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> linesFromFile = new ReadFromFileImpl().readFile("Operations.csv");
        List<FruitRecordDto> fruitDtos = new FileParserImpl().parser(linesFromFile);

        for (FruitRecordDto fruitDto : fruitDtos) {
            new OperationStrategyImpl().operation(fruitDto);
        }
        new WriteToFileImpl().writeToFile(DataBase.getDataBase());
        System.out.println(DataBase.getDataBase().toString());
    }
}
