import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import servlet.SinhVien;
import servlet.SinhVienDAO;

public class productDAO {
	Connection con;
    public  SinhVienDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
           
        } 
        catch (ClassNotFoundException e1) {
            e1.printStackTrace();
             
        }      

    }
    public ResultSet getData(){
        ResultSet r=null;
        if(con!=null){
            try{
            Statement st=con.createStatement();
            r=st.executeQuery("select * from sinhvien");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
         System.out.println(" ok");
        return r;
    }
    public void insert(int _id,String _hoTen,String _diaChi, String _tenLop,int _namSinh){
        String sql="Insert into sinhvien (id,hoten,diachi,tenlop,namsinh) values (?,?,?,?,?)";
        if(con!=null){
        try{ PreparedStatement pr=con.prepareStatement(sql);
        pr.setInt(1, _id);
        pr.setString(2,_hoTen);
        pr.setString(3,_diaChi);
        pr.setString(4,_tenLop);
        pr.setInt(5,_namSinh);
            System.out.println(pr.toString());
        pr.executeUpdate();
      pr.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
            
        }
    }
    public void updateSinhVien(int _id,String _hoTen, String _diaChi,String _tenLop, int _namSinh){
        String sql="update sinhvien set hoTen=?,diaChi=?,tenLop=?,namSinh=? where id=?";
        try{ PreparedStatement pr=con.prepareStatement(sql);
        pr.setString(1,_hoTen);
        pr.setString(2,_diaChi);
        pr.setString(3,_tenLop);
        pr.setInt(4,_namSinh);
        pr.setInt(5,_id);
        pr.executeUpdate();
           pr.close();
        }catch(SQLException e1){
            e1.printStackTrace();
        }
    }
    public void showData(ResultSet rs){
        try {
            while (rs.next()) {
                System.out.printf("%-2s", rs.getInt(1));
                System.out.printf("%-20s", rs.getString(2));
                System.out.printf("%-15s", rs.getString(3));
                System.out.printf("%-15s", rs.getString(4));
                 System.out.printf("%-15s", rs.getInt(5));
                System.out.printf("\n");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<SinhVien> getAll() throws SQLException {
        Statement st = null;
        ArrayList<SinhVien> listAll = new ArrayList<SinhVien>();
        ResultSet rs = null;
        if (con != null) {
            st = con.createStatement();
            rs = st.executeQuery("select * from sinhvien");
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));                
                listAll.add(sv);
            }
        }
        return listAll;
    }


    public static void main(String args[]) {
        SinhVienDAO demo = new SinhVienDAO();

demo.showData(demo.getData());
}
