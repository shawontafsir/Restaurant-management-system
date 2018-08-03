package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Sign Up</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-color: grey;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <h1>Create your account!</h1>\n");
      out.write("        <fieldset style=\"width:300px\" align=\"center\">\n");
      out.write("            <legend><h4>Create Account</h4></legend>\n");
      out.write("            <form method=\"post\" action=\"CreateAccount.do\">\n");
      out.write("                <table align=\"center\">\n");
      out.write("                    <tr><td>User Name </td><td><input type=\"text\" name=\"username\" ></td> </tr>\n");
      out.write("                    <tr><td>E-mail</td><td> <input type=\"text\" name=\"email\" placeholder=\"@gmail.com\" ></td></tr>\n");
      out.write("                <tr><td>Mobile No.</td><td> <input type=\"text\" name=\"mobileno\" /> </td> </tr>\n");
      out.write("                <tr><td>Password</td><td> <input type=\"password\" name=\"password\" /></td> </tr>\n");
      out.write("               <tr><td> Address</td><td> <input type=\"text\" name=\"address\"> </td> </tr>\n");
      out.write("               <tr><td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"Create\" /> </td> </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </fieldset>\n");
      out.write("        <p><a href=\"index.html\">Back to Home Page</a></p>\n");
      out.write("        <p><a href=\"logIn.jsp\">I have already an account</a></p>\n");
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
