package Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;//����İ�http://www.cnblogs.com/mstk/p/4281724.html
import java.sql.ResultSet;
public class test {

    String driver = "com.mysql.jdbc.Driver";
    /*
     * URLָ��Ҫ���ʵ����ݿ���(���õ������ݿ���Ϊtest)
     * 192.168.179.128:3306 �������ip��������127.0.0.1
     */
    String url = "jdbc:mysql://192.168.179.134:3306/xuna?useUnicode=true&amp;characterEncoding=utf-8";
    String user = "root";      //MySQL����ʱ���û���
    String password = "root";   //MySQL����ʱ������
    
    //����һ����ά����,����100*100�Ŀռ�
    public Object[][] res = new Object[100][100];
    //throw����ָ�׳���һ��������쳣���͡�
    
    public static void main(String[] args) throws SQLException
    { 
    	test a = new test();
    	a.getConn();
    }
    public  Connection getConn() 
    {
        Connection con = null;
        try  
        {
            Class.forName("com.hxtt.sql.access.AccessDriver"); 
            con = DriverManager.getConnection("jdbc:Access:/C:/Users/Administrator/Desktop/xuna.mdb","","");//ע������������ 
            System.out.print("�������ݿ�ɹ�");
        }    
        catch(Exception e)  
        {  
            e.printStackTrace();
        }
        return con;
    }
    
}