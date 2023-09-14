package com.anpq.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anpq.spring.dao.SingerDao;
import com.anpq.spring.entity.Singer;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
@Transactional

public class SingerDaoImpl implements SingerDao {
  @Autowired
  private SessionFactory sessionFactory;

  @Transactional(readOnly = true)
  @Override
  public List<Singer> findAll() {
    return this.sessionFactory
        .getCurrentSession()
        .createQuery("from Singer s", Singer.class)
        .list();
  }

  @Transactional(readOnly = true)
  @Override
  public List<Singer> findAllWithAlbum() {
    Session session =this.sessionFactory.getCurrentSession();
    CriteriaQuery<Singer> query = session.getCriteriaBuilder().createQuery(Singer.class);
    Root<Singer> singer = query.from(Singer.class);
    singer.fetch("albums");
    query.select(singer);
    return session.createQuery(query).getResultList();
  }

  @Override
  public Singer findById(Long id) {
    return this.sessionFactory.getCurrentSession()
    .createNamedQuery(FIND_BY_ID, Singer.class)
    .setParameter("id", id)
    .uniqueResult();
  }

  @Override
  public Singer save(Singer singer) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }

  @Override
  public void delete(Singer singer) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

}
