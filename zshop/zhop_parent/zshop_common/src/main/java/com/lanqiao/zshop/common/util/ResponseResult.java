package com.lanqiao.zshop.common.util;

import com.lanqiao.zshop.common.constant.ResponseStatusConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 响应结果
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult {

    //状态码
    private int status;
    //消息
    private String message;
    //返回数据
    private Object data;

    //成功
    public static ResponseResult success(Object data){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS,"success",data);
    }
    public static ResponseResult success(String message){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS,message,null);
    }
    public static ResponseResult success(){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS,"success",null);
    }

    //失败
    public static ResponseResult fail(Object data){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_FAIL,"fail",data);
    }
    public static ResponseResult fail(String message){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_FAIL,message,null);
    }
}
