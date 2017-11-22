package xuna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;//导入的包http://www.cnblogs.com/mstk/p/4281724.html
import java.sql.ResultSet;
public class database {

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
    /*
    public static void main(String[] args) throws SQLException
    { 
    	database a = new database();
        a.select("Person");
        //a.update();
        //a.insert();
        //a.delete();
        //a.select();  
    }*/
    public  Connection getConn() 
    {
        Connection con = null;
        try 
        {  /*mysql加载驱动程序
            Class.forName(driver); 
            con = DriverManager.getConnection(url,user,password);//注意是三个参数 
            System.out.print("连接数据库成功");
            */
        	//加载access数据库
        	Class.forName("com.hxtt.sql.access.AccessDriver"); 
            con = DriverManager.getConnection("jdbc:Access:/E:/Java 实训/Person Manager System/xuna.mdb","","");//注意是三个参数 
            System.out.print("连接数据库成功");
        }    
        catch(Exception e)  
        {  
            e.printStackTrace();
        }
        return con;
    }
    /*
     * 查询操作
     */

    public Object[][] select(String table_name) throws SQLException
    {  
        String sql = "select * from "+table_name;  
        Connection con = getConn();//此处为通过自己写的方法getConn()获得连接  
        try{

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); //ResultSet类，用来存放获取的结果集！！
            //System.out.print(rs);
            int i=0,j=0;
            while(rs.next())
            {
                res[i][j++] = rs.getString(1);
                res[i][j++] = rs.getString("Name");
                res[i][j++] = rs.getString("Sex");
                res[i][j++] = rs.getString("Birth");
                res[i][j++] = rs.getString("Nat");
                res[i][j++] = rs.getString("Address");
                res[i][j++] = rs.getString("DeptID");
                i++;
                System.out.println(rs.getString(2));
            }
            System.out.println("database:");
            for(int i1=0; i1<res[0].length; i1++)
    		{
    			System.out.println(res[0][i1]);
    		}
            System.out.print(res.length);
            rs.close();
            con.close();
        }
        catch(SQLException e)
        {      
            e.printStackTrace();   
        } 
        return res;
    }
    /*
     * 插入操作
     */

    public int insert() 
    {

        int i = 0;
        Connection con = getConn();
        String sql = "insert into table_test (id, name, cell) values (?, ?, ?)";
        try {
            //用来执行SQL语句
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setLong(1,4);
            pst.setString(2, "许娜");
            pst.setString(3, "123344"); 
            i = pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(i);
        return i; //返回影响的行数，1为执行成功
    }
    /*
     * 更新操作
     */
    public int update() 
    {
        int i=0;
        String sql = "update table_test set id=?,name=?,cell=? where id =?";
        Connection con=getConn();
        try {
            //用来执行SQL语句
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setLong(1,1);
            pst.setString(2, "小例");
            pst.setString(3, "45654");
            pst.setLong(4, 1);
            i = pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(i);
        return i;
    }
    /*
     * 删除操作
     */
    public int delete() {

        String sql = "delete from table_test where id=1";
        int i=0;
        Connection con = getConn();
        try {

            Statement stmt = con.createStatement();
            i = stmt.executeUpdate(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}