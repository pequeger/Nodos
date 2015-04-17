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
public class Lista {
    Lista primero;
    Lista siguiente, aux, aux2, ultimo, recorrer;
	int contador;
	int dato;
	
	////Crear un elemento///
	public Lista crearElemento(int datos){
		aux = new Lista();
		aux.dato = datos;
		aux.siguiente = null;
	return aux;
	}	
	
	public void nodoInicio(int datos){
		aux = crearElemento(datos);
		if(primero == null){
			primero = aux;
			ultimo = aux;
			ultimo.siguiente = null;
			}else{
				aux.siguiente = primero;
				primero = aux;
				}
		}
		
	public void nodoFinal (int datos){
		aux = crearElemento(datos);
		if (primero==null){
			primero=aux;
			ultimo=aux;
		}else {
			ultimo.siguiente=aux;
			ultimo=aux;
			
				}
			
			}//fin metodo
		
	public String agregarEnPoscision(int posicion, int datos) {
		String mensaje = "";
		int control = 0;
		int pos = 1;
		aux = crearElemento(datos);
		while(control == 0 ){
			if((pos+1) == posicion){
				aux2 = recorrer;
				aux.siguiente = recorrer.siguiente;
				aux2.siguiente = aux;
				mensaje = "Se agrego el producto";
				control = 1;
			}else{
				recorrer = recorrer.siguiente;
				pos++;
				}
		}
		return mensaje;
	}
	
	public String agregar(int datos, int posicion) {
		String mensaje = "";
		int pos = 1;
		aux = crearElemento(datos);
		aux2 = null;
		if (vacia()){
			nodoInicio(datos);
			mensaje ="Lista vacia, proyecto agregado en la primer posicion";
			}else{
				recorrer = primero;
				if(pos == posicion){
					nodoInicio(datos);
					mensaje = "Lista no esta null, Se agrego el proyecto en la primera posicion.";
				} else if(posicion > cantidadLista()) {
					nodoFinal(datos);
					mensaje = "Se agrego al final de la lista, porque la posicion esa fuera de rango.";
					
				}else{
					agregarEnPoscision(posicion, datos);
					mensaje = "Se agrego en la posicion indicada.";
				}
			}
		return mensaje;
	}
	

	///////// Cantidad Elementos/////////
	public int cantidadLista(){
	int salida = 0;
	aux = primero;
	if(vacia()){
		salida =0;
		}else{
			while(aux != null){
				salida ++;
				aux = aux.siguiente;
				}
			}
	return salida;		
	}
	
	////Metodo vacia////
	public boolean vacia(){
	return(primero == null) ? true : false;	
	}
	
	
	public int localiza(int dato){
		int salida = 0;
		int posicion = 1;
		recorrer = primero;
		while(recorrer.siguiente!=null){
			if(recorrer.dato == dato){
				salida = posicion;
				recorrer.siguiente = null;
			} else {
				recorrer = recorrer.siguiente;
			}
		}
	return salida;
	}
	/////Recupera////
	public String recupera( int posicion){
		String salida = "";
		int pos = 1;
		recorrer = primero;
		while(recorrer.siguiente != null){
			if(pos == posicion){
				salida = ""+recorrer.dato;
				recorrer.siguiente = null;
			} else {
				recorrer = recorrer.siguiente;
			}
		}
		if(salida.equals("")){
			salida = "null, no se encuentra.";
		}
	return salida;
	}
	/////Suprime/////
	
	public String suprime(int posicion){
		String salida ="";
		int pos = 1;
		if(vacia()){
			salida = "Lista vacia, no existe elemento para eliminar";
			}else{
				recorrer = primero;
				if(pos == posicion ){
					primero = null;
					ultimo = null;
					salida = "Se elimino el elemento";
					}else{
						while(recorrer.siguiente != null){
							if(pos == posicion){
								aux = recorrer.siguiente;
								recorrer.siguiente = aux.siguiente;
								salida = "Se elimino el elemento";
								recorrer.siguiente = null;
							}else if (recorrer.siguiente == null){
								salida = "No se elimino el elemento";	
							}else {
									recorrer = recorrer.siguiente;
							}
						}//ciclo
					}
		}
		return salida;	
		}
	//////Anula//////
	public void anula(){
		primero = null;
		ultimo = null;	
	}
	
	//////Primero/////
	public String  ultimo(){
		if(vacia()){
			return "No hay elementos";
		}else{
			return primero.dato+"";
		}
	}
	
	/////Imprimir lista////
	public String print() {
        String salida = "";
        aux = primero;
        if (vacia()) { 
            salida = "La lista esta vacia";
        } else { 
            while (aux != null) {  
                if (aux != null) {
                    salida  += aux.dato + "	";
                    aux = aux.siguiente;
                }
            }
        }
        return salida;
    }
 
 //////////////////ordenar////////////////
	public void ordenar() {
		int aux [] = new int [this.cantidadLista()];
		int con = 0;
		recorrer = primero;
		if(vacia()){
			
		} else {
			System.out.print(recorrer.dato);
			while(recorrer != null){
				aux[con] = recorrer.dato;
				recorrer = recorrer.siguiente;
				con++;
			}
			this.anula();
			
			for (int j = 0; j < aux.length; j++) {
				for (int k = 0; k < aux.length-1; k++) {
					if(aux[k]>aux[k+1]){
						int mayor = aux[k];
						aux[k]=aux[k+1];
						aux[k+1]=mayor;
					}
				}
			}
			
			for(int x =0; x < aux.length; x++){
				this.nodoFinal(aux[x]);
			}
		}
		
    }
    
    
}
