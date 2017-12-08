package br.edu.utfpr.dainf.eex23.helius.bs.data;

import br.edu.utfpr.dainf.eex23.helius.beans.Data;
import br.edu.utfpr.dainf.eex23.helius.beans.DataPoint;
import br.edu.utfpr.dainf.eex23.helius.beans.GraphsCollection;
import br.edu.utfpr.dainf.eex23.helius.beans.HomeData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class HeliusData {

    private static HeliusData hd;
    private Connection connection;

    private HeliusData() {

    }

    public static HeliusData getInstance() {
        if (hd == null) {
            hd = new HeliusData();
        }
        return hd;
    }

    public boolean startConnection(String driver, String connectionPath, String username, String password) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionPath, username, password);
            connection.setAutoCommit(true);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public synchronized boolean status() {
        return connection != null;
    }

    public synchronized boolean add(Data data) {
        try {
            String sql = "INSERT INTO eletrical(name,voltage,current,idHW) VALUES ('e',?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, data.getVoltage());
            statement.setDouble(2, data.getCurrent());
            statement.setString(3, data.getId());
            statement.executeUpdate();

            sql = "INSERT INTO wheather(name,irradiance,temperature,idHW) VALUES ('w',?,?,?)";

            statement = connection.prepareStatement(sql);

            statement.setDouble(1, data.getIrradiance());
            statement.setDouble(2, data.getTemperature());
            statement.setString(3, data.getId());

            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("ERROR: ".concat(e.toString()));
        }

        return false;
    }

    public GraphsCollection getGraphCurrent() {
        return getGraph("eletrical", "current");
    }

    public GraphsCollection getGraphsVoltage() {
        return getGraph("eletrical", "voltage");
    }

    public GraphsCollection getGraphIrradiance() {
        return getGraph("wheather", "irradiance");
    }

    public GraphsCollection getGraphsTemperature() {
        return getGraph("wheather", "temperature");
    }

    public GraphsCollection getGraphsEfficiency() {
        return getGraph("SELECT * FROM eletrical WHERE date>?", "");
    }

    public GraphsCollection getGraphsEconomy() {
        return getGraph("SELECT * FROM eletrical WHERE date>?", "");
    }

    private GraphsCollection getGraph(String table, String type) {
        GraphsCollection gc = new GraphsCollection();

        try {
            StringBuilder sql = new StringBuilder("SELECT ");
            sql.append(type);
            sql.append(",date FROM ");
            sql.append(" WHERE date>DATEADD(year,-1,GETDATE())");

            PreparedStatement statement = connection.prepareStatement(sql.toString());
            ResultSet rs = statement.executeQuery();
            DataPoint dp;
            while (rs.next()) {
                dp = new DataPoint(rs.getTimestamp("date").getTime(), rs.getDouble(type));
                gc.getYear().add(dp);
            }

            sql = new StringBuilder("SELECT ");
            sql.append(type);
            sql.append(",date FROM ");
            sql.append(" WHERE date>DATEADD(month,-1,GETDATE())");

            statement = connection.prepareStatement(sql.toString());
            rs = statement.executeQuery();

            while (rs.next()) {
                dp = new DataPoint(rs.getTimestamp("date").getTime(), rs.getDouble(type));
                gc.getMonth().add(dp);
            }

            sql = new StringBuilder("SELECT ");
            sql.append(type);
            sql.append(",date FROM ");
            sql.append(" WHERE date>DATEADD(week,-1,GETDATE())");

            statement = connection.prepareStatement(sql.toString());
            rs = statement.executeQuery();

            while (rs.next()) {
                dp = new DataPoint(rs.getTimestamp("date").getTime(), rs.getDouble(type));
                gc.getWeek().add(dp);
            }

            sql = new StringBuilder("SELECT ");
            sql.append(type);
            sql.append(",date FROM ");
            sql.append(" WHERE date>DATEADD(day,-1,GETDATE())");

            statement = connection.prepareStatement(sql.toString());
            rs = statement.executeQuery();

            while (rs.next()) {
                dp = new DataPoint(rs.getTimestamp("date").getTime(), rs.getDouble(type));
                gc.getDay().add(dp);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: ".concat(e.toString()));
        }

        return gc;
    }

    public HomeData getHome() {
        HomeData hd = new HomeData();
         try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM wheather ORDER BY idWheather DESC LIMIT 1");
            ResultSet rs = statement.executeQuery();
            rs.next();
            hd.setTemperatura(rs.getDouble("temperature"));
            hd.setIncidencia(rs.getDouble("irradiance"));


            statement = connection.prepareStatement("SELECT * FROM eletrical ORDER BY idEletrical DESC LIMIT 1");
            rs = statement.executeQuery();
            rs.next();
            
            hd.setEconomia(rs.getDouble("voltage"));
            hd.setEficiencia(rs.getDouble("current"));
        } catch (SQLException e) {
            System.out.println("ERROR: ".concat(e.toString()));
        }
        return hd;
    }
}
