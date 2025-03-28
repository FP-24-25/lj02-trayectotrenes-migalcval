package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public interface TrayectoTren {
	
	//------- Getters -----------------------------------------
	
	String getCodigoTren();
	String getNombre();
	TipoTren getTipoTren();
	List<String> getEstaciones();
	List<LocalTime> getHorasSalida();
	List<LocalTime> getHorasLlegada();
	LocalTime getHoraSalida();
	LocalTime getHoraLlegada();
	Duration getDuracion();
	
	//------ Otras operaciones ---------------------------------
	
	LocalTime getHoraSalida(String estacion);
	LocalTime getHoraLlegada(String estacion);
	void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida);
	void eliminarEstacionIntermedia(String estacion);

}
