package co.com.retotecnico.certificacion.stepDefinitions;

import co.com.retotecnico.certificacion.interactions.AbrirNavegador;
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

public class RegistroStep {

    @Dado("^que keissiant quiere abrir la pagina$")
    public void queKeissiantQuiereAbrirLaPagina() {
        theActorInTheSpotlight().attemptsTo(AbrirNavegador.enPagina());
    }

    @Cuando("^el se registra de manera exitosa$")
    public void elSeRegistraDeManeraExitosa() {
        theActorInTheSpotlight().attemptsTo(
                IngresarDatosPersonales.enPrimerPaso(),
                IngresarDirecciones.enSegundoPaso(),
                IngresarDatosDelDispositivos.enTercerPaso(),
                CrearClaveUltimoPaso.enCuartoPaso());

    }

    @Entonces("^podra visualizar un mensaje de bienvenida$")
    public void podraVisualizarUnMensajeDeBienvenida() {
        theActorInTheSpotlight().should(seeThat(ValidacionCondicional.paraElFormulario()));
    }
}
