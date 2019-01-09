package com.zking.ssm.dict.Controller;

import com.zking.ssm.dict.model.Dict;
import com.zking.ssm.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Dict")
public class DictController {
    @Autowired
    private DictService dictService;
    //根据字典类型查询字典数据
    @RequestMapping("/queryDictForType")
    @ResponseBody
    public List<Dict> queryDictForType(Dict dict){
        List<Dict> dicts = dictService.queryDictForType(dict);

        return dicts;
    }
}
