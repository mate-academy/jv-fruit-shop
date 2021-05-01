package core.basesyntax.Service;

import core.basesyntax.Model.FruitRecordDto;

import  java.util.List;

public interface FruitRecordDtoParse {
   List<FruitRecordDto> parse (List<String> lines);
}
