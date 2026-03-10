💱 Conversor de Monedas - Challenge ONE Java
Este proyecto es una aplicación de consola en Java que permite realizar conversiones de divisas en tiempo real. Fue desarrollado como parte del desafío del programa Oracle Next Education (ONE) en conjunto con Alura Latam.

📝 Descripción
El conversor utiliza la API de ExchangeRate-API para obtener las tasas de cambio más actuales. La aplicación gestiona solicitudes HTTP, procesa datos en formato JSON y ofrece una interfaz interactiva y robusta para el usuario.

✨ Características
Conversiones disponibles:

Dólar (USD) a Peso Argentino (ARS).

Peso Argentino (ARS) a Dólar (USD).

Dólar (USD) a Real Brasileño (BRL).

Real Brasileño (BRL) a Dólar (USD).

Dólar (USD) a Peso Colombiano (COP).

Peso Colombiano (COP) a Dólar (USD).

Historial de sesiones: Al finalizar, el programa muestra todas las conversiones realizadas con su respectiva fecha y hora.

Validación de errores: Manejo de excepciones para entradas no numéricas, errores de conexión y claves de API inválidas.

🛠️ Tecnologías Utilizadas
Lenguaje: Java 17+ (o la versión que estés usando).

Librería Externa: Gson 2.11.0 (para el mapeo de objetos JSON).

Gestor de Dependencias: Maven.

API: ExchangeRate-API.

🚀 Cómo Ejecutar el Proyecto
Clonar el repositorio:

Bash
git clone https://github.com/tu-usuario/conversor-de-monedas.git
Obtener una API Key:
Regístrate en ExchangeRate-API y obtén tu llave gratuita.

Configurar la API Key:
En la clase ConsultaMoneda.java, busca la variable apiKey y pega tu llave:

Java
String apiKey = "TU_API_KEY_AQUI";
Compilar y Correr:
Importa el proyecto en IntelliJ IDEA como un proyecto Maven y ejecuta la clase Principal.java.

📂 Estructura del Proyecto
El proyecto sigue una arquitectura organizada por paquetes para facilitar el mantenimiento:

com.alura.conversormonedas.modelos: Contiene la lógica de la API (ConsultaMoneda), los Records (TasaDeCambio) y la lógica de negocio.

com.alura.conversormonedas.principal: Contiene la clase Principal que gestiona la interacción con el usuario.

📸 Ejemplo de Uso
Plaintext
***************************************************
Sea bienvenido/a al Conversor de Moneda =]

1) Dólar =>> Peso argentino
   ...
   Elija una opción válida:
   1
   Ingrese el valor que desea convertir:
   100
   El valor 100.00 [USD] corresponde al valor final de =>>> 145225.00 [ARS]
***************************************************
Autor: Eddynel Munoz Rodriguez
Programa: ONE - Oracle Next Education