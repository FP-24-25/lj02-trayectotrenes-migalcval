package fp.trenes.test;

import java.time.LocalTime;

import fp.trenes.TipoTren;
import fp.trenes.TrayectoTrenImpl2;


public class TestTrayectoTrenImpl2 {

	public static void main(String[] args) {

		TrayectoTrenImpl2 tt = new TrayectoTrenImpl2("89704", "Sevilla-Madrid", TipoTren.AV_CITY, "Sevilla", "Madrid", LocalTime.of(7, 0), LocalTime.of(10, 20));
		mostrarTrayecto(tt);
	}
	
	//------ Metodo mostrar --------------------------------------------------------------------------------
	
	private static void mostrarTrayecto(TrayectoTrenImpl2 t) {
		
		System.out.println("Trayecto --> " + t);
		System.out.println("Codigo --> " + t.getCodigoTren());
		System.out.println("Nombre --> " + t.getNombre());
		System.out.println("Tipo de tren --> " + t.getTipoTren());
		System.out.println("Lista de estaciones --> " + t.getEstaciones());
		System.out.println("Lista de horas de salida --> " + t.getHorasSalida());
		System.out.println("List de horas de llegada --> " + t.getHorasLlegada());
		System.out.println("Hora de salida del tren --> " + t.getHoraSalida());
		System.out.println("Hora de llegada del tren --> " + t.getHoraLlegada());
		System.out.println("Duracion del trayecto --> " + t.getDuracion());
	}

}


