package xidian.tws.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import xidian.tws.entity.EmployeeEntity;

/**
 * 用户权限拦截器
 * Created by wuhul on 2016/3/16.
 */
public class AuthorityInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext ctx = actionInvocation.getInvocationContext();
        EmployeeEntity user = (EmployeeEntity) ctx.getSession().get("employee");
        if (user != null) {
            return actionInvocation.invoke();
        }
        ctx.put("tip","您还没有登录，或者没有权限访问，请重新登录！");
        return Action.LOGIN;
    }
}
