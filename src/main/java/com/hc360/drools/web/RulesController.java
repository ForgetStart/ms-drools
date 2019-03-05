package com.hc360.drools.web;

import com.hc360.drools.bean.BaseResult;
import com.hc360.drools.bean.BusinChance;
import com.hc360.drools.bean.ReturnCode;
import com.hc360.drools.service.RulesService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Drools商机算分服务
 */
@RequestMapping(value = "/v1/rules")
@RestController
public class RulesController {

    private static final Log log =  LogFactory.getLog("RulesController");
    @Autowired
    private RulesService rulesService;

    @RequestMapping(value = "/score", method = RequestMethod.POST)
    public BaseResult<BusinChance> score(@RequestBody BusinChance businChance){
        log.info(" *****jie shou request*********");
        BaseResult<BusinChance> result = new BaseResult<>();
        BusinChance scoreResult = new BusinChance();
        try {
            long star = System.currentTimeMillis();
            log.info("&&&&&&&&&&& star score service &&&&&&&&");
            scoreResult = rulesService.getBusinScore(businChance, "businChanceScore");
            scoreResult = rulesService.getBusinScore(scoreResult, "getBusinStar");
            result.setData(scoreResult);
            result.setErrcode(ReturnCode.OK.getErrcode());
            log.info("score service end  time " + (System.currentTimeMillis() - star) + "");
        }catch (Exception e){
            log.error("查询商机分数异常",e);
            result.setErrcode(ReturnCode.ERROR_Exception.getErrcode());
            result.setErrmsg(ReturnCode.ERROR_Exception.getErrmsg());
        }
        return result;
    }
}

