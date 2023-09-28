package co.com.retotecnico.certificacion.stepDefinitions;

import co.com.retotecnico.certificacion.interactions.AbrirNavegador;
import co.com.retotecnico.certificacion.models.DatosPersonalesBuilder;
import co.com.retotecnico.certificacion.questions.ValidacionCondicional;
import co.com.retotecnico.certificacion.task.CrearClaveUltimoPaso;
import co.com.retotecnico.certificacion.task.IngresarDatosDelDispositivos;
import co.com.retotecnico.certificacion.task.IngresarDatosPersonales;
import co.com.retotecnico.certificacion.task.IngresarDirecciones;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.util.List;
import java.util.Map;

public class RegistroStep {

    @Dado("^que keissiant quiere abrir la pagina$")
    public void queKeissiantQuiereAbrirLaPagina() {
        theActorInTheSpotlight().attemptsTo(AbrirNavegador.enPagina());
    }

    @Cuando("^el se registra de manera exitosa$")
    public void elSeRegistraDeManeraExitosa(List<Map< String, String>> datos)  {
        theActorInTheSpotlight().attemptsTo(
                IngresarDatosPersonales.enPrimerPaso(DatosPersonalesBuilder.con()
                        .firstName(datos)
                        .lastName(datos)
                        .email(datos)
                        .mes(datos)
                        .dia(datos)
                        .anio(datos)));
        theActorInTheSpotlight().attemptsTo(
                IngresarDirecciones.enSegundoPaso(DatosPersonalesBuilder.con()
                                        .city(datos)
                                                .codPostal(datos)
                                                        .pais(datos)));
        theActorInTheSpotlight().attemptsTo(IngresarDatosDelDispositivos.enTercerPaso(),
                CrearClaveUltimoPaso.enCuartoPaso());

    }

    @Entonces("^podra visualizar un mensaje de bienvenida$")
    public void podraVisualizarUnMensajeDeBienvenida() {
        theActorInTheSpotlight().should(seeThat(ValidacionCondicional.paraElFormulario()));
    }
}
