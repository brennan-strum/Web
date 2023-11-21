package com.brennanstrum.contentcalendar.config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.brennanstrum.contentcalendar.model.Content;
import com.brennanstrum.contentcalendar.model.Status;
import com.brennanstrum.contentcalendar.model.Type;
import com.brennanstrum.contentcalendar.repository.ContentRepository;

@Component
public class DataLoader implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'run'");
    // System.out.println("Hello World");
  }

  @Bean
  CommandLineRunner commandLineRunner(ContentRepository repository) {
    return args -> {
      Content content = new Content(
        null,
        "Third Item",
        "Third Item Desc",
        Status.IDEA,
        Type.ARTICLE,
        LocalDateTime.now(),
        null,
        ""
      );
      
      repository.save(content);
    };
  }
}
