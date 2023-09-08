package fr.diginamic.sandbox.core;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PageSupport extends PageRequest {

  private static final long serialVersionUID = 1L;

  private static final int DEFAULT_PAGE_NUMBER = 0;
  private static final int DEFAULT_PAGE_SIZE = 20;

  public PageSupport() {
    super(DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE, Sort.unsorted());
  }

  public PageSupport(final int pageNumber, final int pageSize) {
    super(pageNumber, pageSize, Sort.unsorted());
  }

  public PageSupport(final int pageNumber, final int pageSize, final Sort sort) {
    super(pageNumber, pageSize, sort);
  }
}
