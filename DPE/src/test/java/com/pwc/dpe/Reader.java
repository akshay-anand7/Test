package com.pwc.dpe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reader
{
	private String Platform;
	private String Browser;
	private String Language;
	private long longWaitTime;
	private long mediumWaitTime;
	private long shortWaitTime;
	private long veryShortWaitTime;
	private String superAdminPassword;
	private String superAdminUserName;

	private String authorUsername;
	private String URL;
	private String filename = "propertyValues.properties";
	private String template;
	private String email;
	private String group_name;
	private String description;
	private String authorPass;
	private String UserEmail;

	private String accOwner_Password;
	private String accOwner_userName;
	private String user1_Password;
	private String user1_UserName;
	private String user2_Password;
	private String user2_UserName;
	private String user3_Password;
	private String user3_UserName;
	private String user4_Password;
	private String user4_UserName;
	private String user5_Password;
	private String user5_UserName;

	private String adminCompanyName;
	private String accountOwner_CompanyName;
	private String accountOwner_lastName;

	private String user1_CompanyName;
	private String user2_CompanyName;
	private String user3_CompanyName;
	private String user4_CompanyName;
	private String user5_CompanyName;

	private String user1_lastName;
	private String user2_lastName;
	private String user3_lastName;
	private String user4_lastName;
	private String user5_lastName;

	private String csuUserName;
	private String csuPassword;
	private String csuFirstName;
	private String csuLastName;

	public String getLanguage()
	{
		return Language;
	}

	public void setLanguage(String language)
	{
		Language = language;
	}

	public String getPlatform()
	{
		return Platform;
	}

	public void setPlatform(String platform)
	{
		Platform = platform;
	}

	public String getBrowser()
	{
		return Browser;
	}

	public void setBrowser(String browser)
	{
		Browser = browser;
	}

	public String getGeneralUserCompanyName(String userName)
	{
		if (userName.equals("user1"))
			return getUser1_CompanyName();
		else if (userName.equals("user2"))
			return getUser2_CompanyName();
		else if (userName.equals("user3"))
			return getUser3_CompanyName();
		else if (userName.equals("user4"))
			return getUser4_CompanyName();
		else if (userName.equals("user5"))
			return getUser5_CompanyName();
		else
			return null;
	}

	public String getGeneralUserLastName(String userName)
	{
		if (userName.equals("user1"))
			return getUser1_lastName();
		else if (userName.equals("user2"))
			return getUser2_lastName();
		else if (userName.equals("user3"))
			return getUser3_lastName();
		else if (userName.equals("user4"))
			return getUser4_lastName();
		else if (userName.equals("user5"))
			return getUser5_lastName();
		else
			return null;
	}

	public String getUser1_lastName()
	{
		return user1_lastName;
	}

	public void setUser1_lastName(String user1_lastName)
	{
		this.user1_lastName = user1_lastName;
	}

	public String getUser2_lastName()
	{
		return user2_lastName;
	}

	public void setUser2_lastName(String user2_lastName)
	{
		this.user2_lastName = user2_lastName;
	}

	public String getUser3_lastName()
	{
		return user3_lastName;
	}

	public void setUser3_lastName(String user3_lastName)
	{
		this.user3_lastName = user3_lastName;
	}

	public String getUser4_lastName()
	{
		return user4_lastName;
	}

	public void setUser4_lastName(String user4_lastName)
	{
		this.user4_lastName = user4_lastName;
	}

	public String getUser5_lastName()
	{
		return user5_lastName;
	}

	public void setUser5_lastName(String user5_lastName)
	{
		this.user5_lastName = user5_lastName;
	}

	public String getAccountOwner_lastName()
	{
		return accountOwner_lastName;
	}

	public void setAccountOwner_lastName(String accountOwner_lastName)
	{
		this.accountOwner_lastName = accountOwner_lastName;
	}

	public String getCsuUserName()
	{
		return csuUserName;
	}

	public void setCsuUserName(String csuUserName)
	{
		this.csuUserName = csuUserName;
	}

	public String getCsuPassword()
	{
		return csuPassword;
	}

	public void setCsuPassword(String csuPassword)
	{
		this.csuPassword = csuPassword;
	}

	public String getCsuFirstName()
	{
		return csuFirstName;
	}

	public void setCsuFirstName(String csuFirstName)
	{
		this.csuFirstName = csuFirstName;
	}

	public String getCsuLastName()
	{
		return csuLastName;
	}

	public void setCsuLastName(String csuLastName)
	{
		this.csuLastName = csuLastName;
	}

	public String getGeneralUserName(String userName)
	{
		if (userName.equals("user1"))
			return getUser1_UserName();
		else if (userName.equals("user2"))
			return getUser2_UserName();
		else if (userName.equals("user3"))
			return getUser3_UserName();
		else if (userName.equals("user4"))
			return getUser4_UserName();
		else if (userName.equals("user5"))
			return getUser5_UserName();
		else
			return null;
	}

	public String getGeneralUserPassword(String userName)
	{
		if (userName.equals("user1"))
			return getUser1_Password();
		else if (userName.equals("user2"))
			return getUser2_Password();
		else if (userName.equals("user3"))
			return getUser3_Password();
		else if (userName.equals("user4"))
			return getUser4_Password();
		else if (userName.equals("user5"))
			return getUser5_Password();
		else
			return null;
	}

	public String getUser2_CompanyName()
	{
		return user2_CompanyName;
	}

	public void setUser2_CompanyName(String user2_CompanyName)
	{
		this.user2_CompanyName = user2_CompanyName;
	}

	public String getUser3_CompanyName()
	{
		return user3_CompanyName;
	}

	public void setUser3_CompanyName(String user3_CompanyName)
	{
		this.user3_CompanyName = user3_CompanyName;
	}

	public String getUser4_CompanyName()
	{
		return user4_CompanyName;
	}

	public void setUser4_CompanyName(String user4_CompanyName)
	{
		this.user4_CompanyName = user4_CompanyName;
	}

	public String getUser5_CompanyName()
	{
		return user5_CompanyName;
	}

	public void setUser5_CompanyName(String user5_CompanyName)
	{
		this.user5_CompanyName = user5_CompanyName;
	}

	public String getAccountOwner_CompanyName()
	{
		return accountOwner_CompanyName;
	}

	public void setAccountOwner_CompanyName(String accountOwner_CompanyName)
	{
		this.accountOwner_CompanyName = accountOwner_CompanyName;
	}

	public String getUser1_CompanyName()
	{
		return user1_CompanyName;
	}

	public void setUser1_CompanyName(String user1_CompanyName)
	{
		this.user1_CompanyName = user1_CompanyName;
	}

	public String getAdminCompanyName()
	{
		return adminCompanyName;
	}

	public void setAdminCompanyName(String adminCompanyName)
	{
		this.adminCompanyName = adminCompanyName;
	}

	Reader()
	{
		logincredentials();
		timeouts();
	}

	public String getUser2_Password()
	{
		return user2_Password;
	}

	public void setUser2_Password(String user2_Password)
	{
		this.user2_Password = user2_Password;
	}

	public String getUser2_UserName()
	{
		return user2_UserName;
	}

	public void setUser2_UserName(String user2_UserName)
	{
		this.user2_UserName = user2_UserName;
	}

	public String getUser3_Password()
	{
		return user3_Password;
	}

	public void setUser3_Password(String user3_Password)
	{
		this.user3_Password = user3_Password;
	}

	public String getUser3_UserName()
	{
		return user3_UserName;
	}

	public void setUser3_UserName(String user3_UserName)
	{
		this.user3_UserName = user3_UserName;
	}

	public String getUser4_Password()
	{
		return user4_Password;
	}

	public void setUser4_Password(String user4_Password)
	{
		this.user4_Password = user4_Password;
	}

	public String getUser4_UserName()
	{
		return user4_UserName;
	}

	public void setUser4_UserName(String user4_UserName)
	{
		this.user4_UserName = user4_UserName;
	}

	public String getUser5_Password()
	{
		return user5_Password;
	}

	public void setUser5_Password(String user5_Password)
	{
		this.user5_Password = user5_Password;
	}

	public String getUser5_UserName()
	{
		return user5_UserName;
	}

	public void setUser5_UserName(String user5_UserName)
	{
		this.user5_UserName = user5_UserName;
	}

	public long getlongWaitTime()
	{
		return longWaitTime;
	}

	public long getmediumWaitTime()
	{
		return mediumWaitTime;
	}

	public long getshortWaitTime()
	{
		return shortWaitTime;
	}

	public long getveryShortWaitTime()
	{
		return veryShortWaitTime;
	}

	public void setlongWaitTime(String longWaitTime)
	{
		this.longWaitTime = Long.parseLong(longWaitTime);
	}

	public void setmediumWaitTime(String mediumWaitTime)
	{

		this.mediumWaitTime = Long.parseLong(mediumWaitTime);
	}

	public void setshortWaitTime(String shortWaitTime)
	{

		this.shortWaitTime = Long.parseLong(shortWaitTime);
	}

	public void setveryShortWaitTime(String veryShortWaitTime)
	{

		this.veryShortWaitTime = Long.parseLong(veryShortWaitTime);
	}

	public String getUserEmail()
	{
		return UserEmail;
	}

	public void setUserEmail(String userEmail)
	{
		UserEmail = userEmail;
	}

	public String getAuthorPass()
	{
		return authorPass;
	}

	public void setAuthorPass(String authorPass)
	{
		this.authorPass = authorPass;
	}

	public String getAuthorUsername()
	{
		return authorUsername;
	}

	public void setAuthorUsername(String authorUsername)
	{
		this.authorUsername = authorUsername;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getGroup_name()
	{
		return group_name;
	}

	public void setGroup_name(String group_name)
	{
		this.group_name = group_name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTemplate()
	{
		return template;
	}

	public void setTemplate(String template)
	{
		this.template = template;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getSuperAdminUserName()
	{
		return superAdminUserName;
	}

	public void setSuperAdminUserName(String user_name)
	{
		this.superAdminUserName = user_name;
	}

	public String getSuperAdminPassword()
	{
		return superAdminPassword;
	}

	public void setSuperAdminPassword(String pass_word)
	{
		this.superAdminPassword = pass_word;
	}

	public String getURL()
	{
		return URL;
	}

	public void setURL(String uRL)
	{
		URL = uRL;
	}

	public String getAccOwner_Password()
	{
		return accOwner_Password;
	}

	public String getAccOwner_userName()
	{
		return accOwner_userName;
	}

	public String getUser1_Password()
	{
		return user1_Password;
	}

	public String getUser1_UserName()
	{
		return user1_UserName;
	}

	public void setAccountOwnerPassword(String property)
	{
		this.accOwner_Password = property;

	}

	public void setAccountOwnerUserName(String property)
	{
		this.accOwner_userName = property;

	}

	public void setUser1_Password(String property)
	{
		this.user1_Password = property;

	}

	public void setUser1_UserName(String property)
	{
		this.user1_UserName = property;

	}

	public void timeouts()
	{

		Properties properties = new Properties();
		try
		{
			properties.load(new FileInputStream(filename));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		this.setlongWaitTime(properties.getProperty("longWaitTime"));
		this.setmediumWaitTime(properties.getProperty("mediumWaitTime"));
		this.setshortWaitTime(properties.getProperty("shortWaitTime"));
		this.setveryShortWaitTime(properties.getProperty("veryShortWaitTime"));
	}

	public void logincredentials()
	{

		Properties properties = new Properties();
		try
		{
			properties.load(new FileInputStream(filename));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		this.setLanguage(properties.getProperty("Language"));
		this.setPlatform(properties.getProperty("Platform"));
		this.setBrowser(properties.getProperty("Browser"));
		this.setURL(properties.getProperty("URL"));
		this.setSuperAdminUserName(properties.getProperty("superAdmin_user_name"));
		this.setSuperAdminPassword(properties.getProperty("superAdmin_pass_word"));
		this.setTemplate(properties.getProperty("template"));
		this.setEmail(properties.getProperty("email"));
		this.setGroup_name(properties.getProperty("group_name"));
		this.setDescription(properties.getProperty("description"));
		this.setAuthorUsername(properties.getProperty("authorUsername"));
		this.setAuthorPass(properties.getProperty("authorPass"));
		this.setAdminCompanyName(properties.getProperty("adminCompanyName"));
		this.setUserEmail(properties.getProperty("UserEmail"));
		this.setAccountOwnerUserName(properties.getProperty("accountOwner_userName"));
		this.setAccountOwnerPassword(properties.getProperty("accountOwner_password"));
		this.setAccountOwner_CompanyName(properties.getProperty("accountOwner_CompanyName"));

		this.setUser1_UserName(properties.getProperty("user1_userName"));
		this.setUser1_Password(properties.getProperty("user1_password"));
		this.setUser2_UserName(properties.getProperty("user2_userName"));
		this.setUser2_Password(properties.getProperty("user2_password"));
		this.setUser3_UserName(properties.getProperty("user3_userName"));
		this.setUser3_Password(properties.getProperty("user3_password"));
		this.setUser4_UserName(properties.getProperty("user4_userName"));
		this.setUser4_Password(properties.getProperty("user4_password"));
		this.setUser5_UserName(properties.getProperty("user5_userName"));
		this.setUser5_Password(properties.getProperty("user5_password"));

		this.setUser1_CompanyName(properties.getProperty("user1_CompanyName"));
		this.setUser2_CompanyName(properties.getProperty("user2_CompanyName"));
		this.setUser3_CompanyName(properties.getProperty("user3_CompanyName"));
		this.setUser4_CompanyName(properties.getProperty("user4_CompanyName"));
		this.setUser5_CompanyName(properties.getProperty("user5_CompanyName"));

		this.setUser1_lastName(properties.getProperty("user1_lastName"));
		this.setUser2_lastName(properties.getProperty("user2_lastName"));
		this.setUser3_lastName(properties.getProperty("user3_lastName"));
		this.setUser4_lastName(properties.getProperty("user4_lastName"));
		this.setUser5_lastName(properties.getProperty("user5_lastName"));

		this.setCsuUserName(properties.getProperty("csuUserName"));
		this.setCsuPassword(properties.getProperty("csuPassword"));
		this.setCsuFirstName(properties.getProperty("csuFirstName"));
		this.setCsuLastName(properties.getProperty("csuLastName"));
		this.setAccountOwner_lastName(properties.getProperty("accountOwner_lastName"));
	}

}