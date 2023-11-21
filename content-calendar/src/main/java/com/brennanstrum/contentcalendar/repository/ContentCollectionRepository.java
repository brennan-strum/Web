package com.brennanstrum.contentcalendar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;
import com.brennanstrum.contentcalendar.model.Content;
import com.brennanstrum.contentcalendar.model.Status;
import com.brennanstrum.contentcalendar.model.Type;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {
  
  private final List<Content> contentList = new ArrayList<>();

  public ContentCollectionRepository() {

  }

  public List<Content> findAll() {
    return contentList;
  }

  public Optional<Content> findById(Integer id) {
    return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
  }

  public void save(Content content) {
    contentList.removeIf(c -> c.id().equals(content.id()));
    contentList.add(content);
  }

  public boolean existsById(Integer id) {
    return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
  }

  public void delete(Integer id) {
    contentList.removeIf(c -> c.id().equals(id));
  }

  @PostConstruct
  private void init() {
    Content c = new Content(
      1, 
      "entry 1", 
      "entry 1 desc", 
      Status.IDEA, 
      Type.ARTICLE, 
      LocalDateTime.now(), 
      null, 
      ""
    );

     contentList.add(c);
  }
}
