package main;

import java.util.Scanner;

import excepciones.ContraseñaIncorrectaException;
import excepciones.UsuarioIncorrectoException;
import mercado.*;
import productos.AlimentoCultivado;
import productos.Congelado;
import productos.Limpieza;
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

		/*
		 * Gerente gerente = new Gerente("Gerardo", "Messi", 45, "21569784",
		 * "gerardoMessi", "12345678", 0, "Libre", 0);
		 * mercadoTotola.agregarUsuario(gerente);
		 */

		// int opcionMenu, repetirMenu = 1, tipoUsuario, repetirSubMenu, opcionSubmenu;

		menuInicial();

	}

	public static void menuInicial() {
		int repetir = 1, opcion = 1;

		while (repetir == 1) {
			try {
				System.out.println(
						"¿DESEA INGRESAR O REGISTRARSE?\n" + "	   1  	   - INGRESAR\n" + "OTRO NÚMERO - REGISTRARSE");

				opcion = teclado.nextInt();

				if (opcion == 1)
					ingresar();
				else
					registrarse(0);

				System.out.println("¿DESEA SEGUIR EN EL MENÚ?\n" + "     1      - SÍ\n" + "OTRO NÚMERO - NO");
				repetir = teclado.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void ingresar() {
		int tipoUsuario = 1, opcion = 0;
		boolean flag = true;

		while (flag) {
			try {
				System.out.println("¿QUÉ TIPO DE USUARIO USA?\n" + "	   1 	  - CLIENTE\n"
						+ "	   2 	  - CAJERO\n" + "	   3 	  - REPOSITOR\n" + "	   4	  - SEGURIDAD\n"
						+ "	   5 	  - GERENTE");

				tipoUsuario = teclado.nextInt();
				System.out.println("INGRESE NOMBRE DE USUARIO: ");
				String nombreUsuario = teclado.nextLine();
				System.out.println("INGRESE CONTRASEÑA: ");
				String contraseña = teclado.nextLine();

				switch (tipoUsuario) {
				case 1:
					Cliente cliente = (Cliente) mercadoTotola.login(nombreUsuario, contraseña);

					if (cliente != null) {
						flag = false;
						menuCliente();
					}
					break;
				case 2:
					Cajero cajero = (Cajero) mercadoTotola.login(nombreUsuario, contraseña);

					if (cajero != null) {
						flag = false;
						System.out.println(cajero.toString());
					}

					break;
				case 3:
					Repositor repositor = (Repositor) mercadoTotola.login(nombreUsuario, contraseña);

					if (repositor != null) {
						flag = false;
						int repetir = 1;

						while (repetir == 1) {
							System.out.println(
									"QUE DESEA HACER: 1 - VER SUS DATOS \n 2 - REPONER PRODUCTOS \nOTRO NUMERO - AGREGAR NUEVOS PRODUCTOS");
							opcion = teclado.nextInt();

							if (opcion == 1) {
								System.out.println(repositor.toString());
							} else if (opcion == 2) {

								System.out.println(mercadoTotola.mostrarTodosLosProductos());

								boolean flagA = false;
								String nombre = " ";

								while (!flagA) {

									System.out.println("Ingrese el producto a reponer");
									nombre = teclado.nextLine();
									flagA = mercadoTotola.existeOno(nombre);
								}

								System.out.println("Que cantidad quiere reponer?");
								int cant = teclado.nextInt();
								mercadoTotola.reponer(nombre, cant);

							} else {
								boolean flagB = false;
								String nombreProd = "";

								System.out.println("Que tipo de producto desea agregar?\n" + "1- Congelado\n"
										+ "2- Alimento cultivado\n" + "3- Limpieza\n");
								int tipo = teclado.nextInt();

								while (!flagB) {
									System.out.println("Ingrese el nombre del producto");
									nombreProd = teclado.nextLine();

									if (!mercadoTotola.existeOno(nombreProd))
										flagB = true;
									else
										System.out.println("El producto ya existe.");
								}

								System.out.println("INGRESE EL PRECIO: ");
								float precio = teclado.nextFloat();
								System.out.println("INGRESAR STOCK: ");
								int stock = teclado.nextInt();
								System.out.println("INGRESAR ID: ");
								int id = teclado.nextInt();

								if (tipo == 1) {
									System.out.println("INGRESE TEMPERATURA ADECUADA: ");
									float tempAdecuada = teclado.nextFloat();
									Congelado nuevo = new Congelado(nombreProd, precio, stock, id, tempAdecuada);
									mercadoTotola.agregarProd(nuevo, 1);
								} else if (tipo == 2) {
									System.out.println("INGRESE EL TIPO DE ALIMENTO CULTIVADO: ");
									String tipoAlimentoC = teclado.nextLine();
									AlimentoCultivado nuevo = new AlimentoCultivado(nombreProd, precio, stock, id,
											tipoAlimentoC);
									mercadoTotola.agregarProd(nuevo, 2);
								} else {
									System.out.println("INGRESE TIPO DE ASEO: ");
									String tipoAseo = teclado.nextLine();
									Limpieza nuevo = new Limpieza(nombreProd, precio, stock, id, tipoAseo);
									mercadoTotola.agregarProd(nuevo, 3);
								}
							}

							System.out.println("¿DESEA SEGUIR EN EL MENÚ DE REPOSITOR?\n" + "     1      - SÍ\n"
									+ "OTRO NÚMERO - NO");

							repetir = teclado.nextInt();

						}

					}

					break;
				case 4:
					Seguridad seguridad = (Seguridad) mercadoTotola.login(nombreUsuario, contraseña);

					if (seguridad != null) {
						flag = false;
						System.out.println(seguridad.toString());
					}

					break;
				case 5: // gerente
					Gerente gerente = (Gerente) mercadoTotola.login(nombreUsuario, contraseña);

					if (gerente != null) {
						flag = false;
						int opcionGerente, repetir = 1;

						while (repetir == 1) {
							System.out.println("INGRESE UNA OPCION: \n" + "1 - AGREGAR EMPLEADO\n"
									+ "2 - MODIFICAR SUELDO A EMPLEADO\n" + "3 - DESPEDIR EMPLEADO");
							opcionGerente = teclado.nextInt();

							if (opcionGerente == 1) {
								System.out.println("¿QUÉ TIPO DE EMPLEADO DESEA AGREGAR?\n" + "1 - CAJERO\n"
										+ "2 - REPOSITOR\n" + "3 - SEGURIDAD");
								int tipoEmpleadoAAgregar = teclado.nextInt();

								registrarse(tipoEmpleadoAAgregar + 1);

							} else if (opcionGerente == 2) {
								Empleado empEncontrado = null;
								String nombreEmp;

								System.out.println(mercadoTotola.mostrarEmpleados());
								System.out.println("INGRESE NOMBRE DE USUARIO DEL EMPLEADO A MODIFICAR SUELDO: ");
								nombreEmp = teclado.nextLine();
								empEncontrado = mercadoTotola.buscarEmpleado(nombreEmp);

								while (empEncontrado != null) {
									System.out.println("EL NOMBRE DE USUARIO NO EXISTE. INGRESE OTRO:");
									nombreEmp = teclado.nextLine();
									empEncontrado = mercadoTotola.buscarEmpleado(nombreEmp);
								}

								System.out.println("INGRESE HORAS TRABAJADAS DE " + empEncontrado.getNombreYApellido());
								int hsTrabajadas = teclado.nextInt();
								empEncontrado.setHorasTrabajadas(hsTrabajadas);

								System.out.println(
										"INGRESE HORAS EXTRAS TRABAJADAS DE " + empEncontrado.getNombreYApellido());
								int hsExtrasTrabajadas = teclado.nextInt();
								empEncontrado.setHorasExtras(hsExtrasTrabajadas);

							} else {
								System.out.println(mercadoTotola.mostrarEmpleados());
								System.out.println("INGRESE NOMBRE DE USUARIO DEL EMPLEADO A DESPEDIR: ");
								String nombreEmp = teclado.nextLine();

								while (!mercadoTotola.eliminarEmpleado(nombreUsuario)) {
									System.out.println(
											"EL USUARIO NO EXISTE. INGRESE SU NOMBRE DE USUARIO CORRECTAMENTE: ");
									nombreEmp = teclado.nextLine();
								}

								System.out.println(mercadoTotola.mostrarEmpleados());
								
							}

							System.out.println("¿DESEA SEGUIR EN EL MENÚ?\n" + "     1      - SÍ\n" + "OTRO NÚMERO - NO");

							repetir = teclado.nextInt();
						}
					}

					break;
				default:
					break;
				}

			} catch (UsuarioIncorrectoException e) {
				System.out.println(e.getMessage());
			} catch (ContraseñaIncorrectaException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void menuCliente() {

	}

	public static void registrarse(int tipoARegistrar) // 1 - Cliente / 2 - Cajero / 3 - Repositor / 4 - Seguridad
	{
		try {
			System.out.println("INGRESE NOMBRE: ");
			String nombre = teclado.nextLine();
			System.out.println("INGRESE APELLIDO: ");
			String apellido = teclado.nextLine();
			System.out.println("INGRESE EDAD: ");
			int edad = teclado.nextInt();
			while (edad < 18) {
				System.out.println("NO SE PUEDEN REGISTRAR MENORES DE 18 AÑOS.");
				edad = teclado.nextInt();
			}
			System.out.println("INGRESE DNI: ");
			String dni = teclado.nextLine();
			System.out.println("INGRESE NOMBRE DE USUARIO");
			String nombreUsuario = teclado.nextLine();
			while (mercadoTotola.existeUsuario(nombreUsuario)) {
				System.out.println("USUARIO YA UTILIZADO. PRUEBE CON OTRO.");
				nombreUsuario = teclado.nextLine();
			}
			System.out.println("INGRESE UNA CONTRASEÑA DE MINIMO 8 CARACTERES:");
			String contraseña = teclado.nextLine();
			while (contraseña.length() < 8) {
				System.out.println("DEBE INGRESAR UNA CONTRASEÑA MAYOR O IGUAL A 8 CARACTERES");
				contraseña = teclado.nextLine();
			}

			if (tipoARegistrar == 1) {

				mercadoTotola.agregarUsuario(new Cliente(nombre, apellido, edad, dni, nombreUsuario, contraseña));
			} else {

				System.out.println("INGRESE EL HORARIO EJ:(00:00 A 00:01):");
				String horario = teclado.nextLine();
				System.out.println("INGRESE CUANTO COBRARA POR HORA:");
				float pagoPorHora = teclado.nextFloat();

				if (tipoARegistrar == 2) {

					System.out.println("ASIGNELE UNA CAJA:");
					int caja = teclado.nextInt();

					mercadoTotola.agregarUsuario(new Cajero(nombre, apellido, edad, dni, nombreUsuario, contraseña,
							horario, caja, pagoPorHora));

				} else if (tipoARegistrar == 3) {
					mercadoTotola.agregarUsuario(new Repositor(nombre, apellido, edad, dni, nombreUsuario, contraseña,
							horario, pagoPorHora));
				} else {
					System.out.println("QUE ZONA VIGILARA:");
					String zonaAVigilar = teclado.nextLine();

					mercadoTotola.agregarUsuario(new Seguridad(nombre, apellido, edad, dni, nombreUsuario, contraseña,
							horario, zonaAVigilar, pagoPorHora));
				}
			}

		} catch (UsuarioIncorrectoException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
