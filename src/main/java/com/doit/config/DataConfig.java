package com.doit.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by SahakBabayan on 12/17/2016.
 */
@Configuration
@EntityScan(basePackages = "com.doit.data")
@EnableJpaRepositories(basePackages = "com.doit.data")
@EnableTransactionManagement
public class DataConfig {

}
