package com.callsign.customer.support.exception;

import lombok.Data;

/**
 * @author Shadab Khan
 * @since 16/01/2022
 */
@Data
public class ErrorResponse {
    private ErrorCode errorCode;
    private String errorMessage;
}
