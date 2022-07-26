package de.bypixels.teamcreate.game.util.sql;

/******************************************************************
 *   Copyright Notice                                             * 
 *   Copyright (c) PixelsDE | Daniel 2018                         *                       
 *   Created: 14.06.2018 / 15:53                                  *
 *   All contents of this source text are protected by copyright. * 
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            * 
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/

import de.bypixels.teamcreate.game.main.MinecartRain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/******************************************************************
 *   Copyright Notice                                             *
 *   Copyright (c) PixelsDE | Daniel 2018                         *
 *   Created: 14.06.2018 / 12:26                                  *
 *   All contents of this source text are protected by copyright. *
 *   The copyright law, unless expressly indicated otherwise, is  *
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            *
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/
public class SQLPoints extends MySQL {


    public static boolean isUserExist(String spielername) {
        try {
            PreparedStatement preparedStatement = MinecartRain.mySQLClass.getConnection().prepareStatement("SELECT high FROM Stats WHERE spielername = ?");
            preparedStatement.setString(1, spielername);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public static void delete(String spielername) {
        if (isUserExist(spielername)) {


            try {
                PreparedStatement preparedStatement =  MinecartRain.mySQLClass.getConnection().prepareStatement("update Stats set high = 0 WHERE spielername= ?");
                preparedStatement.setString(1, spielername);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("[MySQL] Der Spieler mit dem Namen: " + spielername + " ist nicht in der Datenbank!");
        }
    }

    public static void update(int high, String spielername) {
        try {
            int amount = getHigh(spielername);

            if (isUserExist(spielername) == true) {

                PreparedStatement preparedStatement =  MinecartRain.mySQLClass.getConnection().prepareStatement("UPDATE Stats SET high = ? WHERE spielername = ?");
                preparedStatement.setString(2, spielername);

                preparedStatement.setInt(1, amount);

                preparedStatement.executeUpdate();

            } else if (isUserExist(spielername) == false) {
                PreparedStatement preparedStatement =  MinecartRain.mySQLClass.getConnection().prepareStatement("INSERT INTO Stats(spielername, high) VALUES (?,?)");

                preparedStatement.setString(1, spielername);
                preparedStatement.setInt(2, amount);
                preparedStatement.executeUpdate();

            } else {
                System.out.println("ERROR");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static Integer getHigh(String spielername) {
        if (isUserExist(spielername) == true) {
            try {
                PreparedStatement preparedStatement =  MinecartRain.mySQLClass.getConnection().prepareStatement("SELECT high FROM Stats WHERE spielername = ?");
                preparedStatement.setString(1, spielername);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    return resultSet.getInt("kills");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return -1;
        }
        return -1;
    }


}

