# new feature
# Tags: optional

Feature: Usuarios
  Yo como usuario
  Quiero llamar y editar mis datos de la pagina
  Para poder mantener mis datos actualizados

  Scenario: llamar Datos
    Given quiero ver mi informacion registrada en la pagina
    When  Cuando mande a llamar mis datos
    Then  entnces me mostrara un mensaje de ok y una lista de mis datos

  Scenario:  Editar Datos
    Given Despues de ver mi datos me gustaria editar mi nombre a "Javier" y trabajo a "Qa"
    When  Haga la peticion de cambio
    Then  Entonces me saldra un mensaje de ok, y la lista de mis datos