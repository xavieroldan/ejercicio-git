@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n1_lineasTelefonicas
REM Autor: Pablo Barvo - 06-Dec-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

REM ---------------------------------------------------------
REM Ejecuci�n de las pruebas
REM ---------------------------------------------------------

java -classpath ../lib/lineasTelefonicas.jar;../test/lib/lineasTelefonicasTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.lineasTelefonicas.test.EmpresaTest
java -classpath ../lib/lineasTelefonicas.jar;../test/lib/lineasTelefonicasTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.lineasTelefonicas.test.LineaTelefonicaTest