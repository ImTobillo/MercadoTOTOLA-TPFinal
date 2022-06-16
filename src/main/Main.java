package main;

import java.util.Scanner;

import excepciones.UsuarioIncorrectoException;
import mercado.*;
import usuarios.*;
/*import productos.*;
import interfaces.*;
import excepciones.*;
import carrito.*;*/

public class Main {
	
	static Scanner teclado;
	static Mercado mercadoTotola;
	
	public static void main(String[] args) {
		
		teclado = new Scanner(System.in);
		
		mercadoTotola = new Mercado();
		
		/*Gerente gerente = new Gerente("Gerardo", "Messi", 45, "21569784", "gerardoMessi", "12345678", 0, "Libre", 0);
		mercadoTotola.agregarUsuario(gerente);*/
		
		//int opcionMenu, repetirMenu = 1, tipoUsuario, repetirSubMenu, opcionSubmenu;
		
		menuInicial();
		
	}
	
	public static void menuInicial()
	{
		int repetir = 1, opcion = 1;
		
		while(repetir == 1)
		{
			try {
				System.out.println("¿DESEA INGRESAR O REGISTRARSE?\n"
						+ "	   1  	   - INGRESAR\n"
						+ "OTRO NÚMERO - REGISTRARSE");
				
				opcion = teclado.nextInt();
				
				if (opcion == 1)
					ingresar();
				else
					registrarse();
				
				if (repetir == 1)
				{
					System.out.println("¿DESEA SEGUIR EN EL MENÚ?\n"
							+ "     1      - SÍ\n"+
							  "OTRO NÚMERO - NO");
					repetir = teclado.nextInt();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void ingresar()
	{
		int tipoUsuario = 1, repetir = 1;
		
		System.out.println("¿QUÉ TIPO DE USUARIO USA?\n"
				+"	   1 	  - CLIENTE\n" // lauti
				+"	   2	  - EMPLEADO\n" // tobi
				+"OTRO NUMERO - GERENTE"); // tobillo
		
		tipoUsuario = teclado.nextInt();
	
	
	
		switch (tipoUsuario) {
		case 1:
		
		tipoARegistrar = 1;
		
		while()
		{
			System.out.println("");
		}
		break;
		case 2:
		
		tipoARegistrar = 2;
		
		while()
		{
			System.out.println("");
		}
		break;
		default:
		
		
		
		while()
		{
			System.out.println("");
		}
		
		break;
	}
	
	}
	
	public static void ingresarEmpleado()
	{
		
	}
	
	public static void registrarse()
	{
		
		
		try {
			System.out.println("INGRESE NOMBRE: ");
			String nombre = teclado.nextLine();
			System.out.println("INGRESE APELLIDO: ");
			String apellido = teclado.nextLine();
			System.out.println("INGRESE EDAD: ");
			int edad = teclado.nextInt();
			System.out.println("INGRESE DNI: ");
			String dni = teclado.nextLine();
			System.out.println("INGRESE NOMBRE DE USUARIO");
			String nombreUsuario = teclado.nextLine();
			while (mercadoTotola.existeUsuario(nombreUsuario))
			{
				System.out.println("USUARIO YA UTILIZADO. PRUEBE CON OTRO.");
				nombreUsuario = teclado.nextLine();
			}
			System.out.println("INGRESE UNA CONTRASEÑA DE MINIMO 8 CARACTERES:");
			String contraseña = teclado.nextLine();
			while (contraseña.length() < 8)
			{
				System.out.println("DEBE INGRESAR UNA CONTRASEÑA MAYOR O IGUAL A 8 CARACTERES");
				contraseña = teclado.nextLine();
			}
			
			if(tipoARegistrar == 1) {
			
				mercadoTotola.agregarUsuario(new Cliente(nombre, apellido, edad, dni, nombreUsuario, contraseña));
			}
			else {
				
				System.out.println("INGRESE EL HORARIO EJ:(00:00 A 00:01):");
				String horario = teclado.nextLine();
				System.out.println("INGRESE CUANTO COBRARA POR HORA:");
				float pagoPorHora = teclado.nextFloat();
				
				if(tipoARegistrar == 2) {
					
					System.out.println("ASIGNELE UNA CAJA:");
					int caja = teclado.nextInt();
					
					mercadoTotola.agregarUsuario(new Cajero(nombre, apellido, edad, dni, nombreUsuario, contraseña,horario,caja,pagoPorHora));
					
				}
				else if(tipoARegistrar == 3)
				{				
					mercadoTotola.agregarUsuario(new Repositor(nombre, apellido, edad, dni, nombreUsuario, contraseña,horario,pagoPorHora));
				}
				else
				{
					System.out.println("QUE ZONA VIGILARA:");
					String zonaAVigilar = teclado.nextLine();
					
					mercadoTotola.agregarUsuario(new Seguridad(nombre, apellido, edad, dni, nombreUsuario, contraseña,horario,zonaAVigilar,pagoPorHora));
				}
			
				
				
				
			}
			
			
		}
		catch (UsuarioIncorrectoException e)
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
