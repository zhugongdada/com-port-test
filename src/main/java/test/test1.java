package test;

import JDBC.DBTest;
import JDBC.DBUtil;
import JDBC.GET_paramter;
import JDBC.Inset_result;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hades on 2018/6/29.
 */
public class test1 {
    public static void main(String[] args) throws Exception{
//        try {
//            GET_paramter.expected_test();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
            Connection con;
            try {
                con = DBTest.getCon();
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            String sql = "SELECT T.* ,E.NAME FROM (select event,count(1) from event_log_analyze where companyId =  5 and startTime > date'2018-09-05'  group by event) t LEFT JOIN EVENT E ON E.CODE = T.EVENT;";

            try {
//             DBUtil.executeUpdate(con, sql);
                List list= DBUtil.executeQuery(con, sql);
                System.out.print(list+"\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
