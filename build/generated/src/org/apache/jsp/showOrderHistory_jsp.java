package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sukarna.models.OrderList;
import java.util.ArrayList;
import sukarna.db.DataAccess;

public final class showOrderHistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Order History</title>\\\n");
      out.write("        <style>\n");
      out.write("            body  {\n");
      out.write("                background-color: #cccccc;\n");
      out.write("            }\n");
      out.write("            table{\n");
      out.write("            width:80%;\n");
      out.write("            text-align:center;\n");
      out.write("            margin-left:200px;\n");
      out.write("            margin-top:50px;\n");
      out.write("            box-shadow: 10px 10px gray;\n");
      out.write("            font-size:20px;\n");
      out.write("            font-style: italic;\n");
      out.write("        }\n");
      out.write("        table,td,th{\n");
      out.write("            border:1px solid black;\n");
      out.write("            border-size:1px;\n");
      out.write("            border-style:solid;\n");
      out.write("            border-color:black;\n");
      out.write("            padding:  5px 5px 5px 5px;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String email = (String) session.getAttribute("email");
            if(email == null){
                RequestDispatcher rd = request.getRequestDispatcher("managerEmployeeUI.jsp");
                rd.forward(request, response);
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <fieldset>\n");
      out.write("            <h3>Enter dates to see completed orders between two dates : </h3>\n");
      out.write("            <form method=\"post\" action=\"\">\n");
      out.write("                From : <input type=\"date\" name=\"from\" /><br/><br/>\n");
      out.write("                To : <input type=\"date\" name=\"to\"/><br/><br/>\n");
      out.write("                <input type=\"submit\" value=\"search\"/>\n");
      out.write("            </form>\n");
      out.write("        </fieldset>\n");
      out.write("        \n");
      out.write("        <h1>Completed Order</h1>\n");
      out.write("        ");
 
            DataAccess dao = new DataAccess();
            ArrayList<OrderList> orderInfo = dao.getOrderHistoryList();
            if(orderInfo==null)
            {
                out.println("Order History List is null");
            }
            else if(orderInfo.size()==0)
            {
                out.println("No order has been completed.");
            }
            else 
            {
                out.println("<table>");
                out.println("<hr><td>Order Id</td> <td>Food Id</td> <td>User Id</td> <td>Order Time</td> <td>Cost</td> <td>Employee Id</td></tr>");
                int count=0;
                for(OrderList orderList: orderInfo)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%d</td> <td>%d</td> <td>%d</td> <td>%s</td> <td>%d</td> <td>%d</td>",orderList.orderId,orderList.foodId,orderList.userId,orderList.orderTime,orderList.customerId,orderList.employeeId));
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        
      out.write("\n");
      out.write("        \n");
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
