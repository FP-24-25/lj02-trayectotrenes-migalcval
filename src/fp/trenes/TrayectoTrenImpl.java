package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrayectoTrenImpl implements Comparable<TrayectoTren> {
	
	//------- Atributos ---------------------------------------------------------------------------------
	
	private String codigo;
	private String nombre;
	private TipoTren tipoTren;
	private List<String> estaciones;
	private List<LocalTime> horasSalida;
	private List<LocalTime> horasLlegada;
	
	//------ Constructores ------------------------------------------------------------------------------
	
	//Constructor1
	public TrayectoTrenImpl(String codigo, String nombre, TipoTren tipoTren, String estacionOrigen, String estacionFin, LocalTime horaSalidaOrigen, LocalTime horaLlegadaFin) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoTren = tipoTren;
		this.estaciones = new ArrayList<>();
		estaciones.add(estacionOrigen);
		estaciones.add(estacionFin);
		this.horasSalida = new ArrayList<>();
		horasSalida.add(horaSalidaOrigen);
		horasSalida.add(null);
		this.horasLlegada = new ArrayList<>();
		horasLlegada.add(null);
		horasLlegada.add(horaLlegadaFin);
	}
	
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
	
	//------- Metodo toString() ----------------------------------------------------------------------------
	
	public String toString() {
		return "TrayectoTrenImpl [codigo=" + codigo + ", nombre=" + nombre + ", tipoTren=" + tipoTren + ", estaciones="
				+ estaciones + ", horasSalida=" + horasSalida + ", horasLlegada=" + horasLlegada + "]";
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
	
	//----- Criterio de igualdad --------------------------------------------------------------------------------------
	
	public int compareTo(TrayectoTren tt) {
		int res = this.getNombre().compareTo(tt.getNombre());
		if (res == 0) {
			res = this.getHoraSalida().compareTo(tt.getHoraSalida());
			if (res == 0) {
				res = this.getCodigoTren().compareTo(tt.getCodigoTren());
				}
			}
		return res;
	}
	
	//------ Criterio de ordenacion -----------------------------------------------------------------------------------
	
	public int hashCode() {
		return Objects.hash(nombre, horasSalida, codigo);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrayectoTrenImpl other = (TrayectoTrenImpl) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(horasSalida, other.horasSalida)
				&& Objects.equals(codigo, other.codigo);
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
