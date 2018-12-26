package com.lys.usermanager.until;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李永森[825760990@qq.com]
 * @time 18:03  2017/11/30
 * @describe ajax请求返回数据
 */
public class ResponseDate {

    /**
     * 请求是否成功
     */
    private boolean success;

    /**
     * 请求状态
     */
    private Integer state;

    /**
     * 请求返回信息
     */
    private String msg;

    /**
     * 请求返回数据
     */
    private Object object;

    public ResponseDate(boolean success, Integer state, String msg, Object object) {
        this.success = success;
        this.state = state;
        this.msg = msg;
        this.object = object;
    }

    public static ResponseDate success(Object object) {
        return new ResponseDate(true, 200, "操作成功！", object);
    }

    public static ResponseDate successId(Object id) {
        Map<String, Object> map = new HashMap(1);
        map.put("id", id);
        return new ResponseDate(true, 200, "操作成功！", map);
    }

    public static ResponseDate success(Object object, String msg) {
        return new ResponseDate(true, 200, msg, object);
    }

    public static ResponseDate error(Object object) {
        return new ResponseDate(false, 500, "操作失败！", object);
    }

    public static ResponseDate error(Object object, String msg) {
        return new ResponseDate(false, 500, msg, object);
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
