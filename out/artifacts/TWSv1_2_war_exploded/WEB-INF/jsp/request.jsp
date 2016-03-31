<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128196;</span>
			<hgroup>
				<h1>Lend Log</h1>
				<h2>工具租借记录</h2>
			</hgroup>
		</header>
		<div class="content no-padding timeline">
			<s:iterator value="#session.request" id="req">
				<div class="tl-post">
					<span class="icon">&#59185;</span>
					<p><span class="time">在 <s:date name="#req.time" format="yyyy-MM-dd HH:mm:ss"/>：</span> 成功申请了<a href="#"><s:property value="#req.tool.name"/></a>，该申请的状态为：<s:property value="#req.status"/> 。</p>
				</div>
			</s:iterator>
		</div>
	</section>
</section>

<%@include file="footer.jsp"%>