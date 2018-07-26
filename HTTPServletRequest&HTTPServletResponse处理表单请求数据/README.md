html中form标签元素属性method即可改变浏览器提交输入请求的GET与POST方法


注意！如果表单提交的数据中有中文数据则需要转码：
String name =new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");