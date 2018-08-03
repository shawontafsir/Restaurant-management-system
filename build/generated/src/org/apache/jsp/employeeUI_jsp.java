package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sukarna.db.DataAccess;
import sukarna.models.OrderList;
import java.util.ArrayList;

public final class employeeUI_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Employee UI</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-color: gainsboro;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1><a href=\"managerEmployeeUI.jsp\">Home</a></h1>\n");
      out.write("        <fieldset style=\"width: 300px;float:left\">\n");
      out.write("            <legend><h3>Employee ID</h3></legend>\n");
      out.write("            <h4>To see your assigned order, please enter your Employee Id first : </h4>\n");
      out.write("            <form method=\"post\" action=\"EmployeeTasks.do\">\n");
      out.write("                Employee Id : <input type=\"number\" name=\"employeeId\" /> <br/><br/>\n");
      out.write("                <input type=\"submit\" value=\"Assigned orders\" /> <br/>\n");
      out.write("            </form>\n");
      out.write("        </fieldset>\n");
      out.write("        <fieldset style=\"width: 300px;float: right\">\n");
      out.write("            <legend><h3>Completed Order ID</h3></legend>\n");
      out.write("            <h4>If you have completed one of your assigned orders, please enter completed order Id : </h4>\n");
      out.write("            <form method=\"post\" action=\"DeleteOrderByEmployee.do\">\n");
      out.write("                Completed Order Id : <input type=\"number\" name=\"orderId\" min=\"1\"/><br/><br/>\n");
      out.write("                <input type=\"submit\" value=\"Delete order\" /> <br/>\n");
      out.write("            </form>\n");
      out.write("        </fieldset>\n");
      out.write("      \n");
      out.write("        <h1 style=\"clear: left;margin-top: 250px\">Your assigned orders : </h1>\n");
      out.write("        ");

            String employeeId = (String) session.getAttribute("employeeId");
            DataAccess db = new DataAccess();
            ArrayList<OrderList> orderInfo = db.employeeTasks(Integer.parseInt(employeeId));
            
            if(orderInfo==null)
            {
            }
            else if(orderInfo.size()==0)
            {
                out.println("You have not any assigned orders to do.");
            }
            else 
            {
                out.println("<table>");
                out.println("<hr><td>Order Id</td> <td>Food Id</td> <td>User Id</td> <td>Customer Id</td> <td>Order Time</td></tr>");
                int count=0;
                for(OrderList orderList: orderInfo)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%d</td> <td>%d</td> <td>%d</td> <td>%d</td> <td>%s</td>",orderList.orderId,orderList.foodId,orderList.userId,orderList.customerId,orderList.orderTime));
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <br/><br/>\n");
      out.write("        <h1><a href=\"showFoodList.jsp\">Food List</a></h1>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "showOrderList.jsp", out, false);
      out.write("\n");
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
