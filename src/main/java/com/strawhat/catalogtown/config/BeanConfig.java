package com.strawhat.catalogtown.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

  @Bean
  public Mapper mapper() {
    return new DozerBeanMapper();
  }
}
