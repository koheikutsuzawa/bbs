package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDto;

public class BoardDao {

	//private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/bbsdb";
	private final String USER_ID = "user_k";
	private final String USER_PASS = "pass4579";

	public List<BoardDto> findAll() {
		List<BoardDto> dtoList = new ArrayList<BoardDto>();

		try(Connection con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS)) {
			String sql = "SELECT ID, NAME, COMMENT, TIME FROM board";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("NAME"));
				dto.setComment(rs.getString("COMMENT"));
				dto.setTime(rs.getTimestamp("TIME"));
				dtoList.add(dto);
			}

		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return dtoList;

	}

	public void doInsert(BoardDto dto) {

		try(Connection con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS)) {
			String sql = "INSERT INTO board (NAME, COMMENT) VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(sql.toString());
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getComment());
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
