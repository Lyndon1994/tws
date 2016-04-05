<%--
  Created by IntelliJ IDEA.
  User: wuhul
  Date: 2016/3/27
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.wysiwyg.js"></script>
<script src="${pageContext.request.contextPath}/js/custom.js"></script>
<script src="${pageContext.request.contextPath}/js/cycle.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.checkbox.min.js"></script>
<script src="${pageContext.request.contextPath}/js/flot.js"></script>
<script src="${pageContext.request.contextPath}/js/flot.resize.js"></script>
<script src="${pageContext.request.contextPath}/js/flot-time.js"></script>
<script src="${pageContext.request.contextPath}/js/flot-pie.js"></script>
<script src="${pageContext.request.contextPath}/js/flot-graphs.js"></script>
<script src="${pageContext.request.contextPath}/js/cycle.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.tablesorter.min.js"></script>
<%--<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>--%>

<script type="text/javascript">
    function search() {
        var key = $("#search").val();
        if (key == "") {
            $(".searchEle").show();
        }else {
            $(".searchEle").hide();
            $(".searchEle:contains(key)").show();
        }
    }

    // Feature slider for graphs
    $('.cycle').cycle({
        fx: "scrollHorz",
        timeout: 0,
        slideResize: 0,
        prev:    '.left-btn',
        next:    '.right-btn'
    });
    $('[data-toggle="tooltip"]').tooltip();
</script>
</body>
</html>