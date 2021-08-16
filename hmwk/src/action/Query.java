package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entitly.bag;

import Dao.bagDao;

public class Query extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Query() {
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
	
		int pagenow=0;
		int pagesize=4;
		int pagecount=0;
		int rowcount=0;
		int strat=0;
		bagDao bdo=new bagDao();
		if(request.getParameter("page")!=null)
			pagenow=Integer.parseInt(request.getParameter("page"));
		strat=pagesize*pagenow;
		rowcount=bdo.QueryCountRow("select count(*) from yjwbag", new Object[]{});
		if(rowcount%pagesize==0)
			pagecount=rowcount/pagesize;
		else
			pagecount=rowcount/pagesize+1;
		List<bag> bag=bdo.QueryBag("select *from yjwbag limit ?,?", new Object[]{strat,pagesize});
		request.getSession().setAttribute("bag", bag);
		request.getSession().setAttribute("pagecount", pagecount);
		request.getSession().setAttribute("pagenow", pagenow);
		response.sendRedirect("yjwbaginfo.jsp");
		
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

		request.setCharacterEncoding("utf-8");
		bagDao bag=new bagDao();
		bag bags=new bag();
		String bno=request.getParameter("yjwbno");
		List<bag> bg=new ArrayList<bag>();
		bags=bag.QueryBagBybno(bno);
		bg.add(bags);
		request.getSession().setAttribute("bag", bg);
		response.sendRedirect("yjwbaginfo.jsp");
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
