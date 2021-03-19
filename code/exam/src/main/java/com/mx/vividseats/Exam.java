package com.mx.vividseats;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mx.vividseats.dto.Member;

public class Exam {
	private List<Member> team = new ArrayList<>();
	
	public Exam(List<Member> team) {
		if (team != null) {
			this.team = team;
		}
	}
	/**
	 * Filter new members of the team than does not known anyone but everybody knows them
	 * 
	 * @return List of new members
	 */
	public List<Member> getResult() {
		return team.stream()
			.filter(element -> getNewMembers(element))
			.filter(element -> validateEveryOneknows(element.getId(), team))
			.collect(Collectors.toList());		
	}
	
	/**
	 * Validate that atribute knowns is not null and has no elements
	 * 
	 * @param element	Object to be evaluated
	 * @return 'true' if has cero knowns
	 */
	private boolean getNewMembers(Member element) {
		return element.getKnowns() == null || element.getKnowns().size() == 0;
	}
	/**
	 * Valdate if each member knows the current member
	 * 
	 * @param idMember	Unique identifier of member to be evaluated
	 * @param team		List of members that are part of the team
	 * @return	'true' if every member knows
	 */
	private boolean validateEveryOneknows(String idMember, List<Member> team) {
		int counter = 0;
		
		for(int position = 0; position < team.size(); position ++) {
			Member element = team.get(position);
			if (!element.getId().equals(idMember) && 
					element.getKnowns().contains(idMember)) {
				counter ++;
			}
		}
		return counter == team.size() - 1;
	}

}
