package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BoardMemberDTO;
import oracle.jdbc.pool.OracleDataSource;

public class BoardMemberDAO {
	private static BoardMemberDAO instance = new BoardMemberDAO();
	private OracleDataSource ods;
	
	private BoardMemberDAO() {
		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@127.0.0.1:1521/xe");
			ods.setUser("c##scott");
			ods.setPassword("123456");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static BoardMemberDAO getInstance() {
		if(instance == null)
			instance = new BoardMemberDAO();
		return instance;
	}

	//전체 회원정보 조회
	public ArrayList<BoardMemberDTO> selectAllMember() {
		String sql = "select * from board_member";
		ArrayList<BoardMemberDTO> list = new ArrayList<BoardMemberDTO>();
		//접속 정보 획득 후 SQL 실행할 준비
		try(Connection conn = ods.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			//SQL문 실행
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					//데이터를 한건씩 뽑아서 리스트에 추가
					BoardMemberDTO dto = new BoardMemberDTO();
					dto.setBoardMemberId(rs.getString("BOARD_MEMBER_ID"));
					dto.setBoardMemberName(rs.getString("BOARD_MEMBER_NAME"));
					dto.setBoardMemberPasswd(rs.getString("BOARD_MEMBER_PASSWD"));
					dto.setBoardMemberNick(rs.getString("BOARD_MEMBER_NICK"));
					list.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int insertBoardMember(BoardMemberDTO dto) {
		String sql = "insert into board_member values(?,?,standard_hash(?,'SHA512'),?)";
		int row = 0;
		try (Connection conn = ods.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			//1. 데이터 셋팅
			pstmt.setString(1, dto.getBoardMemberId());
			pstmt.setString(2, dto.getBoardMemberName());
			pstmt.setString(3, dto.getBoardMemberPasswd());
			pstmt.setString(4, dto.getBoardMemberNick());
			//2. SQL 실행
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public int deleteMember(String id) {
		int row = 0;
		
		//회원정보 한건 삭제하는 코드 작성 - insertBoardMember 참고해서 작업
		String sql = "delete from board_member where board_member_id like ?";
		
		try(PreparedStatement pstmt = ods.getConnection().prepareStatement(sql)){
			pstmt.setString(1, id);
			row = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}

	public BoardMemberDTO selectMember(String id) {
		BoardMemberDTO dto = null;
		String sql = "select * from board_member where board_member_id like ?";
		try(Connection conn = ods.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
				pstmt.setString(1, id);
				//SQL문 실행
				try(ResultSet rs = pstmt.executeQuery()){
					while(rs.next()) {
						//데이터를 한건씩 뽑아서 리스트에 추가
						dto = new BoardMemberDTO();
						dto.setBoardMemberId(rs.getString("BOARD_MEMBER_ID"));
						dto.setBoardMemberName(rs.getString("BOARD_MEMBER_NAME"));
						dto.setBoardMemberPasswd(rs.getString("BOARD_MEMBER_PASSWD"));
						dto.setBoardMemberNick(rs.getString("BOARD_MEMBER_NICK"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return dto;
	}

	public int updateMember(BoardMemberDTO dto) {
		String sql = "update board_member set  board_member_name = ?, "
				+ "board_member_passwd = standard_hash(?,'SHA512'), "
				+ "board_member_nick = ? where board_member_id like ?";
		int row = 0;
		try (Connection conn = ods.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			//1. 데이터 셋팅
			pstmt.setString(1, dto.getBoardMemberName());
			pstmt.setString(2, dto.getBoardMemberPasswd());
			pstmt.setString(3, dto.getBoardMemberNick());
			pstmt.setString(4, dto.getBoardMemberId());
			//2. SQL 실행
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public BoardMemberDTO login(String id, String passwd) {
		BoardMemberDTO dto = null;
		String sql = "SELECT * FROM BOARD_MEMBER "
				+ "WHERE BOARD_MEMBER_ID LIKE ? AND "
				+ "BOARD_MEMBER_PASSWD LIKE STANDARD_HASH(?,'SHA512')";
		try(Connection conn = ods.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
				pstmt.setString(1, id);
				pstmt.setString(2, passwd);
				//SQL문 실행
				try(ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) {
						//데이터를 한건씩 뽑아서 리스트에 추가
						dto = new BoardMemberDTO();
						dto.setBoardMemberId(rs.getString("BOARD_MEMBER_ID"));
						dto.setBoardMemberName(rs.getString("BOARD_MEMBER_NAME"));
						dto.setBoardMemberPasswd(rs.getString("BOARD_MEMBER_PASSWD"));
						dto.setBoardMemberNick(rs.getString("BOARD_MEMBER_NICK"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return dto;
	}
	
}







