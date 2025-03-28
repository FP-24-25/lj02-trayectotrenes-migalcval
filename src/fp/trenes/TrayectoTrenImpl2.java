package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class TrayectoTrenImpl2 implements TrayectoTren {
	
	
	//------- Atributos ------------------------------------------------------------------------------------------------------------
	
	private String codigo;
	private String nombre;
	private TipoTren tipoTren;
	private List<Parada> paradas;
	
	//------ Constructores --------------------------------------------------------------------------------------------------------
	//Constructor 1
	public TrayectoTrenImpl2(String codigo, String nombre, TipoTren tipoTren, String estacionOrigen, String estacionFin, LocalTime horaSalidaOrigen, LocalTime horaLlegadaFin) {
		Checkers.check("El código de un tren debe estar formado por 5 dígitos.", codigo.length() == 5 && sonDigitos(codigo));
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoTren = tipoTren;
		paradas = new ArrayList<>();
		Checkers.check("La hora de salida de la primera estación debe ser anterior a la hora de llegada a la última estación", horaSalidaOrigen.isBefore(horaLlegadaFin));
		Checkers.check("La hora de salida de la primera estación no puede ser nula", horaSalidaOrigen != null);
		Parada a1 = new Parada(estacionOrigen, null, horaSalidaOrigen);
		paradas.addFirst(a1);
		Checkers.check("La hora de llegada a la última estación no puede ser nula", horaLlegadaFin != null);
		Parada a2 = new Parada(estacionFin, horaLlegadaFin, null);
		paradas.addLast(a2);
	}
	
	//------ Getters ---------------------------------------------------------------------------------------------------------------

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
		List<String> res = new ArrayList<>();
		for (Parada a: paradas) {
			res.add(a.estacion());
		}
		return res;
	}

	public List<LocalTime> getHorasSalida() {
		List<LocalTime> res = new ArrayList<>();
		for (Parada a: paradas) {
			res.add(a.horaSalida());
		}
		return res;
	}

	public List<LocalTime> getHorasLlegada() {
		List<LocalTime> res = new ArrayList<>();
		for (Parada a: paradas) {
			res.add(a.horaLlegada());
		}
		return res;
	}
	
	//------ Metodo toString() --------------------------------------------------------------------------------------------------------
	
	public String toString() {
		return nombre + "-" + tipoTren + " " + "(" + codigo + ")\n" + mostrarParadas(paradas);
	}
	
	private String mostrarParadas(List<Parada> paradas2) {
		
		String res = "";
		for (Parada a: paradas2) {
			res += a.estacion() + "      " + a.horaLlegada() + "      " + a.horaSalida() + "\n";
		}
		return res;
	}

	//------ Propiedades derivadas -----------------------------------------------------------------------------------------------------

	public Duration getDuracion() {
		return Duration.between(getHoraSalida(), getHoraLlegada());
	}

	public LocalTime getHoraSalida() {
		return getHorasSalida().getFirst();
	}

	public LocalTime getHoraLlegada() {
		return getHorasLlegada().getLast();
	}
	
	//------ Operaciones auxiliares ----------------------------------------------------------------------------------------------------------
	
	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		Checkers.check("La posicion no es una posicion intermedia", (posicion > 0) && (posicion < getEstaciones().size()));
		getEstaciones().add(posicion, estacion);
		Checkers.check("La hora de llegada debe ser anterior a la hora de salida", horaLlegada.isBefore(horaSalida));
		Checkers.check("La hora de llegada debe ser posterior a la hora de salida de la estacion anterior", horaLlegada.isAfter(getHorasSalida().get(posicion-1)));
		getHorasLlegada().add(posicion, horaLlegada);
		Checkers.check("La hora de salida debe ser anterior a la hora de llegada de la siguiente estacion", horaSalida.isBefore(getHorasLlegada().get(posicion+1)));
		getHorasSalida().add(posicion, horaSalida);
	}

	public void eliminarEstacionIntermedia(String estacion) {
		Integer pos = buscarPosicionEstacion(estacion);
		if (pos != 0 && pos < getEstaciones().size()) {
			getEstaciones().remove((int) pos);
			getHorasLlegada().remove((int) pos);
			getHorasSalida().remove((int) pos);
		} else {
			throw new IllegalArgumentException("No se puede eliminar la estacion dada como parametro");
		}
	}
	
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
	
	private Integer buscarPosicionEstacion(String estacion) {
		Integer res = null;
		Integer i = 0;
		for (String e: getEstaciones()) {
			if (e.equals(estacion)) {
				res = i;
				break;
			}
			i++;
		}
		return res;
	}
	
	private boolean sonDigitos(String codigo2) {
		boolean res = true;
		for (Character c: codigo2.toCharArray()) {
			if (!Character.isDigit(c)) {
				res = false;
				break;
			}
		}
		return res;
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
		return Objects.hash(nombre, getHorasSalida(), codigo);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrayectoTrenImpl other = (TrayectoTrenImpl) obj;
		return Objects.equals(nombre, other.getNombre()) && Objects.equals(getHorasSalida(), other.getHorasSalida())
				&& Objects.equals(codigo, other.getCodigoTren());
	}
}
