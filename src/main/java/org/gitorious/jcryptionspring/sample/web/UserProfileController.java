package org.gitorious.jcryptionspring.sample.web;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.gitorious.jcryptionspring.sample.domain.Colors;
import org.gitorious.jcryptionspring.sample.domain.UserProfile;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RooWebScaffold(path = "userprofiles", formBackingObject = UserProfile.class)
@RequestMapping("/userprofiles")
@Controller
public class UserProfileController {
	private static final Logger logger = LoggerFactory
			.getLogger(UserProfileController.class);

	@ModelAttribute("colorses")
	public Collection<Colors> populateColorses() {
		Colors[] colors = Colors.class.getEnumConstants();
		return Arrays.asList(colors);
	}

	/*
	Converter<Colors, String> getColorsConverter() {
		logger.debug("Called getColorsConverter");
		Converter<Colors, String> converter = new Converter<Colors, String>() {
			public String convert(Colors instance) {
				logger.debug("Converter called with {}", instance);
				return "" + instance.ordinal();
			}
		};
		return converter;
	}
	*/

	/*
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid UserProfile userProfile,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest ) {
		
		List<ObjectError> err = bindingResult.getAllErrors();
		for (ObjectError objectError : err) {			
			logger.debug("Errors {} ", objectError.toString());
		}
		
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("userProfile", userProfile);
			addDateTimeFormatPatterns(uiModel);
			return "userprofiles/create";
		}
		uiModel.asMap().clear();

		logger.debug("User profile is {}", userProfile );
		userProfile.persist();
		return "redirect:/userprofiles/"
				+ encodeUrlPathSegment(userProfile.getId().toString(),
						httpServletRequest);
	}
	

	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
	
    void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("userProfile_birthday_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    */
}
