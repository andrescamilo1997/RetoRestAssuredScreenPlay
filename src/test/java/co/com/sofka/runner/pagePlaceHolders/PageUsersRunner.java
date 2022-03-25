package co.com.sofka.runner.pagePlaceHolders;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/pageReqRes/users_reqres_page.feature"},
        glue = {"co.com.sofka.stepDefinition.pageReqRes"}
)

public class PageUsersRunner {
}
