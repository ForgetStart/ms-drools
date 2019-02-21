package com.hc360.drools.service;


import com.hc360.drools.bean.BusinChance;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * fengda
 * 2019年2月19日17:24:45
 * 利用drools计算商机分数
 */
@Service
public class RulesService {

    public BusinChance getBusinScore(BusinChance businChance, String ksessionName){
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);
        ksession.insert(businChance);
        ksession.fireAllRules();
        ksession.dispose();
        return businChance;
    }

}
