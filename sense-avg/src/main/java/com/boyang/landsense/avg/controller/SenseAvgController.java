package com.boyang.landsense.avg.controller;

import com.boyang.landsense.common.service.LandSenseServ;
import com.boyang.landsense.common.vo.AvgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/landsense")
public class SenseAvgController {
    @Autowired
    private LandSenseServ landSenseServ;

    @GetMapping("/avg/{field}")
    public List<AvgVO> listSitePosition(@PathVariable("field")String field) {
        return landSenseServ.listSenseAvg(field);
    }
}
