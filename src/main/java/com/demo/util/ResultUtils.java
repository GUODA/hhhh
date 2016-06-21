package com.demo.util;

import java.util.Collection;

/**
 * ClassName: ResultUtils
 * Description: 返回结果定义
 *
 * @author kang.wang03
 *         Date 16/2/4
 */
public class ResultUtils {
    public static int LOGINOUT_CODE = -100;//未登录
    public static int ERROR_CODE = -101;//一般错误;
    public static int SYSTEM_ERROR = -102;//系统错误
    public static int SUCCESS_CODE = 200;//正常返回状态
    public static ObjectResult ToObjectResult(Object object, int code, String msg) {
        return new ObjectResult(msg, object, code);
    }

    public static ObjectResult ToObjectResult(Object object) {
        return new ObjectResult(object);
    }

    /**
     * @param totalCount 总共数量
     * @param page       当前页数
     * @param data       数据集合
     * @param count      请求数量
     * @return
     */
    public static PageResult toPageResult(int totalCount, int page, Collection data, int count) {
        return new PageResult(totalCount, page, data, count);
    }

    public static class PageResult {
        private int totalCount;//数据总数量
        private int page;//当前页数
        private int count;//当前数量
        private Collection datas;
        private int code = SUCCESS_CODE;
        private String msg;

        public PageResult(int totalCount, int page, Collection datas, int count) {
            this.totalCount = totalCount;
            this.page = page;
            this.datas = datas;
            this.count = count;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Collection getDatas() {
            return datas;
        }

        public void setDatas(Collection datas) {
            this.datas = datas;
        }
    }

    public static class ObjectResult {
        private Object data;
        private int code = 200;
        private String msg;
        public ObjectResult(){}
        public ObjectResult(Object data) {
            this.data = data;
        }

        public ObjectResult(String msg, Object data, int code) {
            this.msg = msg;
            this.data = data;
            this.code = code;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
