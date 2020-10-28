package com.mugowanjogu.bb;

import com.openbankproject.api.spec.ATMApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenBankConfiguration {

    @Bean
    public ATMApi getATMApi() {
        return new ATMApi();
    }
}
