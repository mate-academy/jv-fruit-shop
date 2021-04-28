package service.interfaces;

import java.util.List;
import service.FruitRecordParserImpl;

public interface FruitRecordParser {
    List<FruitRecordParserImpl> parseLines(List<String> fileContent);
}
