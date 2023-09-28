package co.com.retotecnico.certificacion.task;

import co.com.retotecnico.certificacion.models.CreateDatosPersonales;
import co.com.retotecnico.certificacion.models.DatosPersonalesBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.retotecnico.certificacion.userInterface.PaginaDeDireccion.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class IngresarDirecciones implements Task {

    public final CreateDatosPersonales createDatosPersonales;

    public IngresarDirecciones (CreateDatosPersonales createDatosPersonales) {
        this.createDatosPersonales = createDatosPersonales;
    }

    public static IngresarDirecciones enSegundoPaso(DatosPersonalesBuilder createDatosPersonales){
        return instrumented(IngresarDirecciones.class, createDatosPersonales.build());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(INPUT_CIUDAD, isClickable()).forNoMoreThan(20).seconds(),
                Enter.theValue(createDatosPersonales.getCity()).into(INPUT_CIUDAD),
                Enter.theValue(createDatosPersonales.getCodPostal()).into(INPUT_CODIGO_POSTAL),
                Click.on(DESPLEGAR_LISTA_DE_PAIS),
                Click.on(SELECCIONAR_PAIS_DE_LISTA.of(createDatosPersonales.getPais())),
                Click.on(BTN_NEXT_DEVICES));

    }

}
