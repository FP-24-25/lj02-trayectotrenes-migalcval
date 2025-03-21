package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrayectoTrenImpl2 implements TrayectoTren {
	
	
	//------- Atributos ------------------------------------------------------------------------------------------------------------
	
	private String codigo;
	private String nombre;
	private TipoTren tipoTren;
	private List<Parada> paradas;
	
	//------ Constructores --------------------------------------------------------------------------------------------------------
	//Constructor 1
	public TrayectoTrenImpl2(String codigo, String nombre, TipoTren tipoTren, String estacionOrigen, String estacionFin, LocalTime horaSalidaOrigen, LocalTime horaLlegadaFin) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoTren = tipoTren;
		paradas = new ArrayList<>();
		Parada a1 = new Parada(estacionOrigen, null, horaSalidaOrigen);
		paradas.addFirst(a1);
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
			res += a.estacion() + "      " + a.horaSalida() + "      " + a.horaLlegada() + "\n";
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
		// TODO Auto-generated method stub

	}

	public void eliminarEstacionIntermedia(String estacion) {
		// TODO Auto-generated method stub

	}
	
	public LocalTime getHoraSalida(String estacion) {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalTime getHoraLlegada(String estacion) {
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
