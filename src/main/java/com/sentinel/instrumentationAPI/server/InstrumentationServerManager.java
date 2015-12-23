package com.sentinel.instrumentationAPI.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebastian on 12/15/15.
 */
public class InstrumentationServerManager {
    private static InstrumentationServerManager instrumentationServerManager;
    private Connection databaseConnection = null;

    protected InstrumentationServerManager() {

    }

    public static InstrumentationServerManager getInstance() {
        if (instrumentationServerManager == null) {
            return new InstrumentationServerManager();
        }
        return instrumentationServerManager;
    }

    public List<String> getAllInstrumentedApks() {
        setDatabaseConnection();
        List<String> instrumentedApkHashes = new ArrayList<String>();


        try {
            Statement statement;
            statement = databaseConnection.createStatement();
            String sqlStatementGetAllApkPackagenamesAndHashes = "SELECT HASH " +
                    "FROM APKS;";

            ResultSet resultSet = statement.executeQuery(sqlStatementGetAllApkPackagenamesAndHashes);

            while (resultSet.next()) {
                instrumentedApkHashes.add(resultSet.getString("HASH"));
            }

            statement.close();
            databaseConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(instrumentedApkHashes);

        return instrumentedApkHashes;
    }

    public void setupDatabase() {
        Statement statement = null;

        setDatabaseConnection();

        System.out.println("Opened database successfully");

        // TODO make this parameterized.
        try {
            statement = databaseConnection.createStatement();

            String sqlStatementDropTable = "DROP TABLE IF EXISTS APKS;";

            String sqlStatementCreateTable = "CREATE TABLE APKS" +
                    "(ID                    INTEGER     PRIMARY KEY     NOT NULL," +
                    "PACKAGENAME            TEXT                        NOT NULL," +
                    "HASH                   TEXT                        NOT NULL," +
                    "INSTRUMENTEDAPK        BLOB)";


            String sqlStatementInsertTestApk = "INSERT INTO APKS(ID, PACKAGENAME, HASH, INSTRUMENTEDAPK)" +
                    "VALUES (1, 'PolicyTester', '16ac6ca7e19f2836f238a5f46609244c4e11864e60ad8d16e58e43524b42381417708152af9ce90bc0f934e4ae2f041cb90f9729e92b0223bee252ce0342fe16', " +
                    "'PolicyTester.apk');";


            statement.executeUpdate(sqlStatementDropTable);
            statement.executeUpdate(sqlStatementCreateTable);
            statement.executeUpdate(sqlStatementInsertTestApk);
            statement.close();
            databaseConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void setDatabaseConnection() {
        if (databaseConnection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                databaseConnection = DriverManager.getConnection("jdbc:sqlite:test.db");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + e.getMessage());

            }
        }
    }
}
