package _test.buseo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import _common.DB;
import _test.buseo.model.dto.BuseoDTO;

public class BuseoDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
		public ArrayList<BuseoDTO> getSelectAll() {
			ArrayList<BuseoDTO> list = new ArrayList<>();
			conn = DB.dbConn();
			try {
				String sql = "select * from buseo order by buseoNo desc";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BuseoDTO dto = new BuseoDTO();
					dto.setBuseoNo(rs.getInt("buseoNo"));
					dto.setBuseo(rs.getString("buseo"));
					dto.setRegiDate(rs.getDate("regiDate"));
					list.add(dto);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DB.dbConnClose(rs, pstmt, conn);
			}
			return list;
		}
		public BuseoDTO getSelectOne(BuseoDTO paramDto) {
			BuseoDTO dto = new BuseoDTO();
			conn = DB.dbConn();
			try {
				String sql = "select * from buseo where buseoNo=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, paramDto.getBuseoNo());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					dto.setBuseoNo(rs.getInt("buseoNo"));
					dto.setBuseo(rs.getString("buseo"));
					dto.setRegiDate(rs.getDate("regiDate"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DB.dbConnClose(rs, pstmt, conn);
			}
			return dto;
		}
		public int setInsert(BuseoDTO paramDto) {
			int result = 0;
			conn = DB.dbConn();
			try {
				String sql = "insert into buseo values(seq_buseoNo.nextval,?,sysdate)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(2, paramDto.getBuseo());
				result = pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DB.dbConnClose(rs, pstmt, conn);
			}
			return result;
		}
		public int setUpdate(BuseoDTO paramDto) {
			int result = 0;
			conn = DB.dbConn();
			try {
				String sql = "update buseo set buseo=? where buseoNo=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, paramDto.getBuseo());
				pstmt.setInt(2, paramDto.getBuseoNo());
				result = pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DB.dbConnClose(rs, pstmt, conn);
			}
			return result;
		}
		public int setDelete(BuseoDTO paramDto) {
			int result = 0;
			conn = DB.dbConn();
			try {
				String sql = "delete from buseo where buseoNo=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, paramDto.getBuseoNo());
				result = pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DB.dbConnClose(rs, pstmt, conn);
			}
			return result;
		}
}
