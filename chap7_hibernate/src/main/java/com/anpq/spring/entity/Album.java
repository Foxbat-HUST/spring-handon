package com.anpq.spring.entity;

import java.io.Serial;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ALBUM")
@Getter
@Setter
@ToString
public class Album extends AbstractEntity {
  @Serial
  private static final long serialVersionUID = 3L;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "RELEASE_DATE")
  private LocalDate releaseDate;

  @ManyToOne
  @JoinColumn(name = "SINGER_ID")
  private Singer singer ;
}
