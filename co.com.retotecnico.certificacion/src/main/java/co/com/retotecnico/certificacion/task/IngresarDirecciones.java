package co.com.retotecnico.certificacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.retotecnico.certificacion.userInterface.PaginaDeDireccion.*;
import static co.com.retotecnico.certificacion.userInterface.PaginaDeRegistro.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class IngresarDirecciones implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(INPUT_CIUDAD, isClickable()).forNoMoreThan(20).seconds(),
                Enter.theValue("Bogota").into(INPUT_CIUDAD),
                Enter.theValue("050014").into(INPUT_CODIGO_POSTAL),
                Click.on(DESPLEGAR_LISTA_DE_PAIS),
                Click.on(SELECCIONAR_PAIS_DE_LISTA.of("Colombia")),
                Click.on(BTN_NEXT_DEVICES));

    }

    public static IngresarDirecciones enSegundoPaso(){
        return Tasks.instrumented(IngresarDirecciones.class);
    }
}
