package com.jspider.empinfosystem.dbconnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author : Santosh Koli
 * @createdDate : Jun 24, 2014
 * @projectName : assignment_1_proj_v2
 */
public class DBConnection {

	private static final DBConnection dbcon = new DBConnection();
	private static Connection con;
	private Properties props = new Properties();
	InputStream is = null;

	private DBConnection() {
		try {
			is = new FileInputStream(new File("config\\dbconfig.properties"));
			props.load(is);
			if (is !=null) {
				is.close();
			}
			Class.forName(props.getProperty("driver"));
			con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static DBConnection getDBConnectionInstance() {
		return dbcon;
	}

	public Connection getConnectionInstance() {
		return con;
	}

	@Override
	public void finalize() throws Throwable {
		if(con != null) {
			con.close();
		}
	}

}

