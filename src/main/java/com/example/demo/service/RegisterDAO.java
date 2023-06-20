package com.example.demo.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.demo.entity.P_Food;
import com.example.demo.entity.P_FoodPaging;
import com.example.demo.entity.P_Hospital;
import com.example.demo.entity.P_HospitalPaging;

@Repository
public class RegisterDAO {
	
	@Autowired
	private DataSource dataSource;
	
	
	// Hospital
	// 서치 + pagging list
		public P_HospitalPaging Search_paging_list(P_HospitalPaging pagingTO, String insert_address) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int cpage = pagingTO.getCpage();
			int recordPerPage = pagingTO.getRecordPerPage();
			int blockPerPage = pagingTO.getBlockPerPage();
			
			try {
				conn = dataSource.getConnection();
				
				String sql = "select h_name, h_phone, h_old_address, h_new_address from p_hospital where h_old_address like ? or h_new_address like ?";
				
				pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY  );
				pstmt.setString( 1, '%'+insert_address+'%' );
				pstmt.setString( 2, '%'+insert_address+'%' );
				rs = pstmt.executeQuery();
				
				rs.last();
				pagingTO.setTotalRecord(rs.getRow());
				
				rs.beforeFirst();
				
				pagingTO.setTotalPage(( ( pagingTO.getTotalRecord() - 1 ) / recordPerPage ) + 1 );
				
				int skip = (cpage -1) * recordPerPage;
				if (skip != 0) rs.absolute(skip);
				
				ArrayList<P_Hospital> addresslists = new ArrayList<P_Hospital>();
				
				for( int i=0; i< recordPerPage && rs.next() ; i++ ) {
					P_Hospital to = new P_Hospital();
					to.setH_name( rs.getString( "h_name" ) );
					to.setH_phone( rs.getString( "h_phone" ) );
					to.setH_old_address( rs.getString( "h_old_address" ) );
					to.setH_new_address( rs.getString( "h_new_address" ) );
					
					addresslists.add( to );
				}
				
				pagingTO.setAddressLists(addresslists);
				
				pagingTO.setStartBlock( ( ( cpage - 1 ) / blockPerPage ) * blockPerPage + 1 );
				pagingTO.setEndBlock(( ( cpage -1 ) / blockPerPage ) * blockPerPage + blockPerPage);
				if( pagingTO.getEndBlock() >= pagingTO.getTotalPage() ) {
					pagingTO.setEndBlock( pagingTO.getTotalPage() );
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println( "[에러] " + e.getMessage() );
			} finally {
				if( rs != null) try { rs.close(); } catch( SQLException e ) {}
				if( pstmt != null) try { pstmt.close(); } catch( SQLException e ) {}
				if( conn != null) try { conn.close(); } catch( SQLException e ) {}
			}	
			
			return pagingTO;
		}

	// 서치만
	public ArrayList<P_Hospital> Search_all_list(String insert_address) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<P_Hospital> lists = new ArrayList<P_Hospital>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select h_name, h_phone, h_old_address, h_new_address from p_hospital where h_old_address like ? or h_new_address like ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, '%'+insert_address+'%' );
			pstmt.setString( 2, '%'+insert_address+'%' );
			
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				P_Hospital to = new P_Hospital();
			
				to.setH_name( rs.getString( "h_name" ) );
				to.setH_phone( rs.getString( "h_phone" ) );
				to.setH_old_address( rs.getString( "h_old_address" ) );
				to.setH_new_address( rs.getString( "h_new_address" ) );
				
				lists.add( to );
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null) try { conn.close(); } catch( SQLException e ) {}
		}	
		
		return lists;
	}
	

	// Food
	// 서치 + pagging list
			public P_FoodPaging Food_category_paging_list(P_FoodPaging pagingTO, String insert_address, String select_category) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				int cpage = pagingTO.getCpage();
				int recordPerPage = pagingTO.getRecordPerPage();
				int blockPerPage = pagingTO.getBlockPerPage();
				
				try {
					conn = dataSource.getConnection();
					
					String sql = "select f_name, f_phone, f_old_address, f_new_address, p_category, f_homepage, f_time, f_detail from p_food where p_category=? and (f_old_address like ? or f_new_address like ?)";
					
					pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY  );
					pstmt.setString( 1, select_category );
					pstmt.setString( 2, '%'+insert_address+'%' );
					pstmt.setString( 3, '%'+insert_address+'%' );
					rs = pstmt.executeQuery();
					
					rs.last();
					pagingTO.setTotalRecord(rs.getRow());
					
					rs.beforeFirst();
					
					pagingTO.setTotalPage(( ( pagingTO.getTotalRecord() - 1 ) / recordPerPage ) + 1 );
					
					int skip = (cpage -1) * recordPerPage;
					if (skip != 0) rs.absolute(skip);
					
					ArrayList<P_Food> addresslists = new ArrayList<P_Food>();
					
					for( int i=0; i< recordPerPage && rs.next() ; i++ ) {
						P_Food to = new P_Food();
						to.setF_name( rs.getString( "f_name" ) );
						to.setF_phone( rs.getString( "f_phone" ) );
						to.setF_old_address( rs.getString( "f_old_address" ) );
						to.setF_new_address( rs.getString( "f_new_address" ) );
						to.setF_detail( rs.getString( "f_new_address" ) );
						to.setF_homepage( rs.getString( "f_new_address" ) );
						to.setF_time( rs.getString( "f_new_address" ) );
						to.setP_category(rs.getString("p_category"));
						addresslists.add( to );
					}
					
					pagingTO.setAddressLists(addresslists);
					
					pagingTO.setStartBlock( ( ( cpage - 1 ) / blockPerPage ) * blockPerPage + 1 );
					pagingTO.setEndBlock(( ( cpage -1 ) / blockPerPage ) * blockPerPage + blockPerPage);
					if( pagingTO.getEndBlock() >= pagingTO.getTotalPage() ) {
						pagingTO.setEndBlock( pagingTO.getTotalPage() );
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println( "[에러] " + e.getMessage() );
				} finally {
					if( rs != null) try { rs.close(); } catch( SQLException e ) {}
					if( pstmt != null) try { pstmt.close(); } catch( SQLException e ) {}
					if( conn != null) try { conn.close(); } catch( SQLException e ) {}
				}	
				
				return pagingTO;
			}

			public P_FoodPaging Food_paging_list(P_FoodPaging pagingTO, String insert_address) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				int cpage = pagingTO.getCpage();
				int recordPerPage = pagingTO.getRecordPerPage();
				int blockPerPage = pagingTO.getBlockPerPage();
				
				try {
					conn = dataSource.getConnection();
					
					String sql = "select f_name, f_phone, f_old_address, f_new_address, p_category, f_homepage, f_time, f_detail from p_food where f_old_address like ? or f_new_address like ?";
					
					pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY  );
					pstmt.setString( 1, '%'+insert_address+'%' );
					pstmt.setString( 2, '%'+insert_address+'%' );
					rs = pstmt.executeQuery();
					
					rs.last();
					pagingTO.setTotalRecord(rs.getRow());
					
					rs.beforeFirst();
					
					pagingTO.setTotalPage(( ( pagingTO.getTotalRecord() - 1 ) / recordPerPage ) + 1 );
					
					int skip = (cpage -1) * recordPerPage;
					if (skip != 0) rs.absolute(skip);
					
					ArrayList<P_Food> addresslists = new ArrayList<P_Food>();
					
					for( int i=0; i< recordPerPage && rs.next() ; i++ ) {
						P_Food to = new P_Food();
						to.setF_name( rs.getString( "f_name" ) );
						to.setF_phone( rs.getString( "f_phone" ) );
						to.setF_old_address( rs.getString( "f_old_address" ) );
						to.setF_new_address( rs.getString( "f_new_address" ) );
						to.setF_detail( rs.getString( "f_new_address" ) );
						to.setF_homepage( rs.getString( "f_new_address" ) );
						to.setF_time( rs.getString( "f_new_address" ) );
						to.setP_category(rs.getString("p_category"));
						
						addresslists.add( to );
					}
					
					pagingTO.setAddressLists(addresslists);
					
					pagingTO.setStartBlock( ( ( cpage - 1 ) / blockPerPage ) * blockPerPage + 1 );
					pagingTO.setEndBlock(( ( cpage -1 ) / blockPerPage ) * blockPerPage + blockPerPage);
					if( pagingTO.getEndBlock() >= pagingTO.getTotalPage() ) {
						pagingTO.setEndBlock( pagingTO.getTotalPage() );
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println( "[에러] " + e.getMessage() );
				} finally {
					if( rs != null) try { rs.close(); } catch( SQLException e ) {}
					if( pstmt != null) try { pstmt.close(); } catch( SQLException e ) {}
					if( conn != null) try { conn.close(); } catch( SQLException e ) {}
				}	
				
				return pagingTO;
			}
			
			// 서치만
		public ArrayList<P_Food> Food_category_all_list(String insert_address, String select_category) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ArrayList<P_Food> lists = new ArrayList<P_Food>();
			
			try {
				conn = dataSource.getConnection();
				
				String sql = "select f_name, f_phone, f_old_address, f_new_address, p_category, f_homepage, f_time, f_detail from p_food where p_category=? and (f_old_address like ? or f_new_address like ?)";
				pstmt = conn.prepareStatement( sql );
				pstmt.setString( 1, select_category );
				pstmt.setString( 2, '%'+insert_address+'%' );
				pstmt.setString( 3, '%'+insert_address+'%' );
				
				rs = pstmt.executeQuery();
				while( rs.next() ) {
					P_Food to = new P_Food();
				
					to.setF_name( rs.getString( "f_name" ) );
					to.setF_phone( rs.getString( "f_phone" ) );
					to.setF_old_address( rs.getString( "f_old_address" ) );
					to.setF_new_address( rs.getString( "f_new_address" ) );
					to.setP_category(rs.getString("p_category"));
					to.setF_detail(rs.getString("f_detail"));
					to.setF_homepage(rs.getString("f_homepage"));
					to.setF_time(rs.getString("f_time"));
					
					lists.add( to );
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println( "[에러] " + e.getMessage() );
			} finally {
				if( rs != null) try { rs.close(); } catch( SQLException e ) {}
				if( pstmt != null) try { pstmt.close(); } catch( SQLException e ) {}
				if( conn != null) try { conn.close(); } catch( SQLException e ) {}
			}	
			
			return lists;
		}
		
		public ArrayList<P_Food> Food_all_list(String insert_address) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ArrayList<P_Food> lists = new ArrayList<P_Food>();
			
			try {
				conn = dataSource.getConnection();
				
				String sql = "select f_name, f_phone, f_old_address, f_new_address, p_category, f_homepage, f_time, f_detail from p_food where f_old_address like ? or f_new_address like ?";
				pstmt = conn.prepareStatement( sql );
				pstmt.setString( 1, '%'+insert_address+'%' );
				pstmt.setString( 2, '%'+insert_address+'%' );
				
				rs = pstmt.executeQuery();
				while( rs.next() ) {
					P_Food to = new P_Food();
				
					to.setF_name( rs.getString( "f_name" ) );
					to.setF_phone( rs.getString( "f_phone" ) );
					to.setF_old_address( rs.getString( "f_old_address" ) );
					to.setF_new_address( rs.getString( "f_new_address" ) );
					to.setP_category(rs.getString("p_category"));
					to.setF_detail(rs.getString("f_detail"));
					to.setF_homepage(rs.getString("f_homepage"));
					to.setF_time(rs.getString("f_time"));
					
					lists.add( to );
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println( "[에러] " + e.getMessage() );
			} finally {
				if( rs != null) try { rs.close(); } catch( SQLException e ) {}
				if( pstmt != null) try { pstmt.close(); } catch( SQLException e ) {}
				if( conn != null) try { conn.close(); } catch( SQLException e ) {}
			}	
			
			return lists;
		}
		

}
