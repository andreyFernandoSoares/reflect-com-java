package br.com.revso.reflectAn;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.revso.annotations.Mostrar;
import br.com.revso.models.Cliente;

public class AnotationsPartOne {
	
	public static void main(String[] args) throws Exception {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Andrey");
		cliente.setNomePai("Ademir");
		
		System.out.println("Nome classe");
		System.out.println(cliente.getClass().getDeclaredAnnotation(Mostrar.class).value());
		System.out.println(Cliente.class.getName());
		
		System.out.println("-------------------------\n");
		
		System.out.println("Lista de Fields");
		Class<?> clazz =  cliente.getClass();
		
		for (Field f : clazz.getDeclaredFields()) {
			System.out.println(f.getName());
		}
		
		System.out.println("-------------------------\n");
		
		System.out.println("Lista de Methods");
		
		for (Method m : clazz.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Mostrar.class)) {
				System.out.println(m.getDeclaredAnnotation(Mostrar.class).value()+": "+m.invoke(cliente));
			}
		}
	}
}
