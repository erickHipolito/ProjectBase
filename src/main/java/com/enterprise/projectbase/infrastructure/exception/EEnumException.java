package com.enterprise.projectbase.infrastructure.exception;

public enum EEnumException {


    PARAMETER_NOT_VALID_ERROR("E-004","Invalid parameters sent with request"),
    UNAUTHORIZED_TOKEN_ERROR("E-008", "Unauthorized token"),
    RSE_INTERNAL_SERVER_ERROR("E-999","Internal server error exception");

    public final String errorCode;
    public final String errorDescription;

    EEnumException(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}


