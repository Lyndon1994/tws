<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>机器人状态</h1>
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
					<th>机器人ID</th>
					<th>机器人状态</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<s:if test="#session.robot==null">
					暂无记录
				</s:if>
				<s:else>
					<s:iterator value="#session.robot" id="rob">
						<tr>
							<td><s:property value="#rob.id"/></td>
							<td><s:property value="#rob.status"/></td>
							<td></td>
						</tr>
					</s:iterator>
				</s:else>
				</tbody>
			</table>
		</div>
	</section>
</section>

<%@include file="footer.jsp"%>