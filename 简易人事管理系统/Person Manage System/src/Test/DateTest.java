package Test;

import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  
  
public class DateTest {  
  
    public static void main(String[] args) throws ParseException {  
       
  
        Date d = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateNowStr = sdf.format(d);  
        System.out.println("��ʽ��������ڣ�" + dateNowStr);  
          
    }  
}  