package org.jboss.as.quickstarts.kitchensink.repo;

import javax.persistence.EntityManager;

import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao
{
    @Autowired
    private EntityManager entityManager;

    public void register(Member member)
    {
        entityManager.persist(member);
        return;
    }

}
