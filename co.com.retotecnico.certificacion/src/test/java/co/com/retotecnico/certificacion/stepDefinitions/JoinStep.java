package co.com.retotecnico.certificacion.stepDefinitions;

import co.com.retotecnico.certificacion.interactions.Esperar;
import co.com.retotecnico.certificacion.interactions.HomePage;
import co.com.retotecnico.certificacion.models.DatosPersonalesBuilder;
import co.com.retotecnico.certificacion.questions.otras.ValidacionRegistro;
import co.com.retotecnico.certificacion.task.otras.AboutYourself1;
import co.com.retotecnico.certificacion.task.otras.AboutYourself2;
import co.com.retotecnico.certificacion.task.otras.AboutYourself3;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.Map;

import static co.com.retotecnico.certificacion.userInterface.otras.UserAboutYourself1.BTN_JOIN_TODAY;

public class JoinStep {

    @Given("^que (.*) abre la pagina$")
    public void queKeissiantidAbreLaPagina(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                HomePage.enPagina()
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_JOIN_TODAY),
                Esperar.unTiempo(3000)
        );
    }

    @When("^el registra los datos personales y crea nuevo usuario con los siguiente datos$")
    public void elRegistraLosSiguienteDatos(List<Map< String, String>>datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AboutYourself1.enPagina(DatosPersonalesBuilder.con()
                        .firstName(datos)
                        .lastName(datos)
                        .email(datos)
                        .mes(datos)
                        .dia(datos)
                        .anio(datos)));
        OnStage.theActorInTheSpotlight().attemptsTo(
                AboutYourself2.enPagina(DatosPersonalesBuilder.con()
                        .city(datos)
                        .codPostal(datos)));
        OnStage.theActorInTheSpotlight().attemptsTo(
                AboutYourself3.enPagina(DatosPersonalesBuilder.con()
                        .pass(datos))
        );
    }

    @Then("^se vera mensaje de login Exitoso$")
    public void seVeraLoginExitoso() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidacionRegistro.exitosa()));
    }

}
