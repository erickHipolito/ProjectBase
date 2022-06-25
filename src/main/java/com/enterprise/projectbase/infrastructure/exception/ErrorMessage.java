package com.enterprise.projectbase.infrastructure.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
	private String errorDescription;
	private String errorCode;
	private Date timestamp;
}
