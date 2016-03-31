package xidian.tws.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xidian.tws.entity.*;
import xidian.tws.service.EmployeeService;

import java.util.List;

/**
 * 工具Action
 * Created by wuhul on 2016/3/30.
 */
public class ToolAction extends ActionSupport {
    private EmployeeEntity employee;
    private ToolEntity tool;
    private int tid;//工具ID
    private int rid;//申请ID

    //系统所用的业务逻辑组件
    private EmployeeService employeeService;

    //设值注入业务逻辑组件所必须的setter方法
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public ToolEntity getTool() {
        return tool;
    }

    public void setTool(ToolEntity tool) {
        this.tool = tool;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String listAllTools() {
        ActionContext ctx = ActionContext.getContext();
        employee = (EmployeeEntity) ctx.getSession().get("employee");

        if (employee != null) {
            List<ToolEntity> allToolsList = null;
            if (employee.getEmployeeType() == EmployeeType.一般员工) {
                allToolsList = employeeService.findDepartmentTools(employee);
            } else {
                allToolsList = employeeService.findCompanyTools(employee.getCompany());
            }
            System.out.println(allToolsList);/*delete*/
            ctx.getSession().put("allToolsList", allToolsList);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String listSelfTools() {
        ActionContext ctx = ActionContext.getContext();
        employee = (EmployeeEntity) ctx.getSession().get("employee");

        if (employee != null) {
            List<ToolEntity> selfToolsList = employeeService.findAllSelfTools(employee);
            ctx.getSession().put("selfToolsList", selfToolsList);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    /**
     * 申请工具
     *
     * @return
     */
    public String application() {
        ActionContext ctx = ActionContext.getContext();
        employee = (EmployeeEntity) ctx.getSession().get("employee");
        if (employee != null) {
            if (employeeService.addRequest(employee, tid))
                return SUCCESS;
        }
        return ERROR;
    }



    /**
     * 查询借还记录
     *
     * @return
     */
    public String lendLog() {
        ActionContext ctx = ActionContext.getContext();
        employee = (EmployeeEntity) ctx.getSession().get("employee");
        if (employee != null) {
            List<LendEntity> lends = employeeService.findAllLends(employee);
            ctx.getSession().put("lends", lends);
            return SUCCESS;
        }
        return ERROR;
    }

    public String request() throws Exception {
        ActionContext ctx = ActionContext.getContext();
        employee = (EmployeeEntity) ctx.getSession().get("employee");
        if (employee != null) {
            List<EmployeerequestEntity> requestList = employeeService.findAllRequest(employee);
            ctx.getSession().put("request", requestList);
            return "success";
        }
        return ERROR;
    }


}
