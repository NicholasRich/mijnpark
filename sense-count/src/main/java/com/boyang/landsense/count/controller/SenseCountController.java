package com.boyang.landsense.count.controller;

import com.boyang.landsense.common.service.LandSenseServ;
import com.boyang.landsense.common.vo.CountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/landsense")
@CrossOrigin
public class SenseCountController {
    @Autowired
    private LandSenseServ landSenseServ;

    @GetMapping("/count/{field}")
    public List<CountVO> listIndicatorVo(@PathVariable("field") String field) {
        return landSenseServ.listSenseCount(field);
    }
}
