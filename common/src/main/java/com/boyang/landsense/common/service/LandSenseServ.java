package com.boyang.landsense.common.service;


import com.boyang.landsense.common.vo.AvgVO;
import com.boyang.landsense.common.vo.CountVO;

import java.util.List;

public interface LandSenseServ {
    List<CountVO> listSenseCount(String field);

    List<AvgVO> listSenseAvg(String field);

}
