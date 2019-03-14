/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio:  n1_lineasTelefonicas
 * Autor: Pablo Barvo - Dec 7, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.lineasTelefonicas.test;

import uniandes.cupi2.lineasTelefonicas.mundo.LineaTelefonica;
import junit.framework.TestCase;

/**
 * Pruebas de la clase LineaTelefonica
 */
public class LineaTelefonicaTest extends TestCase
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * L�nea telef�nica de prueba
     */
    private LineaTelefonica linea;

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Construye una nueva L�nea Telef�nica vac�a
     */
    private void setupEscenario1( )
    {
        linea = new LineaTelefonica( );
        linea.inicializar( );
    }

    /**
     * Prueba 1 - Agregar llamada celular
     */
    public void testAgregarLlamadaCelular( )
    {
        setupEscenario1( );
        linea.agregarLlamadaCelular( 10 );
        assertEquals( "El n�mero de llamadas debe ser 1", 1, linea.darNumeroLlamadas( ) );
        assertEquals( "El n�mero de minutos debe ser 10", 10, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $9.990", 9990, linea.darCostoLlamadas( ), 0.001 );
    }

    /**
     * Prueba 2 - Agregar llamada local
     */
    public void testAgregarLlamadaLocal( )
    {
        setupEscenario1( );
        linea.agregarLlamadaLocal( 5 );
        assertEquals( "El n�mero de llamadas debe ser 1", 1, linea.darNumeroLlamadas( ) );
        assertEquals( "El n�mero de minutos debe ser 5", 5, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $175", 175, linea.darCostoLlamadas( ), 0.001 );
    }

    /**
     * Prueba 3 - Agregar llamada larga distancia
     */
    public void testAgregarLlamadaLargaDistancia( )
    {
        setupEscenario1( );
        linea.agregarLlamadaLargaDistancia( 7 );
        assertEquals( "El n�mero de llamadas debe ser 1", 1, linea.darNumeroLlamadas( ) );
        assertEquals( "El n�mero de minutos debe ser 5", 7, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $2.660", 2660, linea.darCostoLlamadas( ), 0.001 );
    }

    /**
     * Prueba 4 - Reiniciar
     */
    public void testReiniciar( )
    {
        setupEscenario1( );
        linea.agregarLlamadaLargaDistancia( 7 );
        linea.reiniciar( );
        assertEquals( "El n�mero de llamadas debe ser 0", 0, linea.darNumeroLlamadas( ) );
        assertEquals( "El n�mero de minutos debe ser 0", 0, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $0.0", 0, linea.darCostoLlamadas( ), 0.001 );
    }

}
