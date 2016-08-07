package org.dragons.core.response;

public class GetWeatherResponse {

    private String time;
    private String code;
    private String message;

    public String getTime() {
        return time;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "GetWeatherResponse{" +
                "time=" + time
                + ", code=" + code
                + ", message=" + message
                + '}';
    }
}


