package com.csye6225.spring2020.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="student")
public class Student {
	private String id;
	private String studentId;
	private String firstName;
	private String lastName;
	private String programName;
	private String imageUrl;
	private String email;
	private List<String> courseEnrolled = new ArrayList<>() ;
	private String joiningDate;

	public Student() {
		
	}
	
	public Student(String studentId, String firstName, String lastName, String programName, String imageUrl,
			String email, String joiningDate) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.programName = programName;
		this.imageUrl = imageUrl;
		this.email = email;
		this.joiningDate = joiningDate;
	}


	@DynamoDBHashKey(attributeName = "id")
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBIndexHashKey(globalSecondaryIndexName="studentId-index",attributeName="studentId")
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@DynamoDBAttribute(attributeName="firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@DynamoDBAttribute(attributeName="lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DynamoDBAttribute(attributeName="programName")
	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@DynamoDBAttribute(attributeName="courseEnrolled")
	public List<String> getCourseEnrolled() {
		return courseEnrolled;
	}

	public void setCourseEnrolled(List<String> courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}

	@DynamoDBAttribute(attributeName="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@DynamoDBAttribute(attributeName="joiningDate")
	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	@DynamoDBIgnore
	@Override
	public String toString() {
		return "studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", programName=" + programName + ", imageUrl=" + imageUrl + ", email=" + email;
	}
	
//	public String getAllCourses() {
//		String allCourses = "";
//		for (String course : courseEnrolled) {
//			allCourses += course;
//		}
//		return allCourses;
//	}

}
