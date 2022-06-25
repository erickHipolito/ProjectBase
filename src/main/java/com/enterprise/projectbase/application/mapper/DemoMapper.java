package com.enterprise.projectbase.application.mapper;

import com.enterprise.projectbase.application.dto.request.DemoRequest;
import com.enterprise.projectbase.application.dto.response.DemoResponse;
import com.enterprise.projectbase.persistence.entity.EntityDemo;
import org.springframework.stereotype.Component;

@Component
public class DemoMapper {

    public DemoResponse toDto(EntityDemo entityDemo){
        return DemoResponse.builder()
                .test1(entityDemo.getField1())
                .build();
    }

    public EntityDemo toEntity(DemoRequest demoRequest){
        return EntityDemo.builder()
                .field1(demoRequest.getTest1())
                .build();
    }
}
