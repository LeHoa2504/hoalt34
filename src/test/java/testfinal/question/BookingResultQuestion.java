package testfinal.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import testfinal.ui.BookingPage;

public class BookingResultQuestion implements Question<String> {
    public static Question<String> getResult() {
        return new BookingResultQuestion();
    }

    @Override
    public String answeredBy(Actor actor) {
        String results = Text.of(BookingPage.RESULT)
                .viewedBy(actor)
                .asString();
        String[] result = results.split(" ");
        return result[2];
    }

}
