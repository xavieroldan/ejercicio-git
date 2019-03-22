/**
	*Primer codigo Java
	*Idea de crear objeto progrmador para controlar a 3 calderas
	*Definimos horario de 0 a 23 horas y temperatura deseada
	*Caldera se podrá apagar manualmente siendo indiferente entonces la señal del salidaTermostato
	*/
/**Defino clase ProgramadorCaldera
	*/
public class ProgramadorCaldera
{
	private int horaEncendido;
	private int horaApagado;
	private int horaActual;
	private int tempEncendido;
	private int tempActual;
	private int salidaProgramadorCaldera;
	private int salidaProgramador;
	private int salidaTermostato;
/**
	*Defino constructor ProgramadorCaldera
	*/
	ProgramadorCaldera(int horaEncendidoP, int horaApagadoP, int horaActualP, int tempActualP)
	{
		horaEncendido = horaEncendidoP;
		horaApagado = horaApagadoP;
		horaActual = horaActualP;
		tempActual = tempActualP;
		salidaProgramadorCaldera = 0;
		salidaTermostato = 0;
		salidaProgramador = 0;
	}

	public void cambiaHoraEncendido (int horaEncendidoP)
	{
		horaEncendido = horaEncendidoP;
	}

	public void cambiaHoraApagado (int horaApagadoP)
	{
		horaApagado = horaApagadoP;
	}

	public void cambiaHoraActual (int horaActualP)
	{
		horaActual = horaActualP;
	}

	public void daSalidaProgramador ()
	{
		if (horaActual <= horaEncendido)
				{
					salidaProgramador = 0;
				}
		else if (horaActual >= horaApagado)
				{
					salidaProgramador = 0;
				}
		else
				{
					salidaProgramador = 1;
				}
	}

	public void daSalidaTermostato ()
	{
		if (tempActual > tempEncendido)
				{
				salidaTermostato = 0;
				}
				else
				{
				salidaTermostato = 1;
				}
		}

	public int daSalidaProgramadorCaldera()
	{
			daSalidaProgramadorCaldera = salidaTermostato + salidaProgramador;
			if (salidaProgramadorCaldera < 2)
			{
				daSalidaProgramadorCaldera = 0;
			}
				else
			{
				daSalidaProgramadorCaldera = 1;
				return daSalidaProgramadorCaldera;
				}
			}
	}
