/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-02-20 15:20:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.mvc.dto.MVCBoardDto;
import java.util.List;
import com.mvc.biz.MVCBoardBizImpl;
import com.mvc.biz.MVCBoardBiz;

public final class mycontroller_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.mvc.biz.MVCBoardBizImpl");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.mvc.biz.MVCBoardBiz");
    _jspx_imports_classes.add("com.mvc.dto.MVCBoardDto");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");

      out.write('\r');
      out.write('\n');

	response.setContentType("text/html; charset=UTF-8");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");

		// 컨트롤러의 역할 : 
	String command = request.getParameter("command");
	System.out.printf("[%s]\n", command);

	MVCBoardBiz biz = new MVCBoardBizImpl();
	//요청한 명령을 확인한다 
	if (command.equals("list")) {
		//1. 보내준 값이 있으면 받는다. 

		//2. db에 전달할 값이 있으면 전달하고, 
		// 없으면 없는대로 호출해서 리턴받는다. 

		List<MVCBoardDto> list = biz.selectlist();

		//3. 화면에 전달할 값이 있으면, request 객체에 담아준다. 
		request.setAttribute("list", list); // list를 "list"에 담는다 

		//4. 보낸다. 
		pageContext.forward("mylist.jsp"); // request에 뭔가 담으면 포워드해야하고 
		// 페이지를 위임 받는다 mylist로 가!  
		// 포워드 되는것은 주소창에서 확인이 안된다 
	} else if (command.equals("insertform")) {
		//1.
		//2.
		//3.
		//4.

		response.sendRedirect("myinsert.jsp"); // request에 뭐가 없다 ? 리다이렉트한다 
		/*
			pageContext.forward() : 페이지 위임(request,response  객체가 그대로 전달)
			response.sedRedirect() : 페이지 이동( 새로운 request, response 객체 )
		
		*/
	} else if (command.equals("insertres")) {
		//1.
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		//2.

		MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
		int res = biz.insert(dto);

		//3.
		//4.
		if (res > 0) {
	
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write(" alert(\"글 작성 성공\")\r\n");
      out.write(" location.href='mycontroller.jsp?command=list';\r\n");
      out.write(" \r\n");
      out.write(" </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");

		} else {
	
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("alert(\"글 작성 실패\")\r\n");
      out.write("location.href=\"mycontroller.jsp?command=insertform\";\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");

		}
	} else if (command.equals("select")) {
	//1.
	int seq = Integer.parseInt(request.getParameter("seq"));

	//2.
	MVCBoardDto dto = biz.selectOne(seq);

	//3. 
	request.setAttribute("select", dto);

	//4. 
	pageContext.forward("myselect.jsp");

	} else if (command.equals("updateform")) {

	//1.	
	int seq = Integer.parseInt(request.getParameter("seq"));
	//3.
	request.setAttribute("seq", seq);

	//4.
	pageContext.forward("myupdate.jsp");

	} else if (command.equals("updateres")) {
	//1.
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	int seq = Integer.parseInt(request.getParameter("seq"));

	//2.
	MVCBoardDto dto = new MVCBoardDto();
	dto.setTitle(title);
	dto.setContent(content);
	dto.setSeq(seq);
	int res = biz.update(dto);

	if (res > 0) {
	
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("alert(\"수정 성공!\")\r\n");
      out.write("location.href=\"mycontroller.jsp?command=select&seq=");
      out.print(dto.getSeq());
      out.write("\"\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t");

		} else {
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("alert(\"수정실패\")\r\n");
      out.write("location.href=\"mycontroller.jsp?command=updateform&seq=");
      out.print(dto.getSeq());
      out.write("\"\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\t");

		}

	}else if(command.equals("delete")){
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int res = biz.delete(seq);
		if(res>0){
			
	
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\talert(\"삭제 성공\")\r\n");
      out.write("\t\r\n");
      out.write("\tlocation.href=\"mycontroller.jsp?command=list\"\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t");

		}else{
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("alert(\"삭제 실패 ㅠ\")\r\n");
      out.write("location.href=\"mycontroller.jsp?command=select&seq=");
      out.print(seq);
      out.write("\"\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");

		}
	}else if(command.equals("muldel")){
		
		String [] seqs = request.getParameterValues("chk");
		
		//request.setAttribute("seqs", seqs);
		
		//pageContext.forward("mymuldel.jsp");
		int res = biz.muldelete(seqs);
		if(res>0){
			
	
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\talert(\"삭제 성공\")\r\n");
      out.write("\t\r\n");
      out.write("\tlocation.href=\"mycontroller.jsp?command=list\"\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t");

		}else{
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("alert(\"삭제 실패 ㅠ\")\r\n");
      out.write("location.href=\"mycontroller.jsp?command=list\"\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");

		}
		
	}

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
