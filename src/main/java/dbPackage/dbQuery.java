package dbPackage;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class dbQuery {
    public dbQuery() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter actor id: ");
        int id = in.nextInt();

        System.out.print("Enter actor name: ");
        String firstName = in.next();

        System.out.print("Enter last name: ");
        String lastName = in.next();

        //inputActor(id, firstName, lastName);
        //getActor(id);
        //updateActor(id, firstName, lastName);
        //deleteActor(id);
    }

    static void getActor(int id) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "password");
            PreparedStatement statement = connection.prepareStatement("select * from actor where actor_id = " + id);) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int actorID = resultSet.getInt(1);
                String actorFirstName = resultSet.getString(2);
                String actorLastName = resultSet.getString(3);

                System.out.println("Actor: " + actorID + " Name: " + actorFirstName + " " + actorLastName);
            }
        } catch(SQLException e) {System.out.println("Error: "); e.printStackTrace();}
    }

    static void inputActor(int id, String firstName, String lastName) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "password");
            Statement statement = connection.createStatement()) {
            int row = statement.executeUpdate("insert into actor values(" + id + ",'" + firstName + "', '" + lastName +"', '2019-01-01')");
            System.out.println("Row: " + row);
        } catch(SQLException e) {System.out.println("Error: "); e.printStackTrace();}
    }

    static void deleteActor(int id) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "password");
            Statement statement = connection.createStatement()) {
            int row = statement.executeUpdate("delete from actor where actor_id = " + id);
            System.out.println("Row: " + row);
        } catch (SQLException e) {System.out.println("Error: "); e.printStackTrace();}
    }

    static void updateActor(int id, String firstName, String lastName) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "password");
            Statement statement = connection.createStatement();) {
            int row = statement.executeUpdate("update first_name, last_name into actor values where actor_id = id (firstName, lastName)");
        } catch(SQLException e) {System.out.println("Error: "); e.printStackTrace();}
    }
}
