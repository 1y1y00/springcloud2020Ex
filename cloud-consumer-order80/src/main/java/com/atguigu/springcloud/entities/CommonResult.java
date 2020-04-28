package com.atguigu.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * json封装实体
 * 给前端一个良好的显示和提示，返回前端通用的json串
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

//    类似404的编码异常
    private Integer code;
//    提示错误消息
    private String message;
//    返回数据
    private T data;

//    有可能data是null所以 我们自定义 一个两个参数的
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
