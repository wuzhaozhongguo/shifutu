package com.xianyu.facade.com.xianyu.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class BaseDTO  implements Serializable {
    public BaseDTO() {
    }

    public String toString() {
        return JSON.toJSONString(this, new SerializerFeature[]{SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect});
    }
}
