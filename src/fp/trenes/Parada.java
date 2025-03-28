package fp.trenes;

import java.time.LocalTime;

import fp.utiles.Checkers;

public record Parada(String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
	
	public Parada {
		Checkers.check("La hora de llegada y la hora de salida no pueden ser nulas a la vez", 
				horaLlegada() != null && horaSalida() != null);
		
		Checkers.check("La hora de salida debe ser posterior a la hora de llegada si ninguna es nula" , 
				compruebaHoras(horaLlegada(), horaSalida()));
	}

	private Boolean compruebaHoras(LocalTime horaLlegada2, LocalTime horaSalida2) {
		Boolean res = true;
		if (horaLlegada2 != null && horaSalida2 != null) {
			res = horaSalida2.isAfter(horaLlegada2);
		}
		return res;
	}
	
	
}
