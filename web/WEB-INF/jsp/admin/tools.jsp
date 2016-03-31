<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./header.jsp"%>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>所有工具</h1>
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
						<th>工具ID</th>
						<th>工具名称</th>
						<th>部门</th>
						<th>工具属性</th>
						<th>工具状态</th>
						<th>操作</th>
					</tr>
				</thead>
					<tbody>
						<s:if test="#session.allToolsList==null">
							暂无记录
						</s:if>
						<s:else>
							<s:iterator value="#session.allToolsList" id="tool">
								<tr class="searchEle">
									<td><s:property value="#tool.id"/></td>
									<td><s:property value="#tool.name"/></td>
									<td><s:property value="#tool.department.name"/></td>
									<td><s:property value="#tool.toolType"/></td>
									<td>
										<s:property value="#tool.status"/>
										<s:if test="#tool.status.toString()==\"借出\"||#tool.status.toString()==\"预约中\"">
											（<s:property value="#tool.employee.name"/>）
										</s:if>
									</td>
									<td>
										<s:if test="#tool.status.toString()==\"预约中\"">
											<button class="green"><a href="
												<s:url action="admin_lendTool">
													<s:param name="tid" value="#tool.id"/>
												</s:url>
											" >借出</a></button>
										</s:if>
										<s:elseif test="#tool.status.toString()==\"借出\"">
											<button class="green"><a href="
												<s:url action="admin_returnTool">
													<s:param name="tid" value="#tool.id"/>
												</s:url>
											" >归还</a></button>
											<button class="red"><a href="
												<s:url action="admin_cancelTool">
													<s:param name="tid" value="#tool.id"/>
												</s:url>
											" >注销</a></button>
										</s:elseif>
									</td>
								</tr>
							</s:iterator>
						</s:else>
					</tbody>
				</table>
		</div>
	</section>
</section>

<%@include file="footer.jsp"%>