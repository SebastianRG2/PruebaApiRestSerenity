# **Prueba Automatizacion**
## Introduction 

En este proyecto se ve plasmado el reto de automatizacion de Rappi donde se pide ejecutar escenarios donde el usuario pueda verificar las respuestas que devuelven los diferentes servicios REST.

# Pre requerimientos

- Java version 1.8 y JDK (Variables de entorno configuradas)
- IntelliJ IDEA 
- Gradle version 6.0 o mayor (Variables de entorno configuradas)
- Cucumber para java plugin
- Gherkin plugin


# Contruccion
La automatizacion esta desarrollada con:

- BDD - Estrategia de desarollo
- Screenplay 
- Gradle - Manejo de dependencias
- Selenium Web Driver - Herramienta de automatizacion en el navegador web
- Cucumber - Framework para automatizar test BDD
- Serenity BDD - Framework, Libreria open source para la generacion de reportes.
- Gherkin - Lenguaje Especifico de Dominio (DSL)

# Versionamiento

- Git es usado para la version de control.

# Lo que se esta probando la aplicacion

Se esta probando el funcionamiento correcto al momento de enviar un request a uno de los servicios REST.

# Comandos especificos para ejecución
    gradle test aggregate
    gradle build

