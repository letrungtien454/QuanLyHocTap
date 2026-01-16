package doan.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=QLKhoaHoc;encrypt=false";
    private static final String user = "sa";
    private static final String pass = "123";

    public static Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, user, pass);
    }

    // Test nhanh
    public static void main(String[] args) {
        try {
            Connection c = DBContext.getConnection();
            System.out.println("KẾT NỐI SQL THÀNH CÔNG!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
