package Project;



import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CategoryServiceImpl {
     MyConnection myConnection= new MyConnection();
     public boolean insertCategory(Category category) throws SQLException, ClassNotFoundException {
         boolean existCategory = false;
         Connection connection =  myConnection.connectDb();
         PreparedStatement preparedStatement=connection.prepareStatement("insert into category(status,name) values(?,?) ");
         preparedStatement.setString(1,category.getStatus());
         preparedStatement.setString(2,category.getName());
         if(preparedStatement.executeUpdate()!=0){
             JOptionPane.showMessageDialog(null,"Insert thanh cong !");
              existCategory=true;
         }else {
             JOptionPane.showMessageDialog(null,"Insert that bai ");
         }
         return existCategory;
     }
     public ArrayList<Category> categoryArrayList() throws SQLException, ClassNotFoundException {
         ArrayList<Category> categories= new ArrayList<>();
         MyConnection myConnection= new MyConnection();
         Connection connection= myConnection.connectDb();
         Statement statement=connection.createStatement();
         ResultSet resultSet=statement.executeQuery("select id,name,status from category ");
         while(resultSet.next()){
             Category category= new Category(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("status"));
              categories.add(category);
         }
         return categories;

     }
}
