package ExampleDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import ExampleVO.regVO;
import JDBC_Connection.jdbc_Connection;

public class regDao {

	jdbc_Connection con = new jdbc_Connection();
	
	public void insertReg(regVO rvo) throws ClassNotFoundException, SQLException 
	{
		String q = "INSERT INTO registerlogin (email, userName, password) VALUES ('"+rvo.getEmail()+"', '"+rvo.getUname()+"',"
				+ " '"+rvo.getPassword()+"')";
		
		con.Connection_JDBC().execute(q);
		
	}

	public List<regVO> ListAll() throws ClassNotFoundException, SQLException 
	{
		List<regVO> list = new ArrayList<regVO>();
		
		String q = "select * from registerlogin";
		
		ResultSet rs =  con.Connection_JDBC().executeQuery(q);
		
		while(rs.next())
		{
			regVO rvo = new regVO();
			
			rvo.setId(rs.getInt(1));
			rvo.setEmail(rs.getString(2));
			rvo.setUname(rs.getString(3));
			rvo.setPassword(rs.getString(4));
			list.add(rvo);
			
			//System.out.println("EMAIL: "+rvo.getEmail());
		}
		
		return list;
	}

	public regVO getRegValueById(String id) throws ClassNotFoundException, SQLException {
		
		regVO rvo = new regVO();
		
		String q = "select * from registerlogin where id = "+id+"";
		
		ResultSet rs =  con.Connection_JDBC().executeQuery(q);
		
		while(rs.next()){
			
			rvo.setId(rs.getInt(1));
			rvo.setEmail(rs.getString(2));
			rvo.setUname(rs.getString(3));
			rvo.setPassword(rs.getString(4));
		}
		
		return rvo;
	}

	public void UpdateReg(regVO rvo) throws ClassNotFoundException, SQLException 
	{
		String q = "UPDATE registerlogin SET email ='"+rvo.getEmail()+"', userName ='"+rvo.getUname()+"',"
				+ " password ='"+rvo.getPassword()+"' WHERE id ='"+rvo.getId()+"'";
		
		con.Connection_JDBC().execute(q);
		
	}

	public void DeleteReg(int id) throws ClassNotFoundException, SQLException 
	{
		String q = "delete from registerlogin where id = "+id+"";
		
		con.Connection_JDBC().execute(q);
		
	}

}
