import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

public class prikaziGraf extends Application {
	
	private int idPitanja;
	ArrayList<String> odgovori = new ArrayList<String>();
	ArrayList<Integer> counter = new ArrayList<Integer>();
	private int PostojilGreska = 0;
 

    public void start(Stage stage){
    	////////////////////////////////////////
    	PregledStatistike obj = new PregledStatistike();
    	Connection conn = null;
		Statement stmt = null;
		try {

			Class.forName(DbConnection.JDBC_DRIVER);
			conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

			stmt = conn.createStatement();
			String sql;
			sql = ("SELECT id FROM questions WHERE question_text = '" + obj.getIzabranoPitanje() + "' ");
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				setIdPitanja(rs.getInt("id"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception x) {
			x.printStackTrace();
		}

		Connection conn2 = null;
		Statement stmt2 = null;
		try {
			Class.forName(DbConnection.JDBC_DRIVER);
			conn2 = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

			stmt2 = conn2.createStatement();
			String sql2;
			sql2 = ("SELECT answer, answer_count FROM answers WHERE question_id = '" + getIdPitanja() + "' ");
			ResultSet rs2 = stmt2.executeQuery(sql2);
			while (rs2.next()) {
				String odgovor = rs2.getString("answer");
				int broj = rs2.getInt("answer_count");
				odgovori.add(odgovor);
				counter.add(broj);
			}
			rs2.close();
			stmt2.close();
			conn2.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception x) {
			x.printStackTrace();
		}
		
		try {
			odgovori.get(2);
			counter.get(2);
		} catch (IndexOutOfBoundsException e) {
			setPostojilGreska(1);
		}
    	
    	///////////////////////////////////////
        Scene scene = new Scene(new Group());
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data(odgovori.get(0), counter.get(0)*100),
                new PieChart.Data(odgovori.get(1), counter.get(1)*100));
        		if (getPostojilGreska() == 0) {
        			new PieChart.Data(odgovori.get(2), counter.get(2));
        		}
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle(obj.getIzabranoPitanje());

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void nista(String[] args) {
    	launch(args);
    	PregledStatistike x = new PregledStatistike();
    	x.close();
    }
    
    
    
    public int getIdPitanja() {
		return idPitanja;
	}

	public void setIdPitanja(int idPitanja) {
		this.idPitanja = idPitanja;
	}

	public int getPostojilGreska() {
		return PostojilGreska;
	}

	public void setPostojilGreska(int PostojilGreska) {
		this.PostojilGreska = PostojilGreska;
	}
}