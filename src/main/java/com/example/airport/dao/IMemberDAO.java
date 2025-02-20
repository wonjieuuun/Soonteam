package com.example.airport.dao;


import com.example.airport.vo.MemVO;

public interface IMemberDAO {
//	중복검사
	public int memberIdCount(String memId);
//	insert
	public int insertMember(MemVO memVO);
}
