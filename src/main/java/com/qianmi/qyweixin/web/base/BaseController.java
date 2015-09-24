package com.qianmi.qyweixin.web.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础controller
 *
 * @author 李贺[of253]
 * @date 2013-12-7 下午2:24:15
 */
public class BaseController implements ApplicationContextAware {

    /**
     * 系统日志配置
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected ApplicationContext ac;

    /**
     * The action execution was a failure.
     */
    public static final String ERROR = "error/error";

    /**
     * 转到error/error页面时,model里面存储的错位信息的键
     */
    public static final String ERRORKEY = "errorMsg";
    /**
     * 其它未知异常
     */
    public static final String UNKOWNEXCEPTION = "请求失败";
    /**
     * 更新数据失败
     */
    public static final String UPD_DATA_FAIL = "更新数据失败";

    /**
     * 成功编码
     */
    public static final int SUC_CODE = 200;
    /**
     * 失败编码
     */
    public static final int FAIL_CODE = 201;
    /**
     * result
     */
    public static final String RESULT = "result";
    /**
     * msg
     */
    public static final String MSG = "msg";
    /**
     * data
     */
    public static final String DATA = "data";



    /**
     * 信息获取的途径
     *
     * @param request
     * @return
     * @author 李贺[of253]
     * @date 2013-12-9 上午10:29:13
     */
    protected HttpSession getSession(HttpServletRequest request) {
        return request.getSession(true);
    }


    /**
     * 描述：获取返回结果 创建人：fengsen 创建时间：2012-8-22 备注：
     *
     * @param isOk
     * @param resCode
     * @param errorMsg
     * @return
     */
    protected Map<String, Object> getResult(boolean isOk, int resCode, String errorMsg, Object obj) {
        return createJson(isOk, resCode, errorMsg, obj);
    }

    /**
     * 描述：获取成功结果 创建人：fengsen 创建时间：2012-8-22 备注：
     *
     * @return
     */
    protected Map<String, Object> getSuccessResult(Object obj) {
        return getResult(true, SUC_CODE, "操作成功", obj);
    }

    /**
     * 成功并指定信息
     *
     * @param msg
     * @return
     * @author 李贺[of253]
     * @date 2013-12-9 上午10:22:26
     */
    protected Map<String, Object> getSuccessResult(String msg) {
        return getResult(true, SUC_CODE, msg, Collections.EMPTY_MAP);
    }

    /**
     * 成功
     *
     * @return
     * @author 李贺[of253]
     * @date 2013-12-9 上午10:22:39
     */
    protected Map<String, Object> getSuccessResult() {
        return getResult(true, SUC_CODE, "操作成功！", Collections.EMPTY_MAP);
    }

    /**
     * 描述：获取失败结果 创建人：fengsen 创建时间：2012-8-22 备注：
     *
     * @param msg
     * @return
     */
    protected Map<String, Object> getFailResult(String msg) {
        return getResult(false, FAIL_CODE, msg, Collections.EMPTY_MAP);
    }

    /**
     * 描述：组装json格式返回结果 创建人：fengsen 创建时间：2012-8-22 备注：
     *
     * @param isOk
     * @param resCode
     * @param errorMsg
     * @param obj
     * @return
     */
    protected Map<String, Object> createJson(boolean isOk, int resCode, String errorMsg, Object obj) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESULT, isOk ? "ok" : "fail");
        jsonMap.put("rescode", resCode);
        jsonMap.put(MSG, errorMsg);
        jsonMap.put(DATA, obj);
        return jsonMap;
    }

    /**
     * 获取dataTables需要的数据格式
     *
     * @param totalCount 总数目
     * @param dataList   数据列表
     * @return Map<String,Object> 返回类型
     * @throws
     * @Title: dataTableJson
     * @author zengxiaoyong_of426
     * @date 2012-7-23上午7:43:04
     * @since CodingExample　Ver(编码范例查看) 1.1
     */
    protected Map<String, Object> dataTableJson(int totalCount, List<?> dataList) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("iTotalDisplayRecords", totalCount);
        data.put("iTotalRecords", totalCount);
        data.put("aaData", dataList == null ? Collections.EMPTY_LIST : dataList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(DATA, data);
        map.put(RESULT, "ok");
        return map;
    }

    /**
     * 描述：获取FORM验证错误信息 创建人：fengsen 创建时间：2012-8-23 备注：
     *
     * @param result
     * @return
     */
    protected Map<String, Object> getBadParamResult(BindingResult result) {
        String msg = "参数校验错误";
        List<FieldError> list = result.getFieldErrors();
        if (list != null && !list.isEmpty()) {
            msg = list.get(0).getDefaultMessage();
        }
        return getResult(false, FAIL_CODE, msg, Collections.EMPTY_MAP);
    }

    /**
     * 字符串返回
     *
     * @param data
     * @return
     */
    protected String ok(String data) {
        JSONObject json = new JSONObject();
        json.put(RESULT, "ok");
        json.put(DATA, data);
        return json.toJSONString();
    }

    /**
     * 字符串返回
     *
     * @param msg
     * @return
     */
    protected String fail(String msg) {
        JSONObject json = new JSONObject();
        json.put(RESULT, "fail");
        json.put(MSG, msg);
        return json.toJSONString();
    }

    /**
     * ajax返回失败
     *
     * @param resCode
     * @return
     */
    protected Map<String, Object> ajaxFail(boolean isOk, String resCode, String errorMsg, Object obj) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESULT, isOk ? "ok" : "fail");
        jsonMap.put("rescode", resCode);
        jsonMap.put(MSG, errorMsg);
        jsonMap.put(DATA, obj);
        return jsonMap;
    }


    /**
     * 获取会话作用域.
     *
     * @return
     * @author 高金[of706]
     * @date 2013年12月4日 上午10:40:27
     */
    protected HttpSession sessionContext() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(false);
    }

    /**
     * 获取请求作用域.
     *
     * @return
     * @author 高金[of706]
     * @date 2013年12月4日 上午10:40:12
     */
    protected HttpServletRequest requestContext() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取application作用域.
     *
     * @return
     * @author 高金[of706]
     * @date 2013年12月4日 上午10:39:39
     */
    protected ServletContext applicationContext() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                .getSession(false);
        if (null != session) {
            return session.getServletContext();
        }
        return null;
    }

    /**
     * 根据相对路径获取资源绝对路径.
     *
     * @param path
     * @return
     * @author 高金[of706]
     * @date 2013年12月4日 上午10:37:51
     */
    protected String getRealPath(String path) {
        ServletContext app = applicationContext();
        if (null != app) {
            String root = app.getRealPath(String.valueOf(File.separatorChar));
            return root + path;
        }
        return path;
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.ac = applicationContext;

    }


    /**
     *
     * @param msg
     * @param resp
     */
    protected void write2String(String msg, HttpServletResponse resp) {
        PrintWriter pw = null;
        try {
            if (!resp.isCommitted()) {
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("text/html; charset=utf-8");
                pw = resp.getWriter();
                pw.write(msg);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            if (null != pw) {
                pw.flush();
                pw.close();
            }
        }
    }

    protected void write2String(Map<String, Object> map, HttpServletResponse resp) {
        String result = "";
        if (null != map) {
            result = JSON.toJSONString(map);
        }
        PrintWriter pw = null;
        try {
            if (!resp.isCommitted()) {
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("text/html; charset=utf-8");
                pw = resp.getWriter();
                pw.print(result);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            if (null != pw) {
                pw.flush();
                pw.close();
            }
        }
    }

}
