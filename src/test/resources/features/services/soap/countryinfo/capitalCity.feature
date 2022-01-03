
Feature: buscar ciudad capital por código ISO del país
        Yo como usuario del servicio
        Quiero poder consultar la capital de un país por su código ISO
        porque necesito utilizar la información

  Scenario Outline: busqueda con con error en servidor
    When el usuario ejecute la petición con código "<isoCodeCountry>"  para buscar una ciudad capital
    Then el usuario debería obtener el nombre de ciudad "<capitalCity>"
    Examples:
      | isoCodeCountry | capitalCity                       |
      | BB             | Bridgetown                        |
      | BW             | Gaborone                          |
      | shghj56        | Country not found in the database |

  Scenario: busqueda sin coincidencias
    When el usuario ejecute la petición con código "&%_ddd"  para buscar una ciudad capital
    Then el sistema no encontrará ninguna ciudad y la respuesta será "Server Error"
