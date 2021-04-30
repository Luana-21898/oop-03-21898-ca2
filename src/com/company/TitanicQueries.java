package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitanicQueries {

    final String DB_DATABASE = "titanicmanifest";
    final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_DATABASE;
    final String DB_USER = "LuaHF";
    final String DB_PASSWORD = "12232321";


    private PreparedStatement getPassengerByName;
    private PreparedStatement getPassengerByGender;
    private PreparedStatement getPassengerByAge;

    public TitanicQueries() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //select people by name
            String sqlQuery = "select name, gender, age from titanic WHERE name like ?";
            getPassengerByName = con.prepareStatement(sqlQuery);

            // Selecting people by gender
            String sqlQueryGender = "select name, gender, age from titanic WHERE gender like ?";
            getPassengerByGender = con.prepareStatement(sqlQueryGender);

            // select people by age
            String sqlQueryAge = "select age from titanic WHERE age like ?";
            getPassengerByAge = con.prepareStatement(sqlQueryAge);


        } catch (SQLException e) {

        } catch (Exception e) {

        }

    }

    public List<Passenger> getPassengersByName(String name) {
        ResultSet resultSet = null;
        List<Passenger> results = null;

        try {
            getPassengerByName.setString(1, "%" + name + "%");

            resultSet = getPassengerByName.executeQuery();

            results = new ArrayList<Passenger>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);

            }


        } catch (SQLException e) {

        } catch (Exception e) {

        }

        return results;


    }
    public List<Passenger> getPassengerByGender(String gender) {

        ResultSet resultSet = null;
        List<Passenger> results = null;

        try {

            getPassengerByGender.setString(1,gender );
            resultSet = getPassengerByGender.executeQuery();

            results = new ArrayList<Passenger>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);
            }


        } catch (SQLException e) {
        } catch (Exception e) {
        }
        return results;
    }

    public List<Passenger> getPassengerByAge(Integer age) {

        ResultSet resultSet = null;
        List<Passenger> results = null;

        try {

            getPassengerByAge.setInt(1, age);
            resultSet = getPassengerByAge.executeQuery();
            results = new ArrayList<>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);
            }
        } catch (SQLException e) {
        } catch (Exception e) {
        }
        return results;

    }

}
