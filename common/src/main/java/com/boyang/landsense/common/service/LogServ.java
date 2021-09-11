package com.boyang.landsense.common.service;

import com.boyang.landsense.common.entity.Log;
import com.boyang.landsense.common.vo.LogVO;

import java.util.List;

public interface LogServ {
    void saveLog(Log log);

    List<LogVO> getLogList();
}
