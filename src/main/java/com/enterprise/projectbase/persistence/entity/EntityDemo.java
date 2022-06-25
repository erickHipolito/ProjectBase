package com.enterprise.projectbase.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Table(name = "demo")
public class EntityDemo {

//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @Column(name = "id", unique = true)
//    private Long id;
//

    private String field1;

}
