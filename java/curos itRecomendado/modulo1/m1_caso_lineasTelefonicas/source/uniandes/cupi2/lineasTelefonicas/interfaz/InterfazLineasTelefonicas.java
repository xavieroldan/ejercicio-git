/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Pablo Barvo - 06-Dec-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.lineasTelefonicas.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.lineasTelefonicas.mundo.Empresa;

/**
 * Esta es la ventana principal de la aplicaci�n.
 */
public class InterfazLineasTelefonicas extends JFrame
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private Empresa empresa;

    /**
     * Panel con la imagen
     */
    private PanelImagen panelImagen;

    /**
     * Panel con los totales
     */
    private PanelTotales panelTotales;

    /**
     * Panel L�nea 1
     */
    private PanelLineaTelefonica panelLinea1;

    /**
     * Panel L�nea 2
     */
    private PanelLineaTelefonica panelLinea2;

    /**
     * Panel L�nea 3
     */
    private PanelLineaTelefonica panelLinea3;

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor de la interfaz
     */
    public InterfazLineasTelefonicas( )
    {
        // Crea la clase principal
        empresa = new Empresa( );
        empresa.inicializar( );

        // Construye la forma
        // organizar el panel principal
        getContentPane( ).setLayout( new BorderLayout( ) );
        //setSize( 530, 530 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "MiEmpresa - Manejo L�neas Telef�nicas" );

        //Creaci�n de los paneles aqu�
        JPanel panelSuperior = new JPanel( );
        panelSuperior.setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelSuperior, BorderLayout.NORTH );

        panelImagen = new PanelImagen( );
        panelSuperior.add( panelImagen, BorderLayout.WEST );

        panelTotales = new PanelTotales( );
        panelSuperior.add( panelTotales, BorderLayout.CENTER );

        JPanel panelContenedor = new JPanel( );
        panelContenedor.setLayout( new GridLayout( 1, 3 ) );
        getContentPane( ).add( panelContenedor, BorderLayout.CENTER );

        //Agrega los paneles al panel contenedor
        panelLinea1 = new PanelLineaTelefonica( this, 1 );
        panelContenedor.add( panelLinea1 );
        panelLinea2 = new PanelLineaTelefonica( this, 2 );
        panelContenedor.add( panelLinea2 );
        panelLinea3 = new PanelLineaTelefonica( this, 3 );
        panelContenedor.add( panelLinea3 );

        //Panel extensiones
        panelExtension = new PanelExtension( this );
        getContentPane( ).add( panelExtension, BorderLayout.SOUTH );

        pack( );
        setResizable( false );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Agrega una llamada a una l�nea telef�nica <br>
     * <b>pre: </b> 1 >= numeroLinea >= 3 <br>
     * @param numeroLinea Numero de la l�nea telef�nica
     */
    public void agregarLlamada( int numeroLinea )
    {
        //
        //Pregunta el numero de minutos
        String minutos = JOptionPane.showInputDialog( this, "N�mero de Minutos hablados:" );
        try
        {
            if( minutos != null )
            {
                int min = Integer.parseInt( minutos );
                if( min <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "El n�mero de minutos debe ser mayor a cero", "Error", JOptionPane.ERROR_MESSAGE );
                    return;
                }
                Object[] possibilities = { "Local", "Larga distancia", "Celular" };
                String tipo = ( String )JOptionPane.showInputDialog( this, "Tipo de llamada:", "Tipo", JOptionPane.QUESTION_MESSAGE, null, possibilities, "Local" );
                if( tipo != null )
                {
                    if( numeroLinea == 1 )
                    {
                        if( "Local".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLocalLinea1( min );
                        }
                        else if( "Larga distancia".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLargaDistanciaLinea1( min );
                        }
                        else if( "Celular".equals( tipo ) )
                        {
                            empresa.agregarLlamadaCelularLinea1( min );
                        }
                    }
                    else if( numeroLinea == 2 )
                    {
                        if( "Local".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLocalLinea2( min );
                        }
                        else if( "Larga distancia".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLargaDistanciaLinea2( min );
                        }
                        else if( "Celular".equals( tipo ) )
                        {
                            empresa.agregarLlamadaCelularLinea2( min );
                        }
                    }
                    else if( numeroLinea == 3 )
                    {
                        if( "Local".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLocalLinea3( min );
                        }
                        else if( "Larga distancia".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLargaDistanciaLinea3( min );
                        }
                        else if( "Celular".equals( tipo ) )
                        {
                            empresa.agregarLlamadaCelularLinea3( min );
                        }
                    }
                    actualizar( );
                }
            }
        }
        catch( NumberFormatException e )
        {
            JOptionPane.showMessageDialog( this, "El n�mero de minutos es inv�lido", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Reinicia las l�neas telef�nicas
     */
    public void reiniciar( )
    {
        empresa.reiniciar( );
        actualizar( );
    }

    /**
     * Actualiza la visualizaci�n de la interfaz <br>
     * <b>post: </b> Se actualiza la visualizaci�n
     */
    private void actualizar( )
    {
        panelTotales.actualizar( empresa );
        panelLinea1.actualizar( empresa.darLinea1( ) );
        panelLinea2.actualizar( empresa.darLinea2( ) );
        panelLinea3.actualizar( empresa.darLinea3( ) );
    }

    //-----------------------------------------------------------------
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = empresa.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = empresa.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    //-----------------------------------------------------------------
    // Main
    //-----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
     * @param args Argumentos de el llamado. No se requiere ninguno.
     */
    public static void main( String[] args )
    {

        InterfazLineasTelefonicas interfaz = new InterfazLineasTelefonicas( );
        interfaz.setVisible( true );
    }

}