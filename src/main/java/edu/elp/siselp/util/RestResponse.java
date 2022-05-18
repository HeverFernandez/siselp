package edu.elp.siselp.util;

/**
 * Created by airo on 24/10/2019.
 */

public class RestResponse {

    private Integer code;
    private String message;
    private Object data;

    public RestResponse(Integer code) {
        super();
        this.code = code;
    }

    public RestResponse(String message) {
        this.message = message;
    }

    public RestResponse(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public RestResponse(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public RestResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
