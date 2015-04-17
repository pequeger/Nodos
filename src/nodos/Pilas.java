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
public class Pilas {
	Pilas cima, pila, aux, siguiente, recorrer;
	int dato;
//////////////////////crear////////
	public Pilas crear(int dato){
		aux = new Pilas();
		aux.dato = dato;
		aux.siguiente = null;
	return aux;
	}
//////////Apila//////////////
	public void apila(int dato){
		aux = this.crear(dato);
		if(esVacia()){
			aux.siguiente = cima;
			cima = aux;
			pila = aux;
		}else{
			aux.siguiente = cima;
			cima = aux;
		}
	}
////////////esVacia////////////
	public boolean esVacia(){
		return (cima == null) ? true: false;
	}
///////////vacia/////////////
	public void vacia(){
		cima = null;
		pila = null;
	}
//////////cima/////////////
	public int cima(){
	return cima.dato;	
	}
/////////desapila//////////Suprime el elemento superior de la pila.
	public void desapila(){
		cima = cima.siguiente;
	}
////////////////Sumar de dos en dos los elementos de la pila////////////////
	public int  sumar2en2(){
		int suma = 0;
		recorrer = cima;
		while(recorrer!=null){
			suma = 0;
			suma = recorrer.dato + recorrer.siguiente.dato;
			desapila();
			cima.dato = suma;
			recorrer = recorrer.siguiente;
			if(recorrer.siguiente == null){
				cima.dato = suma;
				pila.dato = suma;
			}
		}
	return cima();
	}
	
///////////////tamano de la Pila//////////
	public int tamanoPila(){
		int salida = 0;
		recorrer = cima;
		int control = 0;
		while(control == 0){
			if(recorrer == pila){
				salida ++;
				control =1;
			}else{
				salida ++;
				recorrer = recorrer.siguiente;
			}
		}
	return salida;
	}
//////////////Imprimir/////////
	public String imprimir(){
		String salida = "";
		recorrer = cima;
		if(esVacia()){
			salida = "La pila esta vacia";
		} else {
			while(recorrer != null){
				System.out.print(recorrer.dato+"\n");
				salida += recorrer.dato+"	";
				recorrer = recorrer.siguiente;
			}
		}
	return salida;
	}

///////////////////Eliminar//////////////
	 public String eliminar(int dato){
		 String salida ="No se elimino el elemento";
		int aux [] = new int [this.tamanoPila()];
		recorrer = cima;
		int con =0;
		if(esVacia()){
			salida = "La pila esta vacia";
		} else {
			while(recorrer!=null){
				aux[con] = recorrer.dato;
				recorrer = recorrer.siguiente;
				con++;
			}
			
			this.vacia();
			
			for(int x = (aux.length-1); x >= 0; x--){
				if(aux[x]!=dato){
					this.apila(aux[x]);
				} else {
					salida = "Elemento eliminado";
				}
			}
		}
		
	return salida;
	}

    
}
