package com.candidate.pojo;

public class AddCandidateRequest {

		private String candidateName;
		private String partyName;
		private String constituency;
		private int voterId;

		public String getCandidateName() {
			return candidateName;
		}

		public void setCandidateName(String candidateName) {
			this.candidateName = candidateName;
		}

		public String getPartyName() {
			return partyName;
		}

		public void setPartyName(String partyName) {
			this.partyName = partyName;
		}

		public String getConstituency() {
			return constituency;
		}

		public void setConstituency(String constituency) {
			this.constituency = constituency;
		}

		public int getVoterId() {
			return voterId;
		}

		public void setVoterId(int voterId) {
			this.voterId = voterId;
		}

		
	}


