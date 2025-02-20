package com.example.airport.dao;


import com.example.airport.util.MyBatisUtil;
import com.example.airport.vo.MemVO;
import org.apache.ibatis.session.SqlSession;

public class MemberDaoImp implements IMemberDAO{
	private static MemberDaoImp dao;
	
	private MemberDaoImp() {
	
	}
	
	public static MemberDaoImp getInstance() {
		if(dao == null) dao = new MemberDaoImp();
		return dao;
	}
	
	@Override
	public int memberIdCount(String memId) {
		SqlSession session = null;

		int count = 0;
		
		try {
			session = MyBatisUtil.getSession();
			count = session.selectOne("member.memberIdCount",memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return count;
	}

	@Override
	public int insertMember(MemVO memVO) {
		SqlSession session = null;
		int count = 0;
		
		try {
			session = MyBatisUtil.getSession();
			count = session.insert("member.insertMember",memVO);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			if(session!=null) session.close();
		}
		return count;
	}
	

}
