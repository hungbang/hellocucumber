package hellocucumber;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private String today;
    private String actualAnswer;

    @Given("an example scenario")
    public void anExampleScenario() {
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
    }


    @Given("Today is Sunday")
    public void today_is_sunday() {
        today = "Sunday";
    }
    @When("I ask when when it's Friday yet")
    public void i_ask_when_when_it_s_friday_yet() {
        // Write code here that turns the phrase above into concrete actions
        actualAnswer = IsItFriday.isItFriday(today);
    }
    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(expectedAnswer, actualAnswer);
    }
}

class IsItFriday {
    static String isItFriday(String today) {
        return "Nope";
    }
}