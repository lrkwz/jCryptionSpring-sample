package org.gitorious.jcryptionspring.sample.domain;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionOfElements;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class UserProfile {

	private String email;

	private String name;

	private String surname;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Calendar birthday;

	private Boolean enabled;

	@Enumerated
	private Colors preferredColor;

	@CollectionOfElements
	private List<Colors> colors = new LinkedList<Colors>();
}
