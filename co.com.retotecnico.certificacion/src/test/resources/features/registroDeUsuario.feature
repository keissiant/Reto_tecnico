#language: es

 Característica: Registro de usuario exitoso
   yo como usuario deseo ingresar a la pagina Utest
   para registrarme de manera exitosa.

  Esquema del escenario: Registro Exitoso
    Dado que keissiant quiere abrir la pagina
    Cuando el se registra de manera exitosa
      | firstName   | lastName   | email   | mes   | dia   | anio   | city   | codPostal   | pais   | pass   |
      | <firstName> | <lastName> | <email> | <mes> | <dia> | <anio> | <city> | <codPostal> | <pais> | <pass> |
    Entonces podra visualizar un mensaje de bienvenida
  Ejemplos:
    | firstName | lastName           | email     | mes | dia | anio | city   | codPostal | pais     | pass          |
    | Keissiant | apellido keissiant | keissiant | May | 10  | 1990 | Bogota | 050014    | Colombia | Key-123456789 |