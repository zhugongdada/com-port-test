package Testutils;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

/**
 * Created by tianhualiang on 2018/8/27.
 */
public class TestHttpHelper {
    public static String Post() throws Exception {

        //拼接URL地址
        String url = "http://192.168.0.40:2080/transnova-government-web/user/login";
        //返回结果
        String result ="";
        JSONObject json = new JSONObject();
        json.put("username","transnova");
        json.put("password","123456");
        json.put("code","abcd");

        //创建post请求对象
        HttpPost post=new HttpPost(url);

        post.setHeader("Accept","application/json");
        post.setHeader("Content-Type","application/json;charset=utf-8");

        //实现链接的建立
        HttpClient client = HttpClientBuilder.create().build();
            try {
                RequestConfig requestConfig=RequestConfig.custom()
                        .setSocketTimeout(10000)
                        .setConnectTimeout(10000)
                        .setConnectionRequestTimeout(10000)
                        .build();
                post.setConfig(requestConfig);

                //进行响应设置
                StringEntity s = new StringEntity(json.toString(),"UTF-8");//消息体的格式
                s.setContentEncoding("utf-8");
                s.setContentType("application/json;charset=utf-8");
                post.setEntity(s);

                //进行响应断言
                HttpResponse res = client.execute(post);
                System.out.println(post);
                if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                    result= EntityUtils.toString(res.getEntity());
                }
                System.out.println(result);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        return result;
    }
    public static void main(String[] args) throws Exception{
       Post();
    }
}