package com.sword.trailersdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class TrailersDbApplication {

	public static void main(String[] args) {

		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			//Connection con=DriverManager.getConnection(  "jdbc:mysql://151.106.97.51:3306/u878396704__trailers_db","u878396704__trailers_db","Prueba123");
			Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/base","root","");
			System.out.print("Connected successfully");
		}catch(Exception e){
			e.printStackTrace();
		}*/


		SpringApplication.run(TrailersDbApplication.class, args);
	}

}
