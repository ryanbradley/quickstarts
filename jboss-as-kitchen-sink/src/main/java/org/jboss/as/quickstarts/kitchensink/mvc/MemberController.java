package org.jboss.as.quickstarts.kitchensink.mvc;

import java.util.List;

import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.jboss.as.quickstarts.kitchensink.repo.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/members")
public class MemberController
{
    @Autowired
    private MemberDao memberDao;

    @RequestMapping(method=RequestMethod.GET)
    public @ModelAttribute("members")
    List<Member> displaySortedMembers()
    {
        return memberDao.getMembersOrderedByName();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String viewMember(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("member", memberDao.findById(id));
        return "viewMember";
    }
}
