package com.lab;

import com.lab.models.*;
import com.lab.views.LoginView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Lab {
	public static List<User> Users = new ArrayList<User>();
	public static List<Vehicle> Vehicles = new ArrayList<Vehicle>();;
	public static List<Agent> Agents = new ArrayList<Agent>();;
	public static List<Owner> Owners = new ArrayList<Owner>();;
	public static List<Contract> Contracts = new ArrayList<Contract>();;
	public static List<Client> Clients = new ArrayList<Client>();;
	public static List<Address> Addresses = new ArrayList<Address>();;


	public static void main(String[] args) {
		SpringApplication.run(Lab.class, args);
	}

	@PostMapping("/login")
	public String login(
		@RequestBody LoginView body
	) {
		System.out.println(body.email);
		System.out.println(body.password);
		return "fetched";
	}
}
