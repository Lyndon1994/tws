<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<section class="content">
    <section class="widget">
        <header>
            <span class="icon">&#128196;</span>
            <hgroup>
                <h1>机器人抓取工具</h1>
                <h2 id="tip"></h2>
            </hgroup>
        </header>
        <div class="content">
            <s:if test="#session.lending==\"n\"">
                暂无机器人可用！请稍后再试。
            </s:if>
            <s:else>
                <div class="progress">
                    <div id="progress" class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="0" aria-valuemax="100" style="width: 1%;">
                        <%--<span class="sr-only">60% Complete</span>--%>
                    </div>
                </div>
                <script language=javascript>
                    var int=self.setInterval("clock()",100)
                    function clock()
                    {
                        $("#tip").html("机器人正在抓取...请稍后");
                        //var t=document.getElementById("progress").attributes["aria-valuenow"].value;
                        var t = $("#progress").attr("aria-valuenow");
                        if(t>=100){
                            int=window.clearInterval(int);
                            alert("抓取成功，请提取工具！");
                            $("#tip").html("机器人抓取成功");
                        }
                        t++;
                        $("#progress").attr("aria-valuenow",t);
                        $("#progress").attr("style","width: "+t+"%;");
                    }
                </script>
                <br><br><br><br>
                <hr>
                <button class="green"><a href="admin_lendover.action?tid=<s:property value="#parameters.tid"/>">确定</a></button>
            </s:else>
        </div>
    </section>
</section>

<%@include file="footer.jsp" %>