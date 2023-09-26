package co.com.retotecnico.certificacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Random;

import static co.com.retotecnico.certificacion.userInterface.PaginaDeRegistro.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class IngresarDatosPersonales implements Task {


    Random numAleatorio = new Random();
    int numero = numAleatorio.nextInt(75-2+1) + 3;
    private String correo = "correoandres" + numero + "@gmail.com";
    @Override
    public <T extends Actor> void performAs(T actor) {
        Random random = new Random();
        random.nextInt();

        actor.attemptsTo(
                WaitUntil.the(JOIN_TODAY, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(JOIN_TODAY),
                WaitUntil.the(INPUT_NOMBRE, isClickable()).forNoMoreThan(20).seconds(),
                Enter.theValue("Andres").into(INPUT_NOMBRE),
                Enter.theValue("Apellido de Andres").into(INPUT_APELLIDO),
                Enter.theValue(correo).into(INPUT_CORREO),
                Click.on(DESPLEGAR_LISTA_DE_MES),
                Click.on(MES_DE_LA_LISTA.of("May")),
                Click.on(DESPLEGAR_LISTA_DE_DIAS),
                Click.on(DIA_DE_LA_LISTA.of("10")),
                Click.on(DESPLEGAR_LISTA_DE_ANIOS),
                Click.on(ANIO_DE_LA_LISTA.of("1990")),
                Click.on(BTN_NEXT_LOCATION_SIGUIENTE));
    }

    public static IngresarDatosPersonales enPrimerPaso(){
        return Tasks.instrumented(IngresarDatosPersonales.class);
    }
}
