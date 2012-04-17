package org.jboss.as.quickstarts.kitchensink.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

    @SuppressWarnings("unchecked")
    public List<Member> getMembers()
    {
        Query query = entityManager.createQuery("select m from Member m");
        return query.getResultList();
    }

    public List<Member> getMembersOrderedByName()
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> criteria = builder.createQuery(Member.class);
        Root<Member> member = criteria.from(Member.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(member).orderBy(builder.asc(member.get("name")));
        return entityManager.createQuery(criteria).getResultList();
    }

    public void register(Member member)
    {
        entityManager.persist(member);
        return;
    }

    public Member getMember(Long id)
    {
        return entityManager.find(Member.class, id);
    }
}
