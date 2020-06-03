package testfinal.action;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ChooseDate implements Interaction {

    private LocalDate timeFrom;
    private LocalDate timeTo;

    public ChooseDate(LocalDate timefrom, LocalDate timeto ){
        this.timeFrom = timefrom;
        this.timeTo = timeto;
    }
    @Override
    @Step("{0} books a room from #timeFrom to #timeTo")
    public <T extends Actor> void performAs(T actor) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Target datefrom = Target.the("")
                .located(By.cssSelector("td[data-date=\'"+dtf.format(timeFrom)+"\']"));

        Target dateto = Target.the("")
                .located(By.cssSelector("td[data-date=\'"+dtf.format(timeTo)+"\']"));

        actor.attemptsTo(
                //WaitUntil.the(datefrom, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(datefrom),
                //WaitUntil.the(dateto, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(dateto)
        );

    }

    public static ChooseDateBuilder checkin(LocalDate timefrom){

        return new ChooseDateBuilder(timefrom);
    }
    public static class ChooseDateBuilder{
        private LocalDate timefrom;
        // private String password;

        public ChooseDateBuilder(LocalDate timefrom){

            this.timefrom = timefrom;
        }
        public Interaction checkout(LocalDate timeto){
            return instrumented(ChooseDate.class, this.timefrom, timeto);
        }

    }
}
