package za.co.entelect.jbootcamp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.co.entelect.jbootcamp.services.ServicesConfig;

@Configuration
@Import({ServicesConfig.class})
public class RootConfig {
}