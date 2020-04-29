import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/Dportenis.feature",
        glue = {"Definitions"},
        tags = {"@AddToCartError"})

public class SelectProductsRunner {
}
