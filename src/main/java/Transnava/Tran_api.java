package Transnava;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 64960 on 2018.10.28.
 */
public class Tran_api {

    public static String host="http://192.168.0.40:2080";
    public static String cookie="JSESSIONID=B8044826CE04A70D70A03AF938B39949; uid=51373964114661376; token=e00756464561f39563e289d980388345";


    @Test//首页年龄事件统计
    public void AgeCount() throws ParseException, IOException {
        String url="/transnova-government-web/home/getLastWeeklyAgeCount";
        String sgin=host+url;
        Map<String, String> map = new HashMap<String, String>();
//        map.put("driverId","100001");

        String body = HtppType.get(sgin, map, "utf-8",cookie);
//        System.out.println("响应结果：" + body );

        JSONObject json1=JSONObject.fromObject(body);
        Map<String , Object> map1=json1;
            for (Map.Entry<String, Object> entry : map1.entrySet()) {
                System.out.println(entry.getKey() + "==" + entry.getValue());
            }

//        JSONArray jsonArray=json1.getJSONArray("data");
//        for (int i=0;i<jsonArray.size();i++){
//            System.out.println(jsonArray.getJSONObject(i).get("title"));
//        }
//        System.out.println(jsonArray.getJSONObject(0).get("title"));
    }

    @Test //首页安全事件统计
    public void  Eventcountlastweek() throws ParseException, IOException{
        String url="/transnova-government-web/home/getEventCountLastWeek";
        String sgin=host+url;
        Map<String, String> map = new HashMap<String, String>();
//        map.put("driverId","100001");

        String body = HtppType.get(sgin, map, "utf-8",cookie);
//        System.out.println("响应结果：" + body );

        JSONObject json1=JSONObject.fromObject(body);
        JSONArray jsonArray=json1.getJSONArray("data");
        //获取驾驶不在驾驶位置的次数
        System.out.println("驾驶不在驾驶位置的次数:"+jsonArray.getJSONObject(0).get("count"));
    }

}
