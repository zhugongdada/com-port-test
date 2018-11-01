package Transnava;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 64960 on 2018.10.28.
 */
public class HtppType {
    public static String post(String url, Map<String, String> map, String encoding, String cookie) throws ParseException, IOException {
        String body = "";

        //创建httpcilent对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost post = new HttpPost(url);

        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //设置参数到请求中
        post.setEntity(new UrlEncodedFormEntity(nvps, encoding));

        System.out.print("请求地址:" + url + "\n");
        System.out.print("请求参数:" + nvps.toString() + "\n");

        //设置header信息
        post.setHeader("Content-type", "application/json;charset=utf-8");
        post.setHeader("Accept", "application/json");
        post.setHeader("Cookie", cookie);

        //执行请求操作
        CloseableHttpResponse response = client.execute(post);


        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //实体转换成String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;
    }

    public static String get(String url, Map<String, String> map, String encoding,String cookie) throws ParseException, IOException {
        String body = "";
        //创建httpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建get请求方式
        HttpGet get = new HttpGet(url);
        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //设置参数到请求中
//        get.setEntity(new UrlEncodedFormEntity(nvps, encoding));

        System.out.print("请求地址:" + url + "\n");
        System.out.print("请求参数:" + nvps.toString() + "\n");

        //设置header信息
        get.setHeader("Content-type", "application/json;charset=utf-8");
        get.setHeader("Accept", "application/json");
        get.setHeader("Cookie",cookie);

        //执行请求操作
        CloseableHttpResponse response = client.execute(get);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //实体转换成String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;
    }
}
