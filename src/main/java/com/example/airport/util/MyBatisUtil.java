package com.example.airport.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	private static SqlSessionFactory sessionFactory;

	static {
		try {
			// 1.1 xml문서 읽어오기
			// 설정파일의 인코딩정보 설정 한글처리
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);

			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");

			// 1.2 위에서 생성한 Reader객체를 이용하여 SqlSessionFactory 객체를 생성
			sessionFactory = new SqlSessionFactoryBuilder().build(rd);

			rd.close(); // 자원 정리

		} catch (IOException e) {
			// TODO: handle exception
		}

	}

	public static SqlSession getSession() {
		return sessionFactory.openSession();
	}

	public static SqlSession getSession(boolean autoCommit) {
		return sessionFactory.openSession(autoCommit);
	}
}
