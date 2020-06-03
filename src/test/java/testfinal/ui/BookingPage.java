package testfinal.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookingPage {
    public static Target DES_FIELD = Target.the("destination field").located(By.cssSelector("input.sb-destination__input"));
    public static Target OPPTION_DES = Target.the("choose option search destination").located(By.cssSelector("li[role=\"option\"][data-i =\"0\"]"));
    public static Target VISIT_FIELD = Target.the("visited customer")
            .located(By.cssSelector("div.xp__guests"));
    public static Target ADULTS = Target.the("choose number adults")
            .located(By.cssSelector("button[aria-label=\"Increase number of Adults\"]"));
    public static Target CHILDRENS = Target.the("choose number childrens")
            .located(By.cssSelector("button[aria-label=\"Increase number of Children\"]"));
    public static Target ROOM = Target.the("choose number room")
            .located(By.cssSelector("button[aria-label=\"Increase number of Rooms\"]"));

    public static Target BUTTON_SEARCH = Target.the("choose number room")
            .located(By.cssSelector("button.sb-searchbox__button"));

    public static Target RESULT = Target.the("ket qua")
            .located(By.cssSelector("div.sr_header h1"));
}
