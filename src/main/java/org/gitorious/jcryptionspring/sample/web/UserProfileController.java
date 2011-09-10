package org.gitorious.jcryptionspring.sample.web;

import org.gitorious.jcryptionspring.sample.domain.UserProfile;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "userprofiles", formBackingObject = UserProfile.class)
@RequestMapping("/userprofiles")
@Controller
public class UserProfileController {
}
