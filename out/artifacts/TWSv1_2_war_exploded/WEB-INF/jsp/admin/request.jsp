<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>工具申请</h1>
				<h2><s:property value="#session.employee.company.name"/>公司</h2>
			</hgroup>
			<aside>
				<span>
					<a href="#">&#9881;</a>
					<ul class="settings-dd">
						<li><label>Option a</label><input type="checkbox" /></li>
						<li><label>Option b</label><input type="checkbox" checked="checked" /></li>
						<li><label>Option c</label><input type="checkbox" /></li>
					</ul>
				</span>
			</aside>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
				<tr>
					<th>申请人</th>
					<th>工具ID</th>
					<th>工具名称</th>
					<th>申请时间</th>
					<th>申请状态</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<s:if test="#session.allRequest==null">
					暂无记录
				</s:if>
				<s:else>
					<s:iterator value="#session.allRequest" id="allReq">
						<tr>
							<td><span data-toggle="tooltip" data-placement="top" title="<s:property value="#allReq.employee"/>"><s:property value="#allReq.employee.name"/></span></td>
							<td><s:property value="#allReq.tool.id"/></td>
							<td><span data-toggle="tooltip" data-placement="top" title="<s:property value="#allReq.tool"/>"><s:property value="#allReq.tool.name"/></span></td>
							<td><s:property value="#allReq.time"/></td>
							<td><s:property value="#allReq.status"/></td>
							<td>
								<s:if test="#allReq.status.toString()==\"审核中\"">
									<button class="green"><a href="
												<s:url action="admin_accept">
													<s:param name="rid" value="#allReq.id"/>
												</s:url>
											" >接收</a></button>
									<button class="red"><a href="
												<s:url action="admin_refuse">
													<s:param name="rid" value="#allReq.id"/>
												</s:url>
											" >拒绝</a></button>
								</s:if>
							</td>
						</tr>
					</s:iterator>
				</s:else>
				</tbody>
			</table>
		</div>
	</section>
</section>
<script language="JavaScript">
	$('[data-toggle="tooltip"]').tooltip();
</script>
<%@include file="footer.jsp"%>