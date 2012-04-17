package org.jboss.as.quickstarts.kitchensink.repo;

import java.util.List;

import org.jboss.as.quickstarts.kitchensink.model.Member;

public interface MemberDao
{
    public List<Member> getMembers();

    public List<Member> getMembersOrderedByName();

    public void register(Member member);

    public Member getMember(Long id);
}
