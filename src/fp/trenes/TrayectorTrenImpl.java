package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class TrayectorTrenImpl implements TrayectoTren {
	
	//------- Atributos ---------------------------------------------------------------------------------
	
	private String codigo;
	private String nombre;
	private TipoTren tipoTren;
	private List<String> estaciones;
	private List<LocalTime> horasSalida;
	private List<LocalTime> horasLlegada;
	
	//------- Getters -----------------------------------------------------------------------------------
	
	public String getCodigoTren() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoTren getTipoTren() {
		return tipoTren;
	}

	public List<String> getEstaciones() {
		return estaciones;
	}

	public List<LocalTime> getHorasSalida() {
		return horasSalida;
	}

	public List<LocalTime> getHorasLlegada() {
		return horasLlegada;
	}
	
	//------- Propiedades derivadas ------------------------------------------------------------------------

	public LocalTime getHoraSalida() {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalTime getHoraLlegada() {
		// TODO Auto-generated method stub
		return null;
	}

	public Duration getDuracion() {
		// TODO Auto-generated method stub
		return null;
	}

	//------ Funciones auxiliares --------------------------------------------------------------------------------------
	
	public LocalTime getHoraSalida(String estacion) {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalTime getHoraLlegada(String estacion) {
		// TODO Auto-generated method stub
		return null;
	}

	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		// TODO Auto-generated method stub

	}

	public void eliminarEstacionIntermedia(String estacion) {
		// TODO Auto-generated method stub

	}

}
