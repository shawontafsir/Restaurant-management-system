package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sukarna.models.Order;
import java.util.ArrayList;
import sukarna.db.DataAccess;

public final class makeOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Order Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String mail = (String) session.getAttribute("email");
            if(mail == null){
                RequestDispatcher rd = request.getRequestDispatcher("logIn.jsp");
                rd.forward(request, response);
            }
        
      out.write("\n");
      out.write("        <h2 style=\"float: left\"><a href=\"userHomePage.jsp\">Home</a></h2>\n");
      out.write("        <h2 style=\"float: right\"><a href=\"logIn.jsp\">Log Out</a></h2>\n");
      out.write("        <fieldset style=\"clear: right\">\n");
      out.write("            <legend><h2>Give your order</h2></legend>\n");
      out.write("            <form method=\"post\" action=\"OrderProcess.do\">\n");
      out.write("                ***complete all fields<br/><br/>\n");
      out.write("                Food Id : <input type=\"number\" name=\"foodId\" min=\"1\" /><br/><br/>\n");
      out.write("                Number of Order : <input type=\"number\" name=\"noOfOrder\" min=\"1\" /><br/><br/>\n");
      out.write("                <input type=\"submit\" value=\"add\"><br/>\n");
      out.write("            </form>\n");
      out.write("        </fieldset>\n");
      out.write("        <br/><br/>\n");
      out.write("        <fieldset style=\"background-color: burlywood\">\n");
      out.write("        <h2>Your Orders : </h2>\n");
      out.write("        ");

            String email= (String) session.getAttribute("email");
            DataAccess dao = new DataAccess();
            ArrayList<Order> orderInfo = dao.getOrderInfo(email);
            if(orderInfo==null)
            {
                out.println("Your order List is null.");
            }
            else if(orderInfo.size()==0)
            {
                out.println("You have not any pending order.");
            }
            else 
            {
                out.println("<table>");
                out.println("<hr><td>Food Id</td>   <td>Name</td>   <td>Category</td>   <td>Price</td>   <td>Number of Order</td> <td>Cost</td></tr>");
                int count=0;
                for(Order order: orderInfo)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%d</td>   <td>%s</td>   <td>%s</td>    <td>%d</td>    <td>%d</td> <td>%d</td>", order.foodId, order.name, order.category,order.price,order.orderno,order.cost));
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        
      out.write("\n");
      out.write("        </fieldset>\n");
      out.write("        <br/><br/>\n");
      out.write("        <fieldset style=\"background-color: burlywood\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "showFoodList.jsp", out, false);
      out.write(" \n");
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
