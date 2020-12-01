package com.component.ExcelUtils.base;

import com.component.ExcelUtils.utils.IPUtil;
import com.component.test.ExcelUtils.dto.AjaxResult;
import com.component.test.ExcelUtils.utils.IPUtil;
import com.component.test.ExcelUtils.utils.ResourceUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:40
 */
public abstract class BaseController {
    protected Map<String, Object> resultMap = new LinkedHashMap();

    public BaseController() {
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public ModelAndView view(String viewName) {
        return new ModelAndView(ResourceUtil.getTpl(viewName));
    }

    public ModelAndView view(String viewName, Map<String, ?> model) {
        return new ModelAndView(ResourceUtil.getTpl(viewName), model);
    }

    public AjaxResult returnFailed(String retmsg) {
        return new AjaxResult(retmsg);
    }

    public void logBefore(String desc) {
        HttpServletRequest request = getRequest();
        //LoggerUtils.error("");
        StringBuilder sb = (new StringBuilder(IPUtil.getIpAdd(request))).append(desc).append(":").append(request.getServletPath());
        //LoggerUtils.error(sb.toString());
    }

    private Map<String, Object> handleParams(Map<String, Object> params) {
        Map<String, Object> result = new HashMap();
        if (null != params) {
            Set<Map.Entry<String, Object>> entrySet = params.entrySet();
            Iterator it = entrySet.iterator();

            while(it.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)it.next();
                if (entry.getValue() != null) {
                    result.put(entry.getKey(), StringUtils.trimToEmpty((String)entry.getValue()));
                }
            }
        }

        return result;
    }

    protected AjaxResult prompt_add(Integer id) {
        Integer status = 1;
        String message = "新增成功！";
        if (id <= 0) {
            status = -5;
            message = "修改失败！";
        }

        return new AjaxResult(status, message);
    }

    protected AjaxResult prompt_edit(Integer id) {
        Integer status = 1;
        String message = "修改成功！";
        if (id <= 0) {
            status = -5;
            message = "修改失败！";
        }

        return new AjaxResult(status, message);
    }

    protected AjaxResult prompt_del(Integer id) {
        Integer status = 1;
        String message = "删除成功！";
        if (id <= 0) {
            status = -5;
            message = "删除失败！";
        }

        return new AjaxResult(status, message);
    }

    protected AjaxResult prompt_succ(String msg) {
        Integer status = 1;
        return new AjaxResult(status, msg);
    }

    protected AjaxResult prompt_err(String message) {
        return new AjaxResult(-1, message);
    }

    protected <T extends BaseModel> void initForm(T form) {
    }
}

