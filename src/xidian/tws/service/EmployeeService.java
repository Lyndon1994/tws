package xidian.tws.service;

import xidian.tws.entity.*;

import java.util.List;

/**
 * 员工管理
 * Created by wuhul on 2016/3/28.
 */
public interface EmployeeService {
    /**
     * 身份验证登录
     * @param name 登录的员工用户名
     * @param password 密码
     * @return 登录后的身份
     */
    EmployeeEntity validLogin(String name, String password);

    /**
     * 查询自己所有工具
     * @param employee 员工ID
     * @return 所有借还工具
     */
    List<ToolEntity> findAllSelfTools(EmployeeEntity employee);

    /**
     * 查询自己所有工具的借还状态
     * @param employee 员工ID
     * @return 所有借还工具
     */
    List<LendEntity> findAllLends(EmployeeEntity employee);

    /**
     * 查询自己指定工具的借还状态
     * @param employee 员工ID
     * @param toolName 工具名称
     * @return 所有借还记录
     */
    List<LendEntity> findLend(EmployeeEntity employee, String toolName);

    /**
     * 增加工具申请
     * @param employee 员工
     * @param toolId 工具
     * @return 增加的结果
     */
    boolean addRequest(EmployeeEntity employee, int toolId);

    /**
     * 查看员工所有申请
     * @param employee 员工ID
     * @return 所有申请
     */
    List<EmployeerequestEntity> findAllRequest(EmployeeEntity employee);

    /**
     * 查看所有申请
     * @param company 员工ID
     * @return 所有申请
     */
    List<EmployeerequestEntity> findAllRequest(CompanyEntity company);

    /**
     * 找到员工部门所有工具
     *
     * @param employee 员工
     * @return 部门所有工具
     */
    public List<ToolEntity> findDepartmentTools(EmployeeEntity employee);

    /**
     * 找到一个公司所有工具
     * @param company 公司
     * @return 所有工具
     */
    public List<ToolEntity> findCompanyTools(CompanyEntity company);

    /**
     * 查找关键词匹配工具
     * @param key
     * @return
     */
    List<ToolEntity> findAllTools(String key);

    /**
     * 员工借工具
     * @param tool
     * @return
     */
    public boolean lendTool(int tool);

    /**
     * 员工归还工具
     * @param tool 工具
     * @return 成功与否
     */
    public boolean returnTool(int tool);

    /**
     * 员工注销工具
     * @param tool 工具
     * @return 成功与否
     */
    public boolean cancelTool(int tool);

    /**
     * 机器人转为空闲状态
     * @param tid
     */
    public void lendover(int tid);

    /**
     * 接收申请
     * @param rid 申请ID
     */
    void acceptRequest(int rid);

    /**
     * 拒绝申请
     * @param rid  申请ID
     */
    void refuseRequest(int rid);

    /**
     * 查迅所有机器人
     * @param company
     * @return
     */
    List<RobotEntity> findAllRobots(CompanyEntity company);


}
