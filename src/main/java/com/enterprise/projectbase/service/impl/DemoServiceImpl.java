package com.enterprise.projectbase.service.impl;

import com.enterprise.projectbase.infrastructure.utils.LogStartExecutionTimeEnd;
import com.enterprise.projectbase.persistence.entity.EntityDemo;
import com.enterprise.projectbase.service.DemoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DemoServiceImpl implements DemoService {


    @Override
    @LogStartExecutionTimeEnd
    public EntityDemo demoMethod(EntityDemo entityDemo) {
        // project logic here
        log.info("[DemoServiceImpl.demoMethod]: entity {}", entityDemo);
        return entityDemo;
    }
}
