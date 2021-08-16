package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

import service.ExcelBook;
import service.MysqlConn;

public class yjwexcel extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private ServletConfig config;
	public final void init(ServletConfig config) throws ServletException{
		this.config=config;
	}
	public yjwexcel() {
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

		MysqlConn yjw=new MysqlConn();
		ResultSet rs=null;
		ExcelBook book=new ExcelBook();
		rs=yjw.doQuery("select *from yjwbag", new Object[]{});
		book.excelOut("D:/学生信息.xls", rs, new Object[]{"编号","名称","颜色","库存","单价"});
		SmartUpload myload=new SmartUpload();
		try{
			myload.initialize(config, request, response);
			myload.downloadFile("D:/学生信息.xls");
			java.io.File file=new java.io.File("D:/学生信息.xls");
			if(file.exists()){
				file.delete();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
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

		String path="D:/学生信息.xls";
		SmartUpload myload=new SmartUpload();
		try{
			myload.initialize(config, request, response);
			myload.upload();
			File file=myload.getFiles().getFile(0);
			file.saveAs(path);
			ExcelBook book=new 	ExcelBook();
			MysqlConn yjw=new MysqlConn();
			ArrayList<String[]> list=book.ExcelIn(path);
			for(int i=1;i<list.size();i++){
				yjw.doExecute("insert into yjwbag values(?,?,?,?,?)", list.get(i));
			}
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('导入成功！');location.href='Query';</script>");
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
