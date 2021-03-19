package com.mx.vividseats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mx.vividseats.dto.Member;


public class ExamTest {

	@Test
	public void testEmptyTeam() {
		Exam newExam = new Exam(new ArrayList<>());
		assertEquals(0, newExam.getResult().size());
	}
	
	@Test
	public void testNullTeam() {
		Exam newExam = new Exam(null);
		assertNotNull(newExam.getResult());
	}
	
	@Test
	public void testOneNewMember() {
		List<Member> team = new ArrayList<>();
		List<String> knowns = new ArrayList<>();
		knowns.add("ab1");
		team.add(new Member("ab1", null));
		team.add(new Member("ab2", knowns));
		team.add(new Member("ab3", knowns));
		team.add(new Member("ab4", knowns));
		team.add(new Member("ab5", knowns));
		
		Exam newExam = new Exam(team);
		
		assertEquals(1, newExam.getResult().size());
	}

}
