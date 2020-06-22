package com.demo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ProductBean implements Serializable {
    private static final long serialVersionUID = 6081417964063918994L;

    public List<Product> getProducts() throws ClassNotFoundException, SQLException {

        Connection connect = null;

        String url = "jdbc:mysql://localhost:3306/demo";

        String username = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection(url, username, password);
            // System.out.println("Connection established"+connect);

        } catch (SQLException ex) {
            System.out.println("in exec");
            System.out.println(ex.getMessage());
        }

        List<Product> listProduct = new ArrayList<Product>();
        PreparedStatement pstmt = connect.prepareStatement("select * from product");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            listProduct.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"), rs.getInt("price")));
        }
        // close resources
        rs.close();
        pstmt.close();
        connect.close();

        return listProduct;

    }
}
