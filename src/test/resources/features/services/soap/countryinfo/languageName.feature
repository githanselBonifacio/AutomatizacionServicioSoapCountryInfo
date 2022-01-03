Feature: buscar el nombre de un lenguaje por código ISO
  Yo como usuario del servicio
  Quiero poder consultar el nombre de un lenguaje por su código ISO
  porque necesito utilizar la información

  Scenario Outline: busqueda con coincidencia unica
    When el usuario ejecute la petición con código "<codeLanguage>"  para buscar el nombre de un lenguaje
    Then el usuario debería obtener el lenguaje "<languageName>"
    Examples:
      | codeLanguage | languageName                 |
      | fr           | French                       |
      | es           | Spanish                      |
      | +*/*/__      | Language ISO Code not found! |
      | DFR          | Language ISO Code not found! |

  Scenario Outline: busqueda con error en el servidor
    When el usuario ejecute la petición con código "<codeLanguage>"  para buscar el nombre de un lenguaje
    Then el sistema no encontrará ningun lenguaje y la respuesta será "<response>"
    Examples:
      | codeLanguage  | response     |
      | &+2%          | Server Error |
      | &/*++*/*/__#$ | Server Error |