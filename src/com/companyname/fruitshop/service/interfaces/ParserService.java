package com.companyname.fruitshop.service.interfaces;

import com.companyname.fruitshop.model.dto.FruitRecordDto;

public interface ParserService {
    FruitRecordDto parse (String line);
}
