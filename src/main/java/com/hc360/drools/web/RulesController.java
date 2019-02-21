package com.hc360.drools.web;

import com.hc360.drools.bean.BusinChance;
import com.hc360.drools.service.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Drools的基本用法，动态规则+决策表
 */
@RequestMapping(value = "/rules")
@RestController
public class RulesController {

    @Autowired
    private RulesService rulesService;

    @RequestMapping(value = "/score", method = RequestMethod.POST)
    public BusinChance score(@RequestBody BusinChance businChance){

        businChance = rulesService.getBusinScore(businChance, "businChanceScore");

        businChance = rulesService.getBusinScore(businChance, "getBusinStar");

        return businChance;
    }
}

