/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author peque
 */
public class Colas {
    	
		Colas cola, ultimo,aux, siguiente, recorrer;
		int datos;
	/////CrearElemento////
	public Colas crear(int dato){
		aux = new Colas();
		aux.datos = dato;
		aux.siguiente = null;
	return aux;
	}
	//////vacia////////
	public void vacia(){
		cola = null;
		ultimo = null;	
	}
	
	////////////primero////////función que devuelve el valor del primer elemento de la cola.
	public int primero(){
		return cola.datos;
	}
	
	//////////////inserta//////inserta el elemento al final de la cola.
	public void inserta(int dato){
		aux = this.crear(dato);
		if(esVacia()){
			cola = aux;
			ultimo = aux;
			ultimo.siguiente = null;
			}else{
		ultimo.siguiente = aux;
		ultimo = ultimo.siguiente;
		ultimo = aux;
	}
	}
	
	///////////////quitarPrimero///////////////suprime el primer elemento de la cola.
	public void quitarPrimero(){
		cola = cola.siguiente;	
	}
	
	//////////////esVacia/////////////Devuelve verdadero si la cola está vacía.
	public boolean esVacia(){
	return (cola == null ) ? true : false;
	}
	
	
	//////Sumar/////////
	public int sumar(){
		int salida = 0;
		recorrer = cola;
		while(recorrer != null){
			salida += recorrer.datos;
			quitarPrimero();
			recorrer = recorrer.siguiente;
		}
	return salida;
	}
///////////Invertir orden de la cola//////////
	public String invertirOrden(){
		String salida = "";
		int con = 0;
		String  a = "";
		int aux [] = new int [this.tamanoCola()];
		recorrer = cola;
		if(this.esVacia()){
			salida = "Cola esta vacia";
		}else {
			while(recorrer != null){
				aux[con] = recorrer.datos;
				recorrer = recorrer.siguiente;
				con++;
			}
		
			this.vacia();
			
			for(int x = (aux.length-1); x >= 0; x--){
				this.inserta(aux[x]);
			}
		salida = this.imprimir();	
		}
	return salida;
	}
////< > -
//////Imprimir cola////
	public String imprimir(){
		String salida ="";
		recorrer = cola;
		while(recorrer != null){
			salida += recorrer.datos+"	";
			recorrer = recorrer.siguiente;
		}
	return salida;
	}
/////////Tamano de la cola//////////
	public int tamanoCola(){
		int salida = 0;
		recorrer = cola;
		while(recorrer != null){
			salida++;
			recorrer = recorrer.siguiente;
		}
	return salida;
	}
	
	
}
