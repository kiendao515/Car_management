package Project;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ProductSericeImpl {
    public boolean insertProduct(Product product) throws SQLException, ClassNotFoundException {
        boolean checkProductExist=false;
        MyConnection myConnection= new MyConnection();
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement= connection.prepareStatement("insert into car (name,brand,category,description," +
                "price,quantity,bar_code) values (?,?,?,?,?,?,?)");
        preparedStatement.setString(1,product.getName());
        preparedStatement.setString(2,product.getBrand());
        preparedStatement.setString(3,product.getCategory());
        preparedStatement.setString(4,product.getDescription());
        preparedStatement.setDouble(5,product.getPrice());
        preparedStatement.setInt(6,product.getQuantity());
        preparedStatement.setString(7,product.getBar_code());
        if(preparedStatement.executeUpdate()!=0){
            JOptionPane.showMessageDialog(null,"insert thanh cong !");
            checkProductExist=true;
        }else {
            JOptionPane.showMessageDialog(null,"insert that bai");
        }
        return checkProductExist;
    }
    public ArrayList<Product> productArrayList() throws SQLException, ClassNotFoundException {
        ArrayList<Product> products= new ArrayList<>();
        MyConnection myConnection= new MyConnection();
        Connection connection= myConnection.connectDb();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select id,name,brand,category,description,price,quantity,bar_code from car ");
        while(resultSet.next()){
           Product product= new Product(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("brand"),
                   resultSet.getString("category"),resultSet.getString("description"),resultSet.getDouble("price"),
                   resultSet.getInt("quantity"),resultSet.getString("bar_code"));
           products.add(product);
        }
        return products;

    }

}
