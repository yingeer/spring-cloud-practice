package org.example.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {

    @Bean
    public IRule weightedResponseTimeRule() {
        return new WeightedResponseTimeRule();
    }
}
