
Feature: Registrar usuario en Utest
  Yo como usuario
  quiero registrarme en la página Utest
  para validar creación de nuevo usuario

  Scenario Outline: Registrar usuario en Utest
    Given que Keissiant abre la pagina
    When el registra los datos personales y crea nuevo usuario con los siguiente datos
      | firstName   | lastName   | email   | mes   | dia   | anio   | city   | codPostal   | pass   |
      | <firstName> | <lastName> | <email> | <mes> | <dia> | <anio> | <city> | <codPostal> | <pass> |
    Then se vera mensaje de login Exitoso
    Examples:
      | firstName | lastName           | email               | mes | dia | anio | city   | codPostal | pass          |
      | Keissiant | apellido keissiant | keissiant@gmail.com | May | 10  | 1990 | Bogota | 050014    | Key-123456789 |