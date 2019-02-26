package com.hc360.drools.web;

import com.hc360.drools.bean.BaseResult;
import com.hc360.drools.bean.BusinChance;
import com.hc360.drools.service.RulesService;
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

    @Autowired
    private RulesService rulesService;

    @RequestMapping(value = "/score", method = RequestMethod.POST)
    public BaseResult score(@RequestBody BusinChance businChance){

        businChance = rulesService.getBusinScore(businChance, "businChanceScore");

        businChance = rulesService.getBusinScore(businChance, "getBusinStar");

        return BaseResult.isSuccess(businChance);
    }
}

