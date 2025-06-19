package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
public class TestRunner {
}