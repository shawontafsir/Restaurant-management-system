package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class managerEmployeeUI_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Manager-Employee UI</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-color: gainsboro;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            ul {\n");
      out.write("                list-style-type: none;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                overflow: hidden;\n");
      out.write("                border: 1px solid #e7e7e7;\n");
      out.write("                background-color: darkseagreen;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            li {\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            li a {\n");
      out.write("                display: block;\n");
      out.write("                color: #666;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 14px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            li a:hover:not(.active) {\n");
      out.write("                background-color: #ddd;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            li a.active {\n");
      out.write("                color: white;\n");
      out.write("                background-color: green;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 style=\"font-family: cursive\" align=\"center\">Special Restaurant</h1>\n");
      out.write("        <ul>\n");
      out.write("            <li><a class=\"active\" href=\"managerEmployeeUI.jsp\">Home</a></li>\n");
      out.write("            <li><a href=\"showFoodList.jsp\">Food List</a></li>\n");
      out.write("            <li><a href=\"employeeUI.jsp\">Employee UI</a></li>\n");
      out.write("            <li><a href=\"showEmployeeList.jsp\">Employee List</a></li>\n");
      out.write("            <li><a href=\"\">About Us</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <div style=\"margin-top : 100px\" align=\"center\">\n");
      out.write("        <fieldset style=\"width:400px\" align=\"center\">\n");
      out.write("            <legend><h4>Manager Log In</h4></legend>\n");
      out.write("            <h4>To go manager Home page, please log in first</h4>\n");
      out.write("            <form method=\"post\" action=\"ManagerLogInProcess.do\">\n");
      out.write("                Enter your E-mail: <input type=\"email\" name=\"email\" /> <br/><br/>\n");
      out.write("                Enter your password: <input type=\"password\" name=\"password\" /> <br/><br/>\n");
      out.write("                <input type=\"submit\" value=\"Login\" /> <br/>\n");
      out.write("            </form>\n");
      out.write("        </fieldset>\n");
      out.write("        </div>\n");
      out.write("        ");

            session.setAttribute("employeeId", "-1");
            session.setAttribute("email", null);
        
      out.write("\n");
      out.write("     \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
