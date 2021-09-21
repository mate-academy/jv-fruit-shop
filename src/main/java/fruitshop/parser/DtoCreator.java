package fruitshop.parser;

import fruitshop.model.OperationsDto;
import java.util.List;

public interface DtoCreator {
    List<OperationsDto> toDtoDataFormatter(List<String> rawRecords);
}
