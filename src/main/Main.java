package main;

import java.util.Scanner;

import mercado.*;
import usuarios.*;
/*import productos.*;
import interfaces.*;
import excepciones.*;
import carrito.*;*/

public class Main {
	static Scanner teclado;
	
	public static void main(String[] args) {
		teclado = new Scanner(System.in);
		
		/*Mercado mercadoTotola = new Mercado();
		Gerente gerente = new Gerente("Gerardo", "Messi", 45, "21569784", "gerardoMessi", "12345678", 0, "Libre", 0);
		mercadoTotola.agregarUsuario(gerente);*/
		
		//int opcionMenu, repetirMenu = 1, tipoUsuario, repetirSubMenu, opcionSubmenu;
		
		menuInicial();
		
	}
	
	public static void menuInicial()
	{
		int repetir, opcion, tipoUsuario;
		
		/*while(repetir == 1)
		{
			try {
				System.out.println("¿DESEA INGRESAR O REGISTRARSE?\n"
						+ "	   1  	   - INGRESAR\n"
						+ "OTRO NÚMERO - REGISTRARSE");
				
				opcion = teclado.nextInt();
				
				if (opcion == 1)
				{
					System.out.println("¿QUÉ TIPO DE USUARIO USA?\n"
								+"	   1 	  - CLIENTE\n" // lauti
								+"	   2	  - EMPLEADO\n" // tobi
								+"OTRO NUMERO - GERENTE"); // tobillo
					tipoUsuario = teclado.nextInt();
					
					
					
					switch (tipoUsuario) {
					case 1:
						while()
						{
							System.out.println("");
						}
						break;
					case 2:
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
				else
				{
					Usuario nuevo;
					System.out.println("INGRESE NOMBRE:");
					
				}
				
				switch (opcion) {
				case 1: // cliente
					
					break;
				case 2: // gerente
					
					break;
				case 3: // empleado
					
					break;
				case 4:
					repetir = 0;
					break;
				default:
					
					break;
				}
				
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
		}*/
	}

}
