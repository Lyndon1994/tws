package xidian.tws.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xidian.tws.entity.EmployeeEntity;
import xidian.tws.service.EmployeeService;

/**
 * 用户登陆
 * Created by wuhul on 2016/3/27.
 */
public class LoginAction extends ActionSupport {
    private String name;
    private String password;
    //系统所用的业务逻辑组件
    private EmployeeService employeeService;
    //设值注入业务逻辑组件所必须的setter方法
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        ActionContext ctx = ActionContext.getContext();

        EmployeeEntity employee = employeeService.validLogin(getName(), getPassword());
        if (employee!=null) {
            ctx.getSession().put("employee",employee);
            addActionMessage("登陆成功");
            return SUCCESS;
        }else {
            addActionMessage("用户或密码不匹配");
            return INPUT;
        }
    }
}
