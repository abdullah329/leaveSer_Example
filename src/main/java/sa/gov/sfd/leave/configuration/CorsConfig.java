package sa.gov.sfd.leave.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CorsFilter;

public class CorsConfig {

//    @Bean
//    public void simpleCorsFilter(): FilterRegistrationBean<CorsFilter>
//
//    {
//        val source = UrlBasedCorsConfigurationSource()
//        val config = CorsConfiguration()
//        config.allowCredentials = true
//        config.allowedOrigins = listOf("http://localhost:4200")
//        config.allowedMethods = listOf("*");
//        config.allowedHeaders = listOf("*")
//        source.registerCorsConfiguration("/**", config)
//        val bean = FilterRegistrationBean(CorsFilter(source))
//        bean.order = Ordered.HIGHEST_PRECEDENCE
//        return bean
//    }
}
