package es.iesvegademijas.anotaciones;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Credenciales.class)
@Retention(RetentionPolicy.RUNTIME)

public @interface Credencial {
	String usuario();
	String hashPasswd();

}
