package edu.du.sb1013pj.survey;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.List;


@Getter
@Setter
@ToString
public class AnsweredData {

	private List<String> responses;
	private Respondent res;

	public List<String> getResponses() {
		return responses;
	}

	public void setResponses(List<String> responses) {
		this.responses = responses;
	}

	public Respondent getRes() {
		return res;
	}

	public void setRes(Respondent res) {
		this.res = res;
	}

}
