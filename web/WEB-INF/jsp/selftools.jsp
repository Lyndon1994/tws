<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>在借工具</h1>
				<h2></h2>
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
						<th>工具ID</th>
						<th>工具名称</th>
						<th>部门</th>
						<th>工具属性</th>
					</tr>
				</thead>
					<tbody>
					<s:if test="#session.selfToolsList==null">
						<tr><td>暂无记录</td></tr>
					</s:if>
					<s:else>
						<s:iterator value="#session.selfToolsList" id="selftool">
							<tr>
								<td><s:property value="#selftool.id"/></td>
								<td><s:property value="#selftool.name"/></td>
								<td><s:property value="#selftool.department.name"/></td>
								<td><s:property value="#selftool.toolType"/></td>
							</tr>
						</s:iterator>
					</s:else>
					</tbody>
				</table>
		</div>
	</section>
</section>

<%@include file="footer.jsp"%>