package cn.itcast.exception;

import cn.itcast.domain.ResponseData;
import org.omg.CORBA.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-15 16:38
 **/
@ControllerAdvice
public class GlobalExceptionHandle {
    //处理自定义类异常
    @ExceptionHandler(SystemException.class)
    public ModelAndView customHandle(SystemException e){
        ModelAndView modelAndView = new ModelAndView();
       // ResponseData.myError(e.getCode,e.getMessage());
        return null;
    }
}
