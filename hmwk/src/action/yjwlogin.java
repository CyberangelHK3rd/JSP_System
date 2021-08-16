package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.bagDao;

import service.MysqlConn;

public class yjwlogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public yjwlogin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String user=request.getParameter("username");
		String pw=request.getParameter("pw");
		bagDao bg=new bagDao();
		int res;
		MysqlConn yjw =new 	MysqlConn();
		ResultSet rs=null;
		try{
			rs=yjw.doQuery("select* from yjwadmin where yjwuname=? and yjwpw=?", new Object[]{user,pw});
			if(rs.next()){
				request.getSession().setAttribute("user", user);
				response.sendRedirect("Query");
			}else{
				rs=yjw.doQuery("select* from yjwadmin where yjwuname=?", new Object[]{user});
				if(rs.next()){
					response.setContentType("text/html;charset=utf-8");
					response.getWriter().println("<script>alert('√‹¬Î¥ÌŒÛ£°');history.go(-1);</script>");
				}else{
					response.setContentType("text/html;charset=utf-8");
					response.getWriter().println("<script>alert('’À∫≈≤ª¥Ê‘⁄£°');location.href='zhuce.jsp';</script>");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
