package com.enterprise.projectbase.application.controller;

import com.enterprise.projectbase.application.dto.request.DemoRequest;
import com.enterprise.projectbase.application.dto.response.DemoResponse;
import com.enterprise.projectbase.application.facade.DemoFacade;
import com.enterprise.projectbase.infrastructure.utils.LogStartExecutionTimeEnd;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/demo")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DemoController {

    private final DemoFacade demoFacade;

    @GetMapping
    @LogStartExecutionTimeEnd
    public ResponseEntity<List<DemoResponse>> getAllDemo() {
        log.info("[DemoController:getAllDemo]");
        return ResponseEntity.ok().body(List.of(demoFacade.getDemo(null)));
    }

    @PostMapping
    @LogStartExecutionTimeEnd
    public ResponseEntity<DemoResponse> createDemo(@RequestBody DemoRequest demoRequest) {
        log.info("[DemoController:createDemo]");
        return ResponseEntity.created(URI.create("/demo")).body(demoFacade.getDemo(demoRequest));
    }

    @PutMapping
    @LogStartExecutionTimeEnd
    public ResponseEntity<DemoResponse> updateDemo(@RequestBody DemoRequest demoRequest) {
        log.info("[DemoController:updateDemo]");
        return ResponseEntity.ok().body(demoFacade.getDemo(demoRequest));
    }

    @DeleteMapping("/{id}")
    @LogStartExecutionTimeEnd
    public ResponseEntity<DemoResponse> deleteDemo(@PathVariable("id") Long id) {
        log.info("[DemoController:deleteDemo]: id: {}", id);
        return ResponseEntity.ok().body(demoFacade.getDemo(null));
    }
}
