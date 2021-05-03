package core.basesyntax;

import java.util.List;
import model.dto.FruitRecordDto;
import model.dto.impl.ReadFromFileImpl;
import model.dto.impl.WriteToFileImpl;
import service.fileservice.impl.FileParserImpl;
import service.impl.OperationStrategyImpl;
import storage.Db;

public class Main {
    public static void main(String[] args) {
        List<String> linesFromFile = new ReadFromFileImpl().readFile("Operations.csv");
        List<FruitRecordDto> fruitDtos = new FileParserImpl().parser(linesFromFile);

        for (FruitRecordDto fruitDto : fruitDtos) {
            new OperationStrategyImpl().operation(fruitDto);
        }
        new WriteToFileImpl().writeToFile(Db.getDataBase());
    }
}
