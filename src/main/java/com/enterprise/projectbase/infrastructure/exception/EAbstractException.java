package com.enterprise.projectbase.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class EAbstractException extends RuntimeException{
    private final String errorCode;
    private final String errorDescription;
}
