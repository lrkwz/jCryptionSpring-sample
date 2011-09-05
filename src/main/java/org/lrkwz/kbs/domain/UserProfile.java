package org.lrkwz.kbs.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooJavaBean
@RooToString
@RooEntity(finders = { "findUserProfilesByEmailAddress",
		"findUserProfilesByEmailAddressAndPassword",
		"findUserProfilesBySurnameAndName" })
public class UserProfile implements Serializable /* , UserDetails */{

	private static final Logger log = LoggerFactory
			.getLogger(UserProfile.class);

	public static final String CELL_PHONE_PATTERN = "(^(\\+[1-9][0-9]*(\\([0-9]*\\)|-[0-9]*-)?)?[0]?[1-9][0-9\\- ]*$)|^$";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(nullable = false, length = 255)
	private String surname;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(nullable = false, length = 255)
	private String name;

	@NotNull
	@NotEmpty
	@Email
	@Column(nullable = false, unique = true)
	private String emailAddress;

	// @NotNull, this field is validated inside the controller form, do not
	// force validation here
	private String password;

	@NotNull
	@NotEmpty
	@Pattern(regexp = "M|m|F|f")
	private String gender = "M";

	@AssertTrue
	@Column(nullable = false)
	private boolean acceptServiceAgreement = true;

	@Column(nullable = false)
	private boolean acceptProductMarketing = false;

	@Column(nullable = false)
	private boolean acceptProfiling = false;

	@Pattern(regexp = "(^(\\+[1-9][0-9]*(\\([0-9]*\\)|-[0-9]*-)?)?[0]?[1-9][0-9\\- ]*$)|^$")
	private String cellPhone;

	@NotNull
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "S-")
	private Calendar birthDate;

	@Column(nullable = false)
	private boolean enabled = false;

	private Locale browsingLanguage;

}
