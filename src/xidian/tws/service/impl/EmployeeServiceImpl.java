package xidian.tws.service.impl;

import xidian.tws.dao.*;
import xidian.tws.entity.*;
import xidian.tws.service.EmployeeService;

import java.util.Date;
import java.util.List;

/**
 * 员工业务逻辑操作
 * Created by wuhul on 2016/3/28.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private CompanyDao companyDao;
    private DepartmentDao departmentDao;
    private EmployeeDao employeeDao;
    private EmployeerequestDao employeerequestDao;
    private LendDao lendDao;
    private ToolDao toolDao;
    private RobotDao robotDao;

    public CompanyDao getCompanyDao() {
        return companyDao;
    }

    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeerequestDao getEmployeerequestDao() {
        return employeerequestDao;
    }

    public void setEmployeerequestDao(EmployeerequestDao employeerequestDao) {
        this.employeerequestDao = employeerequestDao;
    }

    public LendDao getLendDao() {
        return lendDao;
    }

    public void setLendDao(LendDao lendDao) {
        this.lendDao = lendDao;
    }

    public ToolDao getToolDao() {
        return toolDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public RobotDao getRobotDao() {
        return robotDao;
    }

    public void setRobotDao(RobotDao robotDao) {
        this.robotDao = robotDao;
    }

    /**
     * 身份验证登录
     *
     * @param name     登录的员工用户名
     * @param password 密码
     * @return 登录后的身份
     */
    @Override
    public EmployeeEntity validLogin(String name, String password) {
        return employeeDao.findByName(name, password);
    }

    /**
     * 查询自己所有工具的借还状态
     *
     * @param employee 员工ID
     * @return 所有借还记录
     */
    @Override
    public List<ToolEntity> findAllSelfTools(EmployeeEntity employee) {
        return employeeDao.getSelfTools(employee);
    }

    /**
     * 查询自己所有工具的借还状态
     *
     * @param employee 员工ID
     * @return 所有借还工具
     */
    @Override
    public List<LendEntity> findAllLends(EmployeeEntity employee) {
        return lendDao.findByEmpId(employee.getId());
    }

    /**
     * 查询自己指定工具的借还状态
     *
     * @param employee 员工ID
     * @param toolName 工具名称
     * @return 所有借还记录
     */
    @Override
    public List<LendEntity> findLend(EmployeeEntity employee, String toolName) {
        return lendDao.findLend(employee, toolName);
    }


    /**
     * 增加工具申请
     *
     * @param employee 员工
     * @param toolId   工具
     * @return 增加的结果
     */
    @Override
    public boolean addRequest(EmployeeEntity employee, int toolId) {
        ToolEntity tool = toolDao.get(ToolEntity.class, toolId);
        if (tool != null) {
            employeerequestDao.save(new EmployeerequestEntity(employee, tool, new Date()));
            toolDao.updatePre(employee, tool);
            employeeDao.addTool(employee,tool);
            return true;
        }
        return false;
    }

    /**
     * 查看员工所有申请
     *
     * @param employee 员工
     * @return 所有申请
     */
    @Override
    public List<EmployeerequestEntity> findAllRequest(EmployeeEntity employee) {
        return employeerequestDao.findAllRequest(employee);
    }

    /**
     * 查看所有申请
     *
     * @param company 员工ID
     * @return 所有申请
     */
    @Override
    public List<EmployeerequestEntity> findAllRequest(CompanyEntity company) {
        return employeerequestDao.findAllRequest(company);
    }

    /**
     * 找到员工部门所有工具
     *
     * @param employee 员工
     * @return 部门所有工具
     */
    @Override
    public List<ToolEntity> findDepartmentTools(EmployeeEntity employee) {
        if (employee.getDepartment() != null)
            return toolDao.findToolsByDepartment(employee.getDepartment());
        return null;
    }

    /**
     * 找到一个公司所有工具
     *
     * @param company 公司
     * @return 所有工具
     */
    @Override
    public List<ToolEntity> findCompanyTools(CompanyEntity company) {
        return toolDao.findCompanyTools(company);
    }

    /**
     * 员工借工具
     *
     * @param toolId
     * @return 借出成功或失败
     */
    @Override
    public boolean lendTool(int toolId) {
        ToolEntity tool = toolDao.get(ToolEntity.class, toolId);
        EmployeeEntity employee = tool.getEmployee();
        if (employee != null && tool.getStatus() == ToolStatus.预约中) {
            if (employee.getEmployeeType() == EmployeeType.专家 || employee.getEmployeeType() == EmployeeType.一般员工 && tool.getDepartment().equals(employee.getDepartment())) {
                //查看是否有可用机器人
                if (robotDao.work(tool.getDepartment().getCompany())) {
                    toolDao.updateLend(tool);
                    lendDao.save(new LendEntity(tool, employee, LendOperate.借出, new Date()));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 员工归还工具
     *
     * @param toolid 工具
     * @return 成功与否
     */
    @Override
    public boolean returnTool(int toolid) {
        ToolEntity tool = toolDao.get(ToolEntity.class, toolid);
        EmployeeEntity employee = tool.getEmployee();
        if (employee != null && tool.getEmployee().equals(employee)) {
            if (employeeDao.removeTool(employee, tool)) {
                toolDao.updateReturn(tool);
                lendDao.save(new LendEntity(tool, employee, LendOperate.归还, new Date()));
                return true;
            } else return false;
        }
        return false;
    }

    /**
     * 员工注销工具
     *
     * @param toolid 工具
     * @return 成功与否
     */
    @Override
    public boolean cancelTool(int toolid) {
        ToolEntity tool = toolDao.get(ToolEntity.class, toolid);
        EmployeeEntity employee = tool.getEmployee();
        if (employee != null && tool.getEmployee().equals(employee)) {
            if (employeeDao.removeTool(employee, tool)) {
                toolDao.updateCancel(tool);
                lendDao.save(new LendEntity(tool, employee, LendOperate.注销, new Date()));
                return true;
            } else return false;
        }
        return false;
    }

    /**
     * 机器人转为空闲状态
     *
     * @param tid
     */
    @Override
    public void lendover(int tid) {
        ToolEntity tool = toolDao.get(ToolEntity.class, tid);
        robotDao.free(tool.getDepartment().getCompany());
    }

    /**
     * 接收申请
     *
     * @param rid 申请ID
     */
    @Override
    public void acceptRequest(int rid) {
        employeerequestDao.get(EmployeerequestEntity.class, rid).setStatus(QuestStatus.接收);
    }

    /**
     * 拒绝申请
     *
     * @param rid 申请ID
     */
    @Override
    public void refuseRequest(int rid) {
        employeerequestDao.get(EmployeerequestEntity.class, rid).setStatus(QuestStatus.拒绝);
    }

    /**
     * 查迅所有机器人
     *
     * @param company
     * @return
     */
    @Override
    public List<RobotEntity> findAllRobots(CompanyEntity company) {

        return robotDao.findAll(company);
    }


}
