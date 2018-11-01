package JDBC;

import entities.Result;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
*进行赛事参数的插入
 */
public class Inset_result {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://172.21.120.240:3306/ccoptest";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "test";
    static final String PASS = "imsa1qaz@WSX";

    //连接test数据库
    //写入赛事数据

    public static void Insert(Result result) {

    }

    public static Object[][] insettest() throws IOException {

        List<Object[]> records = new ArrayList<Object[]>();
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (!conn.isClosed()) {
                System.out.print("连接数据库成功");
            }
            Statement statement = conn.createStatement();

            String sql = "INSERT INTO result (MatchNumber,ScenarioId,StepId,ExcepctedId," +
                    "ExcepctedContent,ActualContent) " +
                    "VALUES('118645G93D2701000011',1,1,1,'啊，这是预期结果','额，这是结果异常的结果');";
//                System.out.print(sql);
//            ResultSet rs = statement.executeUpdate(sql);
            statement.executeUpdate(sql);
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.print("未能找到Mysql的驱动类");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[][] results = new Object[records.size()][];
        for (int i = 0; i < records.size(); i++) {
            results[i] = records.get(i);
        }
        return results;
    }
}
