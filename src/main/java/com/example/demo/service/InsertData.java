package com.example.demo.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class InsertData {
	
	@Autowired
	private DataSource dataSource;
	
	public void InsertHospitalData() {

		Connection conn= null;;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			conn = dataSource.getConnection();
	
			Reader reader = new FileReader("./src/main/webapp/datas/fulldata_동물병원.json");
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(reader);
			
			JSONArray jsonArr = ( JSONArray ) obj;

			int flag = 0;
			for( int i = 0; i < jsonArr.size() ; i ++ ) {
				JSONObject jsonObj = ( JSONObject ) jsonArr.get(i);
				
				//System.out.println(jsonObj.get("사업장명"));
				//System.out.println(jsonObj.get("개방자치단체코드"));
				//System.out.println(jsonObj.get("영업상태명"));
				//System.out.println(jsonObj.get("소재지전화"));
				//System.out.println((String) jsonObj.get("소재지전체주소"));
				//System.out.println(jsonObj.get("도로명전체주소"));
				//System.out.println(jsonObj.get("좌표정보(x)"));
				
				if(jsonObj.get("영업상태명").equals("영업/정상")) {
					String sql = String.format("insert into p_hospital values ( 0,'%s','%s','%s','%s','%s','%s');",
							(String) jsonObj.get("개방자치단체코드"),(String) jsonObj.get("영업상태명"),
							(String) jsonObj.get("소재지전화"),(String) jsonObj.get("소재지전체주소"),
							(String) jsonObj.get("도로명전체주소"), (String) jsonObj.get("사업장명"));
					
					pstmt = conn.prepareStatement(sql);
					pstmt.executeUpdate();
					flag++;
				}
			}
			System.out.println("데이터 입력 성공 : " + flag +"건");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null) try { conn.close(); } catch( SQLException e ) {}
		}
		
	}

	public void InsertPetData() {

		Connection conn= null;;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			conn = dataSource.getConnection();
	
			Reader reader = new FileReader("./src/main/webapp/datas/_반려동물 동반 문화시설 위치 데이터.json");
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(reader);
			
			JSONArray jsonArr = ( JSONArray ) obj;

			int flag = 0;
			for( int i = 0; i < jsonArr.size() ; i ++ ) {
				JSONObject jsonObj = ( JSONObject ) jsonArr.get(i);
				
				//System.out.println(jsonObj.get("사업장명"));
				//System.out.println(jsonObj.get("개방자치단체코드"));
				//System.out.println(jsonObj.get("영업상태명"));
				//System.out.println(jsonObj.get("소재지전화"));
				//System.out.println((String) jsonObj.get("소재지전체주소"));
				//System.out.println(jsonObj.get("도로명전체주소"));
				//System.out.println(jsonObj.get("좌표정보(x)"));
				
				if(jsonObj.get("반려동물 동반 가능정보").equals("동반가능")) {
					if(jsonObj.get("카테고리3").equals("카페") || jsonObj.get("카테고리3").equals("식당")) {
						String sql = String.format("insert into p_food values ( 0,'%s','%s','%s','%s','%s','%s','%s','%s');",
							(String) jsonObj.get("카테고리3"),
							(String) jsonObj.get("시설명"),(String) jsonObj.get("전화번호"),
							(String) jsonObj.get("지번주소"),(String) jsonObj.get("도로명주소"),
							(String) jsonObj.get("홈페이지"), (String) jsonObj.get("운영시간"),
							(String) jsonObj.get("기본 정보_장소설명"));
					
						pstmt = conn.prepareStatement(sql);
						pstmt.executeUpdate();
						flag++;
					}
				}
			}
			System.out.println("데이터 입력 성공 : " + flag +"건");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null) try { conn.close(); } catch( SQLException e ) {}
		}
		
	}
}
