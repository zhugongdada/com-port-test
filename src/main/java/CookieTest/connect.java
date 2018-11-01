package CookieTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 64960 on 2018.10.28.
 */
public class connect {
    String cookie="";
    public static void main(String[] agrs){

    }
    public void Connect(String u) throws IOException {
        HttpURLConnection conn = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            URL url = new URL(u);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            os = conn.getOutputStream();
            String param = "account=senninha&password=senninha";
            String eparam = param;
            //这里是把post参数携带上去。
            os.write(eparam.getBytes("utf-8"));
            is = conn.getInputStream();
            byte[] b = new byte[1024];
            int len = is.read(b);
            while (len != -1) {
                System.out.println(new String(b, 0, len, "utf-8"));
                len = is.read(b);
            }
            //这里是读取第一次登陆时服务器返回的cookie，然后用一个全局变量cookie接收。因为是服务器往客户端发送cookie，所以名字是Set-Cookie
            cookie = conn.getHeaderField("Set-Cookie");
            System.out.println("read over" + cookie);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (os != null) {
                os.close();
            }

            if (is != null) {
                is.close();
            }
            if (conn != null) {
                conn.disconnect();
            }

            System.out.println("all close");
        }
    }

    public void isLogin(String u) throws IOException{
        HttpURLConnection conn = null;
        InputStream is = null;
        try {
            URL url = new URL(u);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            //把上一步获取的cookie携带上去
            conn.setRequestProperty("cookie", cookie);
            conn.setDoInput(true);
            is = conn.getInputStream();
            byte[] b = new byte[1024];
            int len = is.read(b);
            while(len != -1){
                System.out.println(new String(b,0,len,"utf-8"));
                len = is.read(b);
            }
            System.out.println("read over");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   finally{
            if(is != null){
                is.close();
            }
            if(conn != null){
                conn.disconnect();
            }

        }
        System.out.println("all close");
    }

}
