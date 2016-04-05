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
			<s:iterator value="#session.lends" id="lend">
				<div class="tl-post">
					<span class="icon">&#59185;</span>
					<p><s:property value="#lend.operate"/> <span data-toggle="tooltip" data-placement="top" title="<s:property value="#lend.tool"/>" style="color: blue;"><b><s:property value="#lend.tool.name"/></b></span> <span class="time">in <s:property value="#lend.time"/></span></p>
				</div>
			</s:iterator>
		</div>
	</section>
</section>
<%@include file="footer.jsp"%>