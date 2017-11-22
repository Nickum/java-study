package xuna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;//����İ�http://www.cnblogs.com/mstk/p/4281724.html
import java.sql.ResultSet;
public class database {

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
        {  /*mysql������������
            Class.forName(driver); 
            con = DriverManager.getConnection(url,user,password);//ע������������ 
            System.out.print("�������ݿ�ɹ�");
            */
        	//����access���ݿ�
        	Class.forName("com.hxtt.sql.access.AccessDriver"); 
            con = DriverManager.getConnection("jdbc:Access:/E:/Java ʵѵ/Person Manager System/xuna.mdb","","");//ע������������ 
            System.out.print("�������ݿ�ɹ�");
        }    
        catch(Exception e)  
        {  
            e.printStackTrace();
        }
        return con;
    }
    /*
     * ��ѯ����
     */

    public Object[][] select(String table_name) throws SQLException
    {  
        String sql = "select * from "+table_name;  
        Connection con = getConn();//�˴�Ϊͨ���Լ�д�ķ���getConn()�������  
        try{

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); //ResultSet�࣬������Ż�ȡ�Ľ��������
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
     * �������
     */

    public int insert() 
    {

        int i = 0;
        Connection con = getConn();
        String sql = "insert into table_test (id, name, cell) values (?, ?, ?)";
        try {
            //����ִ��SQL���
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setLong(1,4);
            pst.setString(2, "����");
            pst.setString(3, "123344"); 
            i = pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(i);
        return i; //����Ӱ���������1Ϊִ�гɹ�
    }
    /*
     * ���²���
     */
    public int update() 
    {
        int i=0;
        String sql = "update table_test set id=?,name=?,cell=? where id =?";
        Connection con=getConn();
        try {
            //����ִ��SQL���
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setLong(1,1);
            pst.setString(2, "С��");
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
     * ɾ������
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