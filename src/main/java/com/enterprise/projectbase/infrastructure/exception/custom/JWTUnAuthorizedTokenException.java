package com.enterprise.projectbase.infrastructure.exception.custom;

import com.enterprise.projectbase.infrastructure.exception.EAbstractException;
import com.enterprise.projectbase.infrastructure.exception.EEnumException;

public class JWTUnAuthorizedTokenException extends EAbstractException {
    public JWTUnAuthorizedTokenException() {
        super(EEnumException.UNAUTHORIZED_TOKEN_ERROR.errorCode, EEnumException.UNAUTHORIZED_TOKEN_ERROR.errorDescription);
    }
}
