package testfinal.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import testfinal.ui.BookingPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchDestination implements Task {
    private String destination;

    public SearchDestination(String des){
        this.destination = des;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(destination).into(BookingPage.DES_FIELD),
                Click.on(BookingPage.OPPTION_DES)
        );
    }

    public static Performable withKeyword(String des) {
        return instrumented(SearchDestination.class, des);
    }


}
