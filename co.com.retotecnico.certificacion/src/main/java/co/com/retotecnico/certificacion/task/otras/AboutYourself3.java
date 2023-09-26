package co.com.retotecnico.certificacion.task.otras;

import co.com.retotecnico.certificacion.interactions.Esperar;
import co.com.retotecnico.certificacion.models.CreateDatosPersonales;
import co.com.retotecnico.certificacion.models.DatosPersonalesBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.retotecnico.certificacion.userInterface.otras.UserAboutYourDevices3.*;
import static co.com.retotecnico.certificacion.userInterface.otras.UserAboutYourPass4.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AboutYourself3 implements Task {

    public final CreateDatosPersonales createDatosPersonales;

    public AboutYourself3(CreateDatosPersonales createDatosPersonales) {
        this.createDatosPersonales = createDatosPersonales;
    }

        public static AboutYourself3 enPagina(DatosPersonalesBuilder createDatosPersonales){
        return instrumented(AboutYourself3.class, createDatosPersonales.build());

    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_STEP3),
                Esperar.unTiempo(3000),
                Click.on(BOX_PASS1),
                Enter.theValue(createDatosPersonales.getPass()).into(BOX_PASS1),
                Click.on(BOX_PASS2),
                Enter.theValue(createDatosPersonales.getPass()).into(BOX_PASS2),
                Esperar.unTiempo(3000),
                Scroll.to(TEXT_ACCEPT1),
                Click.on(TEXT_ACCEPT1),
                Esperar.unTiempo(5000),
                Click.on(TEXT_ACCEPT2),
                Esperar.unTiempo(5000),
                Click.on(BTN_ACCEPT_FINAL),
                Esperar.unTiempo(5000)
        );
    }
}
