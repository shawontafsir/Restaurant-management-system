package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class managerHomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Manager Home Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String email = (String) session.getAttribute("email");
            if(email == null){
                RequestDispatcher rd = request.getRequestDispatcher("managerEmployeeUI.jsp");
                rd.forward(request, response);
            }
        
      out.write("\n");
      out.write("        <h3 style=\"float: right\"><a href=\"managerEmployeeUI.jsp\">Log Out</a></h3>\n");
      out.write("        <fieldset style=\"clear: left;float: left;width: 300px\">\n");
      out.write("            <legend><h2>Manage Employee</h2></legend>\n");
      out.write("            <h3><a href=\"showEmployeeList.jsp\">Employee List</a></h3>\n");
      out.write("            <h3><a href=\"addEmployee.jsp\">Add Employee</a></h3>\n");
      out.write("            <h3><a href=\"updateEmployee.jsp\">Update Employee</a></h3>\n");
      out.write("            <h3><a href=\"deleteEmployee.jsp\">Delete Employee</a></h3>\n");
      out.write("        </fieldset>\n");
      out.write("        <fieldset style=\"float: left;width: 300px\">\n");
      out.write("            <legend><h2>Manage Food</h2></legend>\n");
      out.write("            <h3><a href=\"showFoodList.jsp\">Food List</a></h3>\n");
      out.write("            <h3><a href=\"addFood.jsp\">Add Food</a></h3>\n");
      out.write("            <h3><a href=\"updateFood.jsp\">Update Food</a></h3>\n");
      out.write("            <h3><a href=\"deleteFood.jsp\">Delete Food</a></h3>\n");
      out.write("        </fieldset>\n");
      out.write("        <fieldset style=\"float: left;width: 300px\">\n");
      out.write("            <legend><h2>Manage Order</h2></legend>\n");
      out.write("            <h3><a href=\"showOrderList.jsp\">Order List</a></h3>\n");
      out.write("            <h3><a href=\"assignOrder.jsp\">Assign Order</a></h3>\n");
      out.write("            <h3><a href=\"deleteOrder.jsp\">Delete Order</a></h3>\n");
      out.write("        </fieldset>\n");
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
