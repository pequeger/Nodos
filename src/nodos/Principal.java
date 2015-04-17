/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

import javax.swing.JOptionPane;

/**
 *
 * @author peque
 */
public class Principal {
    private int opcion;
		private Colas cola = new Colas ();
		private Pilas pila = new Pilas ();
		private Lista lista = new Lista ();
		
		public Principal(){
			opcion = 0;
			do{
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1 Ingresar numeros a una cola.\n"+
																			"2 Imprimir cola.\n"+
																			"3 Sumar los elemnetos de la cola.\n"+
																			"4 Invertir los elementos de la cola.\n"+
																			"5 Ingresar numero a una pila.\n"+
																			"6 Sumar elementos de la pila de dos en dos.\n"+
																			"7 Imprimir pila\n"+
																			"8 Eliminar elemeto de la pila.\n"+
																			"9 Crear lista.\n"+
																			"10 Imprimir lista\n"+
																			"11 Ordenar lista.\n"+
																			"12 salir."));
				switch(opcion){
					case 1://Ingresar numero a una cola
						int numeroCola = Integer.parseInt(JOptionPane.showInputDialog(null, "Diguite el numero para ingresarlo a la cola"));
						cola.inserta(numeroCola);
					break;
					
					case 2://Imprimir cola
						JOptionPane.showMessageDialog(null, cola.imprimir());
					break;
					
					case 3://Sumar los elemnetos de la cola
						JOptionPane.showMessageDialog(null, cola.sumar());
					break;
					
					case 4://Invertir los elementos de la cola
						JOptionPane.showMessageDialog(null, cola.invertirOrden());
					break;
					
					case 5://Ingresar numero a una pila.
						int numeroPila = Integer.parseInt(JOptionPane.showInputDialog(null, "Diguite el numero para ingresarlo a la pila"));
						pila.apila(numeroPila);
					break;
					
					case 6://Sumar elementos de la pila de dos en dos
						JOptionPane.showMessageDialog(null,pila.sumar2en2());
					break;
					
					case 7://Imprimir pila.
						JOptionPane.showMessageDialog(null,pila.imprimir());
					break;
					
					case 8://Eliminar elemeto de la pila.
						int elementoPila = Integer.parseInt(JOptionPane.showInputDialog(null, "Diguite el numero que desea eliminar en la pila"));
						pila.eliminar(elementoPila);
					break;
					
					case 9://Crear lista
						int elementoLista = Integer.parseInt(JOptionPane.showInputDialog(null, "Diguite el numero que desea ingresar  en la lista"));
						int pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Diguite la posicion que desea guardarlo"));
						JOptionPane.showMessageDialog(null,lista.agregar(elementoLista, pos));
					break;
					
					case 10://Imprimir lista
						JOptionPane.showMessageDialog(null,lista.print());
					break;
					
					case 11://Ordenar lista
						lista.ordenar();
					break;
					
					case 12:// Salir
						System.exit(0);
					break;
					
					default:
						JOptionPane.showMessageDialog(null, "Opcion invalida");
					break;
					
				}
																		
			}while(opcion != 12);
			
			}
	public static void main(String [] main){
		new Principal();
		}
    
}
