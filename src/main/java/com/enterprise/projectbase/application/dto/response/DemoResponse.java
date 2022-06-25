package com.enterprise.projectbase.application.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//los import deben estar sin el .*

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL) // ignorar campos que estan nulos y no mostrarlos
public class DemoResponse {

    private String test1;
    private String test2;
    private String test3;
    private String test4;
}
