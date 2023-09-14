package com.anpq.spring.entity;

import java.io.Serial;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "INSTRUMENT")
public class Instrument extends AbstractEntity {
  @Serial
  private static final long serialVersionUID = 4L;

  @Column(name = "INSTRUMENT_ID")
  private String instrumentId;

  // @ManyToMany
  // @JoinTable(name = "SINGER_INSTRUMENT", joinColumns = @JoinColumn(name = "INSTRUMENT_ID"), inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
  // private Set<Singer> singers;
}
