package Ej2_169;

import java.io.Serializable;

public class Persona implements Serializable{
	String nombre;
	int edad;
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre=nombre;
		this.edad=edad;
		
	}
	
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}


	public Persona() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
