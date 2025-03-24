package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

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
		Checkers.check("El código de un tren debe estar formado por 5 dígitos.", codigo.length() == 5);
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoTren = tipoTren;
		this.estaciones = new ArrayList<>();
		estaciones.add(estacionOrigen);
		estaciones.add(estacionFin);
		this.horasSalida = new ArrayList<>();
		Checkers.check("La hora de salida de la primera estación debe ser anterior a la hora de llegada a la última estación", horaSalidaOrigen.isBefore(horaLlegadaFin));
		Checkers.check("La hora de salida de la primera estación no puede ser nula", horaSalidaOrigen != null);
		horasSalida.add(horaSalidaOrigen);
		horasSalida.add(null);
		this.horasLlegada = new ArrayList<>();
		horasLlegada.add(null);
		Checkers.check("La hora de llegada a la última estación no puede ser nula", horaLlegadaFin != null);
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
		
		return nombre + "-" + tipoTren + " " + "(" + codigo + ")\n" + mostrarListas(estaciones, horasSalida, horasLlegada);
	}
	
	private String mostrarListas(List<String> estaciones2, List<LocalTime> horasSalida2, List<LocalTime> horasLlegada2) {
	    String res = "";
	    for (int i = 0; i < estaciones2.size(); i++) {
	        res += estaciones2.get(i) + "    " + horasSalida2.get(i) + "     " + horasLlegada2.get(i) + "\n";
	    }
	    return res;
	}

	//------- Propiedades derivadas ------------------------------------------------------------------------

	public LocalTime getHoraSalida() {
		return horasSalida.get(0);
	}

	public LocalTime getHoraLlegada() {
		return horasLlegada.getLast();
	}

	public Duration getDuracion() {
		return Duration.between(getHoraSalida(), getHoraLlegada());
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
		LocalTime res = null;
		Integer pos = buscarPosicionEstacion(estacion);
		if (pos != null) {
			res = getHorasSalida().get(pos);
		}
		return res;
	}

	public LocalTime getHoraLlegada(String estacion) {
		LocalTime res = null;
		Integer pos = buscarPosicionEstacion(estacion);
		if (pos != null) {
			res = getHorasLlegada().get(pos);
		}
		return res;
	}

	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		// TODO Auto-generated method stub

	}

	public void eliminarEstacionIntermedia(String estacion) {
		Integer pos = buscarPosicionEstacion(estacion);
		getEstaciones().remove((int) pos);
		getHorasLlegada().remove((int) pos);
		getHorasSalida().remove((int) pos);
		

	}
	
	private Integer buscarPosicionEstacion(String estacion) {
		Integer res = null;
		int i = 0;
		if (getEstaciones().contains(estacion)) {
			for (String e: getEstaciones()) {
				if (e.equals(estacion)) {
					res = i;
					break;
				}
				i++;
			}
		} 
		
		return res;
	}
}


