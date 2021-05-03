package service.fileservice;

import java.util.List;
import model.dto.FruitRecordDto;

public interface FileParser {
    List<FruitRecordDto> parser(List<String> lines);
}
