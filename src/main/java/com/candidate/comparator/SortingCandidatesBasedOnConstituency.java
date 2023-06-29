package com.candidate.comparator;

import java.util.Comparator;

import com.candidate.entity.Candidate;

public class SortingCandidatesBasedOnConstituency implements Comparator<Candidate> {

	@Override
	public int compare(Candidate o1, Candidate o2) {

		return o2.getConstituency().compareTo(o1.getConstituency());
	}
}