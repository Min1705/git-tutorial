package DAO;

import java.sql.*;

public class KetNoi {
	public static Connection cn;

	public static void ketnoi() throws Exception {
		java.security.Security.setProperty("jdk.tls.disabledAlgorithms", "");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://MINH\\SQLEXPRESS:1433;databaseName=KetNoi;"
				+ "encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String password = "123";
		try {
			cn = DriverManager.getConnection(url, user, password);
			System.out.println("Sucseccfull!!");

		} catch (SQLException e) {
			System.out.print("error");
			e.printStackTrace();
		}
	}

	public static void Show() throws SQLException {
		// tạo stmt
		Statement statement = cn.createStatement();
		String sql = "SELECT * FROM SinhVien";
		// thực thi
		ResultSet rs = statement.executeQuery(sql);
		// xử lý
		System.out.println("Đang tìm nạp bản ghi không có điều kiện...");
		while (rs.next()) {
			String masv = rs.getString("masv");
			String hoTen = rs.getString("hoTen");
			String gioiTinh = rs.getString("gioiTinh");
			String ngaySinh = rs.getString("ngaySinh");

			// Display values
			System.out.print("masv: " + masv);
			System.out.print(", hoTen: " + hoTen);
			System.out.print(", gioiTinh: " + gioiTinh);
			System.out.println(", ngaySinh: " + ngaySinh);
		}
	}

	public static void main(String[] args) throws Exception {
		KetNoi.ketnoi();
		Show();

	}
}
