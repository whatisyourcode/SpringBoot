package edu.du.sb1011.dto;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Data
@Getter
public class BoardDto {

	private int boardIdx;
	
	private String title;
	
	private String contents;
	
	private int hitCnt;
	
	private String creatorId;
	
	private String createdDatetime;
	
	private String updaterId;
	
	private String updatedDatetime;
}
