package za.co.entelect.jbootcamp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import za.co.entelect.jbootcamp.services.ServicesConfig;

@Configuration
@ComponentScan(
        basePackages = "za.co.entelect.jbootcamp.cli",
        includeFilters = @ComponentScan.Filter(Component.class)
)
@Import({
        ServicesConfig.class
})
public class CLIConfig {
}
