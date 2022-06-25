package com.enterprise.projectbase.application.facade;

import com.enterprise.projectbase.application.mapper.DemoMapper;
import com.enterprise.projectbase.application.dto.request.DemoRequest;
import com.enterprise.projectbase.application.dto.response.DemoResponse;
import com.enterprise.projectbase.infrastructure.utils.LogStartExecutionTimeEnd;
import com.enterprise.projectbase.service.DemoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DemoFacade {

    private final DemoService demoService;
    private final DemoMapper demoMapper;

    @LogStartExecutionTimeEnd
    public DemoResponse getDemo(DemoRequest demoRequest) {
        log.info("[DemoFacade.getDemo] request: {}", demoRequest);
        return demoMapper.toDto(demoService.demoMethod(demoMapper.toEntity(demoRequest)));
    }



}
