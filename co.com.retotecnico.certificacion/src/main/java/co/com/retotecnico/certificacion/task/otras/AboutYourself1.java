package co.com.retotecnico.certificacion.task.otras;

import co.com.retotecnico.certificacion.interactions.Esperar;
import co.com.retotecnico.certificacion.interactions.EsperarElemento;
import co.com.retotecnico.certificacion.models.CreateDatosPersonales;
import co.com.retotecnico.certificacion.models.DatosPersonalesBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.com.retotecnico.certificacion.userInterface.PaginaDeRegistro.*;
import static co.com.retotecnico.certificacion.userInterface.PaginaDeRegistro.ANIO_DE_LA_LISTA;
import static co.com.retotecnico.certificacion.userInterface.otras.UserAboutYourself1.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;


public class AboutYourself1 implements Task {


    public final CreateDatosPersonales createDatosPersonales;

    public AboutYourself1 (CreateDatosPersonales createDatosPersonales) {
        this.createDatosPersonales = createDatosPersonales;
    }

        public static AboutYourself1 enPagina(DatosPersonalesBuilder createDatosPersonales){
        return instrumented(AboutYourself1.class, createDatosPersonales.build());

    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        String nombre = createDatosPersonales.getFirstName();
        String mes = createDatosPersonales.getMes();
        actor.attemptsTo(
                EsperarElemento.esClickable(BOX_FIRSTNAME),
                Click.on(BOX_FIRSTNAME),
                Enter.theValue(createDatosPersonales.getFirstName()).into(BOX_FIRSTNAME),
                Click.on(BOX_LASTNAME),
                Enter.theValue(createDatosPersonales.getLastName()).into(BOX_LASTNAME),
                Click.on(BOX_EMAIL),
                Enter.theValue(createDatosPersonales.getEmail()).into(BOX_EMAIL),
                Esperar.unTiempo(1000),
                Click.on(DESPLEGAR_LISTA_DE_MES)
        );

        actor.attemptsTo(
                Click.on(MES_DE_LA_LISTA.of(mes)),
                Click.on(DESPLEGAR_LISTA_DE_DIAS),
                Click.on(DIA_DE_LA_LISTA.of(createDatosPersonales.getDia())),
                Click.on(DESPLEGAR_LISTA_DE_ANIOS),
                Click.on(ANIO_DE_LA_LISTA.of(createDatosPersonales.getAnio())),
                Click.on(BTN_NEXT),
                Esperar.unTiempo(3000)

        );
    }
}
