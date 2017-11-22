package Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;//导入的包http://www.cnblogs.com/mstk/p/4281724.html
import java.sql.ResultSet;
public class test {

    String driver = "com.mysql.jdbc.Driver";
    /*
     * URL指向要访问的数据库名(我用的是数据库名为test)
     * 192.168.179.128:3306 虚拟机的ip，本地用127.0.0.1
     */
    String url = "jdbc:mysql://192.168.179.134:3306/xuna?useUnicode=true&amp;characterEncoding=utf-8";
    String user = "root";      //MySQL配置时的用户名
    String password = "root";   //MySQL配置时的密码
    
    //创建一个二维数据,分配100*100的空间
    public Object[][] res = new Object[100][100];
    //throw则是指抛出的一个具体的异常类型。
    
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
            con = DriverManager.getConnection("jdbc:Access:/C:/Users/Administrator/Desktop/xuna.mdb","","");//注意是三个参数 
            System.out.print("连接数据库成功");
        }    
        catch(Exception e)  
        {  
            e.printStackTrace();
        }
        return con;
    }
    
}