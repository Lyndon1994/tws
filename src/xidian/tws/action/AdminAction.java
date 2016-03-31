package xidian.tws.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import xidian.tws.entity.*;
import xidian.tws.service.EmployeeService;

import java.util.List;

/**
 * 管理员Action
 * Created by wuhul on 2016/3/30.
 */
public class AdminAction extends ActionSupport {
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



    /**
     * 管理员借工具
     *
     * @return
     */
    public String lendTool() {
        ActionContext ctx = ActionContext.getContext();
        if (employeeService.lendTool(tid)){
            ctx.getSession().put("lending", "y");
        }else {
            ctx.getSession().put("lending", "n");
        }
        return "lending";
    }

    /**
     * 机器人改为空闲状态
     * @return
     */
    public String lendover() {
        employeeService.lendover(tid);
        return "lendover";
    }

    /**
     * 查询所有机器人状态
     * @return
     */
    public String robot(){
        ActionContext ctx = ActionContext.getContext();
        employee = (EmployeeEntity) ctx.getSession().get("employee");
        if (employee != null) {
            List<RobotEntity> robots = employeeService.findAllRobots(employee.getCompany());
            ctx.getSession().put("robot", robots);
            return "robot";
        }
        return ERROR;
    }


    /**
     * 管理员还工具
     *
     * @return
     */
    public String returnTool() {
        if (employeeService.returnTool(tid))
            return "return";
        return ERROR;
    }

    /**
     * 管理员注销工具
     *
     * @return
     */
    public String cancelTool() {
        if (employeeService.cancelTool(tid))
            return "return";
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


    /**
     * 管理员查看所有申请
     * @return
     * @throws Exception
     */
    public String allRequest() throws Exception {
        ActionContext ctx = ActionContext.getContext();
        employee = (EmployeeEntity) ctx.getSession().get("employee");
        if (employee != null) {
            List<EmployeerequestEntity> requestList = employeeService.findAllRequest(employee.getCompany());
            ctx.getSession().put("allRequest", requestList);
            return "request";
        }
        return ERROR;
    }

    /**
     * 接收申请
     * @return
     */
    public String accept(){
        employeeService.acceptRequest(rid);
        return "accept";
    }

    /**
     * 拒绝申请
     * @return
     */
    public String refuse(){
        employeeService.refuseRequest(rid);
        return "refuse";
    }

    /**
     * 管理员查看所有工具
     * @return
     */
    public String alltools() {
        ActionContext ctx = ActionContext.getContext();
        employee = (EmployeeEntity) ctx.getSession().get("employee");

        if (employee != null) {
            List<ToolEntity> allToolsList = null;
            allToolsList = employeeService.findCompanyTools(employee.getCompany());
            ctx.getSession().put("allToolsList", allToolsList);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
