package co.com.retotecnico.certificacion.questions.otras;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.retotecnico.certificacion.userInterface.otras.ValidacionRegistroUser.VALID_REGIST;

public class ValidacionRegistro implements Question <Boolean>{
    @Override
    public Boolean answeredBy(Actor actor) {
        if(VALID_REGIST.resolveFor(actor).isVisible())
            return true;
            return false;
           }

           public static ValidacionRegistro exitosa(){
        return new ValidacionRegistro();
    }
}
