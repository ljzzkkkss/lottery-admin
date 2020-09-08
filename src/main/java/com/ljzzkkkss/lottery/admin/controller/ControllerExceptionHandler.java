package com.ljzzkkkss.lottery.admin.controller;

import com.ljzzkkkss.lottery.admin.constants.ReturnType;
import com.ljzzkkkss.lottery.admin.model.ReturnBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@ResponseBody
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ReturnBody errorHandle(Exception e){
        logger.error("Request Error",e);
        return ReturnType.SERVER_ERROR;
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ReturnBody errorHandle(HttpRequestMethodNotSupportedException e){
        logger.error("Request Error",e);
        return ReturnType.METHOD_ERROR;
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ReturnBody errorHandle(MissingServletRequestParameterException e){
        logger.error("Request Error",e);
        return ReturnType.PARAM_LEAK;
    }

    @ExceptionHandler(value = MissingServletRequestPartException.class)
    public ReturnBody errorHandle(MissingServletRequestPartException e){
        logger.error("Request Error",e);
        return ReturnType.PARAM_LEAK;
    }
}
