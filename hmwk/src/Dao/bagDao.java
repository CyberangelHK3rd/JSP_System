package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entitly.bag;

import service.MysqlConn;

public class bagDao {
	private MysqlConn yjw=new MysqlConn();
	private ResultSet rs=null;
	private int res=0;
	public List<bag> QueryBag(String sql,Object[] param){
		List<bag> bag=new ArrayList<bag>();
		try{
			rs=yjw.doQuery(sql, param);
			while(rs.next()){
				bag bg=new bag();
				bg.setYjwbno(rs.getString("yjwbno"));
				bg.setYjwbname(rs.getString("yjwbname"));
				bg.setYjwbcolor(rs.getString("yjwbcolor"));
				bg.setYjwbnumber(rs.getString("yjwbnumber"));
				bg.setYjwbprice(rs.getString("yjwbprice"));
				bag.add(bg);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return bag;
	}
	public int AddBag(bag bag){
		res=yjw.doExecute("insert into yjwbag values(?,?,?,?,?)",
				new Object[]{bag.getYjwbno(),bag.getYjwbname(),bag.getYjwbcolor(),bag.getYjwbnumber(),bag.getYjwbprice()});
		return res;
	}
	public int delete(String bno){
		res=yjw.doExecute("delete from yjwbag where yjwbno=?", new Object[]{bno});
		return res;
	}
	public bag QueryBagBybno(String bno){
		bag bag=new bag();
		try{
			rs=yjw.doQuery("select * from yjwbag where yjwbno=?", new Object[]{bno});
			if(rs.next()){
				bag.setYjwbno(rs.getString("yjwbno"));
				bag.setYjwbname(rs.getString("yjwbname"));
				bag.setYjwbcolor(rs.getString("yjwbcolor"));
				bag.setYjwbnumber(rs.getString("yjwbnumber"));
				bag.setYjwbprice(rs.getString("yjwbprice"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return bag;
	}
	public int UpdateBagBybno(String bno,bag bag){
		res=yjw.doExecute("update yjwbag set yjwbname=?,yjwbcolor=?,yjwbnumber=?,yjwbprice=? where yjwbno=?",
				new Object[]{bag.getYjwbname(),bag.getYjwbcolor(),bag.getYjwbnumber(),bag.getYjwbprice(),bno});
		return res;
	}
	public int QueryCountRow(String sql,Object[] param){
		try{
			rs=yjw.doQuery(sql, param);
			if(rs.next()){
				res=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	public int queryuser(String user){
		res=yjw.doExecute("select *from yjwadmin where yjwuname=?", new Object[]{user});
		return res;
	}
	public int adduser(String user,String pw){
		res=yjw.doExecute("insert into yjwadmin values(?,?)", new Object[]{user,pw});
		return res;
	}
}
