package Project;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class BrandServiceImpl {
    MyConnection myConnection= new MyConnection();
    public boolean insertBrand(Brand brand) throws SQLException, ClassNotFoundException {
        boolean existBrand = false;
        Connection connection =  myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into brand(status,name) values(?,?) ");
        preparedStatement.setString(1,brand.getStatus());
        preparedStatement.setString(2,brand.getName());
        if(preparedStatement.executeUpdate()!=0){
            JOptionPane.showMessageDialog(null,"Insert thanh cong !");
           existBrand=true;
        }else {
            JOptionPane.showMessageDialog(null,"Insert that bai ");
        }
        return existBrand;
    }
    public ArrayList<Brand> brandArrayList() throws SQLException, ClassNotFoundException {
        ArrayList<Brand> brands= new ArrayList<>();
        MyConnection myConnection= new MyConnection();
        Connection connection= myConnection.connectDb();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select id,name,status from brand ");
        while(resultSet.next()){
            Brand brand= new Brand(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("status"));
            brands.add(brand);
        }
        return brands;

    }

}
