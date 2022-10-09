package proyectoMineria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
	
		Mineria metalPlus = new Mineria("Metal plus");
		
		AdminSistema gus = new AdminSistema("Gus94", "Lolabonita94", "Admin", true, metalPlus);
		
		System.out.println(gus);
		
		metalPlus.agregarAdmin(gus);
		
		gus.loguearse(input);
		
		metalPlus.getListaUsuariosAdmin().forEach(System.out::println);
		
		
		
		//creo 1er usuario 
		gus.crearUsuario(input);
		
		System.out.println("***************************");
		System.out.println("Lista de Admins Stock");
		System.out.println("***************************");
		
		gus.getMineria().getListaUsuariosStock().forEach(System.out::println);
		
		System.out.println("***************************");
		System.out.println("Lista de Admins Ventas");
		System.out.println("***************************");
		
		gus.getMineria().getListaUsuariosVentas().forEach(System.out::println);
		
		//Creo 2do usuario
		
		gus.crearUsuario(input);
		
		System.out.println("***************************");
		System.out.println("Lista de Admins Stock");
		System.out.println("***************************");
		
		gus.getMineria().getListaUsuariosStock().forEach(System.out::println);
		
		System.out.println("***************************");
		System.out.println("Lista de Admins Ventas");
		System.out.println("***************************");
		
		gus.getMineria().getListaUsuariosVentas().forEach(System.out::println);
		
		//creo 3er usuario
		
		gus.crearUsuario(input);
		
		System.out.println("***************************");
		System.out.println("Lista de Admins Stock");
		System.out.println("***************************");
		
		gus.getMineria().getListaUsuariosStock().forEach(System.out::println);
		
		System.out.println("***************************");
		System.out.println("Lista de Admins Ventas");
		System.out.println("***************************");
		
		gus.getMineria().getListaUsuariosVentas().forEach(System.out::println);
		
		
		
		input.close();
	}

}
