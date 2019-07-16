package cn.itcast.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-15 13:16
 **/
@ControllerAdvice
public class MyExceptionResolver  {
    @ExceptionHandler(Exception.class)
   public String myException(Exception e){
       return "error";
   }
}
