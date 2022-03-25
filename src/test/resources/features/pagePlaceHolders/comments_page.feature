# new feature
# Tags: optional

Feature: Comentarios
  Yo como administrador
  Quiero obtener una lista de comentarios
  Para poder ver lo que opinan de mi pagina

  Scenario: Listar comentarios
    Given   Necesito poder ver todos los comentarios en mi pagina
    When    cuango haga la peticion
    Then    Me da como reultado un codigo de mensaje de OK, una lista en la que puedan verse los comentarios

  Scenario: Agregar los comentarios
    Given   Como usuario me gustaria pode agregar un comentario el cual tendra "Hernesto" "email@gmail.com" "mensaje1"
    When    cuando haga la peticion
    Then    Me da como reultado un codigo de mensaje de creado, el id asignado del comentario creado