package beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Wk007Bean {
	private int fileId;
	private int mainId;
	private String fileName;
	public String filePath;
	public Date uploadedDate;
	public int deleteFlag;
	public Date deleteDate;
	
	
	
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getMainId() {
		return mainId;
	}
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
	
}