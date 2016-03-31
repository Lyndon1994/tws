<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="#session.employee.employeeType.toString()==\"管理员\"">
    <%@include file="admin/header.jsp" %>
</s:if><s:else>
    <%@include file="header.jsp" %>
</s:else>
<section class="content">
    <section class="widget">
        <header>
            <span class="icon">&#128318;</span>
            <hgroup>
                <h1>User Information</h1>
                <h2>个人信息</h2>
            </hgroup>
        </header>
        <div class="content">
            <section class="stats-wrapper">
                <div class="stats">
                    <p><span>${sessionScope.employee.name}</span></p>
                    <p>姓名</p>
                </div>
                <div class="stats">
                    <p><span>${sessionScope.employee.employeeType}</span></p>
                    <p>级别</p>
                </div>
            </section>
            <section class="stats-wrapper">
                <s:set name="type" value="#session.employee.employeeType.toString()"/>
                <div class="stats">
                    <p><span>
						<s:if test='#type==\"专家\"||#type==\"管理员\"'>无</s:if>
						<s:else><s:property value="#session.employee.department.name"/></s:else>
					</span></p>
                    <p>部门</p>
                </div>
                <div class="stats">
                    <p><span>
						<s:if test='#type==\"专家\"||#type==\"管理员\"'><s:property value="#session.employee.company.name"/></s:if>
						<s:else><s:property value="#session.employee.department.company.name"/></s:else>
					</span></p>
                    <p>公司</p>
                </div>
            </section>
        </div>
    </section>

</section>

<%@include file="footer.jsp" %>