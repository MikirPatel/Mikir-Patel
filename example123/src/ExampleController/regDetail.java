package ExampleController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ExampleDao.regDao;
import ExampleVO.regVO;

/**
 * Servlet implementation class regDetail
 */
@WebServlet("/regDetail")
public class regDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("RegInsert")){
			
			try {
				InsertReg(request,response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(flag.equals("listall"))
		{
			try {
				ListAll(request,response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(flag.equals("updatereg")){
			
			try {
				GetUpdateData(request,response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(flag.equals("RegUpdate"))
		{
			try {
				UpdateReg(request,response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(flag.equals("RegDelete")){
			
			try {
				DeleteReg(request,response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

	private void DeleteReg(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		regDao rdao = new regDao();
		
		rdao.DeleteReg(id);
		
		ListAll(request, response);
		
	}

	private void UpdateReg(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException 
	{
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		regVO rvo = new regVO();
		regDao rdao = new regDao();
		
		rvo.setId(Integer.parseInt(id));
		rvo.setEmail(email);
		rvo.setUname(uname);
		rvo.setPassword(pass);
		
		rdao.UpdateReg(rvo);
		
		ListAll(request, response);
		
	}

	private void GetUpdateData(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException 
	{
		String id = request.getParameter("id");
		
		regDao rdao = new regDao();
		regVO rvo = new regVO();
		
		rvo = rdao.getRegValueById(id);
		
		request.setAttribute("getvalue", rvo);
		request.getRequestDispatcher("UpdateReg.jsp").forward(request, response);
		
	}

	private void InsertReg(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException 
	{
		
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		regVO rvo = new regVO();
		regDao rdao = new regDao();
		
		rvo.setEmail(email);
		rvo.setUname(uname);
		rvo.setPassword(pass);
		
		rdao.insertReg(rvo);
		
		response.sendRedirect("InsertReg.jsp");
		
	}
	private void ListAll(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException 
	{
		regDao rdao = new regDao();
		
		List<regVO> list = new ArrayList<regVO>();
		
		list = rdao.ListAll();
		
		//System.
		
		request.setAttribute("listall", list);
		
		request.getRequestDispatcher("regList.jsp").forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
