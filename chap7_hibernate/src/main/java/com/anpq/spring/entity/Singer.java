package com.anpq.spring.entity;

import java.io.Serial;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "SINGER")
@Getter
@Setter
@ToString(exclude = "albums")
@NamedNativeQueries({
  @NamedNativeQuery(name = "singer.findById", query = "select * from SINGER where id = :id", resultClass = Singer.class)
})
public class Singer extends AbstractEntity {
  @Serial
  private static final long serialVersionUID = 2L;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "BIRTH_DATE")
  private LocalDate birthDate;

  @OneToMany(mappedBy = "singer")
  private Set<Album> albums = new HashSet<Album>();

  // @ManyToMany
  // @JoinTable(name = "SINGER_INSTRUMENT", joinColumns = @JoinColumn(name = "SINGER_ID"), inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
  // private Set<Instrument> instruments;
}
