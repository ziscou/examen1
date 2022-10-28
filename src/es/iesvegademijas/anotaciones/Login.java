package es.iesvegademijas.anotaciones;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

@Credencial(usuario = "usuario1", hashPasswd = "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918")
@Credencial(usuario = "usuario2", hashPasswd = "ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270")

public class Login {
	private String usuario;
	private String pass;
	
	public Login() {
		this.usuario = "";
		this.pass = "";
	}

	public void login() throws NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su usuario:");
		usuario=sc.nextLine();
		System.out.println("Introduzca su contraseña:");
		pass=sc.nextLine();
		pass=Password.hashPassword(pass);
		
		sc.close();
	}
	
	public static boolean cargadorContexto(Login login) {
		boolean passCorret=false;
		Credencial[] credenciales = Login.class.getAnnotationsByType(Credencial.class);
		
		for (Credencial credencial : credenciales) {
			if(login.getUsario().equals(credencial.usuario())) {
				if(login.getConrasenia().equals(credencial.hashPasswd())) passCorret=true;
			}
		}
		return passCorret;
	}

	public String getUsario() {
		return usuario;
	}





	public String getConrasenia() {
		return pass;
	}
	
	





	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		Login log = new Login();
		log.login();
		boolean passCorret = Login.cargadorContexto(log);
		
		if(passCorret) {
			System.out.println("Acceso concedido");
		}else {
			System.out.println("Acceso denegado");
		}
		
		

	}

}
