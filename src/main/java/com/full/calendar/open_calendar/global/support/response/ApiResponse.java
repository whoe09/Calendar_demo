package com.full.calendar.open_calendar.global.support.response;

import com.full.calendar.open_calendar.global.support.error.ErrorMessage;
import com.full.calendar.open_calendar.global.support.error.ErrorType;

public class ApiResponse<S> {
    private final ResponseResultType result;

    private final S data;

    private final ErrorMessage error;

    private ApiResponse(ResponseResultType result, S data, ErrorMessage error) {
        this.result = result;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse<?> success() {
        return new ApiResponse<>(ResponseResultType.SUCCESS, null, null);
    }

    public static <S> ApiResponse<S> success(S data) {
        return new ApiResponse<>(ResponseResultType.SUCCESS, data, null);
    }

    public static ApiResponse<?> error(ErrorType error) {
        return new ApiResponse<>(ResponseResultType.ERROR, null, new ErrorMessage(error));
    }

    public static ApiResponse<?> error(ErrorType error, Object errorData) {
        return new ApiResponse<>(ResponseResultType.ERROR, null, new ErrorMessage(error, errorData));
    }

    public ResponseResultType getResult() {
        return result;
    }

    public Object getData() {
        return data;
    }

    public ErrorMessage getError() {
        return error;
    }
}
