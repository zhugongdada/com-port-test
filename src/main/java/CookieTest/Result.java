package CookieTest;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Created by 64960 on 2018.10.28.
 */
public class Result {
    public int code;
    public Data1 data;


    public static class Data1{
        public Page page;

    }

    public  static class  Page{
        public List<Data2> data = new ArrayList<>();

    }

    public static class Data2{
        public Comp company;

    }

    public static class Comp{
        public String operationStatus;
        public Date updateDate;
        public String name;
    }
}
