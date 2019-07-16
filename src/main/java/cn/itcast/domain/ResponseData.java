package cn.itcast.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-15 16:43
 **/
public class ResponseData {
   private final String message;
   private final int code;
    private final Map<String,Object> data = new HashMap<>();

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Map<String, Object> getData() {
        return data;
    }
    public ResponseData putData(String key,Object value){
        data.put(key,value);
        return this;
    }
    private ResponseData(int code,String message){
        this.code = code;
        this.message = message;

    }
}
