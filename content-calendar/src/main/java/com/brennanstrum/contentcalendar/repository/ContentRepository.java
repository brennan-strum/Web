package com.brennanstrum.contentcalendar.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.brennanstrum.contentcalendar.model.Content;
import com.brennanstrum.contentcalendar.model.Status;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

  // QUERY DERIVATION
  List<Content> findAllByTitleContains(String keyword);

  // CUSTOM QUERY
  @Query("""
      SELECT * FROM Content
      WHERE status = :status
  """)
  List<Content> listByStatus(@Param("status") Status status);
}
