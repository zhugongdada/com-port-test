package JDBC;

import entities.Expected;
import entities.Scenario;
import entities.Step;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
*获取表expected、scenario、step的数据
*expected表中包含预期结果
* scenario表中包含场景
* step表中测试步骤
 */
public class GET_paramter {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.0.40:3306/transnova?useSSL=false";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "6yhn7ujm";

    public static List<Scenario> getScenarioList()
    {
        return null;
    }

    public static List<Step> getStepList(int scenarioId)
    {
        return null;
    }

    public static List<Expected> getExpectedList(int scenarioId)
    {
        return null;
    }

    //获取接口调用的预期结果
    public static Object[][] expected_test() throws IOException {

        List<Object[]> records = new ArrayList<Object[]>();
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (!conn.isClosed()) {
                System.out.print("连接数据库成功"+"\n");
            }
            Statement statement = conn.createStatement();

            String sql = "SELECT T.* ,E.NAME FROM (select event,count(1) from event_log_analyze where companyId =  5 and startTime > date'2018-09-05'  group by event) t LEFT JOIN EVENT E ON E.CODE = T.EVENT;";

            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData reMetaData = rs.getMetaData();
            int cols = reMetaData.getColumnCount();
            while (rs.next()) {
                String fields[] = new String[cols];
                int col = 0;
                for (int colIdx = 0; colIdx < cols; colIdx++) {
                    fields[col] = rs.getString(colIdx + 1);
                    col++;
                }
                records.add(fields);
//                System.out.print(rs.getString(1)+"\n");
//                System.out.print(rs.getString(2)+"\n");
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.print("未能找到Mysql的驱动类"+"\n");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
        Object[][] results = new Object[records.size()][];
        for (int i = 0; i < records.size(); i++) {
            results[i] = records.get(i);
        }

        return results;
    }

}
