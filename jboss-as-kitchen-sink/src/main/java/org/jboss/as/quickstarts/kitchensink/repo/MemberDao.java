package org.jboss.as.quickstarts.kitchensink.repo;

import java.util.List;

import org.jboss.as.quickstarts.kitchensink.model.Member;

public interface MemberDao
{
    public Member findById(Long id);

    public Member findByEmail(String email);

    public List<Member> getMembersOrderedByName();

    public void register(Member member);
}
