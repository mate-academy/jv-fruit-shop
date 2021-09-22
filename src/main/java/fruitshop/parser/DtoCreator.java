package fruitshop.parser;

import fruitshop.model.RecordDto;
import java.util.List;

public interface DtoCreator {
    List<RecordDto> toDtoDataFormatter(List<String> rawRecords);
}
