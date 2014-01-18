package logic;

import java.io.File;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.IdPairBean;
import beans.Mst002Bean;
import beans.Mst003Bean;
import beans.Wk001Bean;
import beans.Wk005Bean;

public class Util {
	
	/**
	 * @param String yyyy-MM-dd 或者 yyyy/MM/dd
	 * @return Date 
	 * @throws Exception
	 */
	public Date convertDate(String dateString) throws Exception{
		// nullだったら、システム時間に設定する
		if(dateString==null || dateString.equals("")){
			return null;
		}
		// デフォルト yyyy/MM/dd
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		//  yyyy-MM-ddだったら、yyyy-MM-ddに変える
		Pattern p=Pattern.compile("[0-9]{4}-([1-9]|[0-9]{2})-([1-9]|[0-9]{2})");
		Matcher m=p.matcher(dateString); 
		if(m.find()){
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		
		
		Date date = new java.sql.Date(sdf.parse(dateString).getTime());
		return date;
	}
	
	public int convertNullInt(String intStr) {
		if(intStr==null || intStr.equals("")){
			return 0;
		}
		return new Integer(intStr).intValue();
	}
	public List<IdPairBean> convertUserInputMainId(String userInput){
		//半角カンマ以外の符号を削除。例えば：スペース，全角スペース，全角カンマ等。
		userInput = userInput.replace(" ", "");	// 削除半角スペース
		userInput = userInput.replace("　", "");	// 削除全角スペース
		userInput = userInput.replace("、", "");	// 削除全角カンマ
		// 分割
		String[] inputMainIdList = userInput.split(",");
		List<IdPairBean> dispMainIdList = new ArrayList<IdPairBean>();
		for (int i = 0; i < inputMainIdList.length; i++) {
			String strUserInputMainId = inputMainIdList[i].trim(); // 入力した一つのmainId
			IdPairBean idPairBean = new IdPairBean();
			int mainId = convertNullInt(strUserInputMainId);
			idPairBean.setMainId(mainId);
			idPairBean.setDispMainId(convertDispId(mainId));
			dispMainIdList.add(idPairBean);
		}
		return dispMainIdList;
	}
	public String convertDispShortCut(String inputStr){
		if(inputStr.length()>5){
			return inputStr.substring(0,5)+"‥‥‥";
		}
		return inputStr;
	}
	public String convertDispId(int id) {
		if(id==0){
			return "";
		}
		String pattern="00000";
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(id);
	}
	public String convertBr(String intStr) {
		if (intStr==null){
			return "";
		}
			return intStr.replace("\r\n", "<br/>").replace("\\r\\n", "<br/>").replace("\n", "<br/>");
		
	}
	public String convertDispPlace(int place) {
		switch (place) {
		case 1:
			return "国内";
		case 2:
			return "海外";
		default:
			return "";
		}
	}
	
	// =================================
	// 年度会計日計算
	// =================================
	// 会計年度開始日
	public Date getYearBegin() {
		Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        //去年
        if(month<=2){ // 3月以前 
        	year--;
        }
        cal.set(year, 3, 1, 0, 0, 0);
        
		return new Date(cal.getTime().getTime());
	}
	public Date getYearEnd() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		//今年
		if(month>=3){ // 4月以降 
			year++;
		}
		cal.set(year, 2, 31, 23, 59, 59);
		return new Date(cal.getTime().getTime());
	}
	
	public String validDetail(HttpServletRequest request){
		Util util= new Util();
		
		String name=request.getParameter("name");
		if(name==null|| name.equals("")){
			return "名前を入力してください！";
		}
		/*String hurigana=request.getParameter("hurigana");
		if(hurigana==null|| hurigana.equals("")){
			return "ふりがなを入力してください！";
		}*/
		int age=new Integer(request.getParameter("age")).intValue();
		if(age<=0){
			return "年齢を入力してください！";
		}
		Date birthDay = null;
	    try {
	    	birthDay=convertDate(request.getParameter("birthDay"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(birthDay==null|| birthDay.equals("")){
			return "生年月日を正しく入力してください！";
		}
		
		return "";
	}
	
	// ファイルアップロードとダウンロード
	// ファイルアップロードとダウンロードに関する定義
	public String uploadPath = "C://fileUpload"; // アップロードする場所
	public String tempPath = "C://fileUploadtmp"; // 
	public String fileSeprator = "//";
	public int sizeMax = 10;// 最大サイズ100M
	
	// mainIdによって、ファイルを探す，ファイル名を返す
	public List<String> getDirFileNamesByMainId(int mainId){
		String dirPath = uploadPath + fileSeprator + mainId;
		return getDirFileNames(dirPath);
	}
	// ファイルを探す，ファイル名を返す
	public List<String> getDirFileNames(String dirPath){
		List<String> fileNameList = new ArrayList<String>();
		File dir = new File(dirPath);
		if(dir.exists() && dir.isDirectory()){
			File files[] = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				fileNameList.add(files[i].getName());
			}
		}
		return fileNameList;
	}
	
	// リセットファイル一覧テーブル
	public StringBuffer reCreateFileList(String dirPath){
		StringBuffer sb = new StringBuffer();
		List<String> fileNameList = getDirFileNames(dirPath);
		sb.append("<table border='1'>");
		sb.append("<tr>");
		sb.append("<th>ファイル一覧</th>");
		sb.append("<th>ダウンロード</th>");
		sb.append("<th>削除</th>");
		sb.append("</tr>");
		for (Iterator it = fileNameList.iterator(); it.hasNext();) {
			String fileName = (String) it.next();
			sb.append("<tr>");
			sb.append("<td>" + fileName + "</td>");
			sb.append("<td><a href='#' onclick=\\\"submit_file_download('"
					+ fileName + "');\\\">ダウンロード</a></td>");
			sb.append("<td><a href='#' onclick=\\\"submit_file_delete('"
					+ fileName + "');\\\">削除</a></td>");
			sb.append("</tr>");
		}
		return sb;
	}
	public String getParameterEnctypeMultipart(String parameter, HttpServletRequest request) throws Exception{
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		return getParameterEnctypeMultipart(parameter, request, upload);
	}
	public String getParameterEnctypeMultipart(String parameter, HttpServletRequest request, ServletFileUpload upload) throws Exception{
		List items = upload.parseRequest(request);
		Iterator it = items.iterator();
		
		while (it.hasNext()) {
			FileItem item = (FileItem) it.next();
			if(item.isFormField() && item.getFieldName().equals(parameter)){
				return item.getString("UTF-8");
			}
		}
		return "";
	}
	
	// Detail画面から送ってきた値（新规，更新，セレクト），wk001Beanの中に設定する
	public void setWk001BeanFromRequest(HttpServletRequest request, Wk001Bean wk001Bean) throws Exception{
		wk001Bean.setMainId(convertNullInt(request.getParameter("mainId")));
		wk001Bean.setReceptionDay(convertDate(request.getParameter("receptionDay")));
		wk001Bean.setLevel1Id(convertNullInt(request.getParameter("level1Id")));
		wk001Bean.setLevel2Id(convertNullInt(request.getParameter("level2Id")));
		wk001Bean.setLevel3Id(convertNullInt(request.getParameter("level3Id")));
		wk001Bean.setPlace(convertNullInt(request.getParameter("place")));
		wk001Bean.setName(request.getParameter("name"));
		wk001Bean.setHurigana(request.getParameter("hurigana"));
		wk001Bean.setAge(convertNullInt(request.getParameter("age")));
		wk001Bean.setBirthDay(convertDate(request.getParameter("birthDay")));
		wk001Bean.setSex(convertNullInt(request.getParameter("sex")));
		wk001Bean.setMarriage(convertNullInt(request.getParameter("marriage")));
		wk001Bean.setForeigner(convertNullInt(request.getParameter("foreigner")));
		wk001Bean.setPostcode(request.getParameter("postcode"));
		wk001Bean.setAddress(request.getParameter("address"));
		wk001Bean.setFamily(request.getParameter("family"));
		wk001Bean.setHomePhone(request.getParameter("homePhone"));
		wk001Bean.setMobilePhone(request.getParameter("mobilePhone"));
		wk001Bean.setContactMethod(request.getParameter("contactMethod"));
		wk001Bean.setEmail(request.getParameter("email"));
		wk001Bean.setLastDegree(request.getParameter("lastDegree"));
		wk001Bean.setSpecialty(request.getParameter("specialty"));
		wk001Bean.setDepartment(convertNullInt(request.getParameter("department")));
		wk001Bean.setGraduationDay(convertDate(request.getParameter("graduationDay")));
		wk001Bean.setSchoolOther(request.getParameter("schoolOther"));
		wk001Bean.setEnglishLevel(convertNullInt(request.getParameter("englishLevel")));
		wk001Bean.setSelfAssessment(request.getParameter("selfAssessment"));
		wk001Bean.setToeic(request.getParameter("toeic"));
		wk001Bean.setToefl(request.getParameter("toefl"));
		wk001Bean.setEtest(request.getParameter("etest"));
		wk001Bean.setRequirements(request.getParameter("requirements"));
		wk001Bean.setAnnualIncomeNow(request.getParameter("annualIncomeNow"));
		wk001Bean.setAnnualIncomeHope(request.getParameter("annualIncomeHope"));
		wk001Bean.setWorkLocation(request.getParameter("workLocation"));
		wk001Bean.setBachelor(convertNullInt(request.getParameter("bachelor")));
		wk001Bean.setInaugurationDay(convertDate(request.getParameter("inaugurationDay")));
		wk001Bean.setTurnoverDay(convertDate(request.getParameter("turnoverDay")));
		wk001Bean.setFee(request.getParameter("fee"));
		wk001Bean.setCompanyInfo(request.getParameter("companyInfo"));
		wk001Bean.setWorkContents(request.getParameter("workContents"));
	}
	public void setWk005BeanFromRequest(HttpServletRequest request, Wk005Bean wk005Bean) throws Exception{
		wk005Bean.setTradeId(convertNullInt(request.getParameter("tradeId")));
		wk005Bean.setForBusiness(request.getParameter("forBusiness"));
		wk005Bean.setAddress(request.getParameter("address"));
		wk005Bean.setRepresentative(request.getParameter("representative"));
		wk005Bean.setCharger(request.getParameter("charger"));
		wk005Bean.setRemarks(request.getParameter("remarks"));
	}
	/*public void setWk006BeanFromRequest(HttpServletRequest request, Wk006Bean wk006Bean) throws Exception{
		wk006Bean.setInfoId(convertNullInt(request.getParameter("infoId")));
		wk006Bean.setTradeId(convertNullInt(request.getParameter("tradeId")));
		wk006Bean.setReceptionDay(convertDate(request.getParameter("receptionDay")));

		
	}*/
	//	---------------セレクタ関係-----------------------------
	/**
	 * linkage relation
	 * @param 
	 * @return
	 */
	public StringBuffer rebuiledLevel2Area(List<Mst002Bean> mst002List) {
		// replace level2Area
		StringBuffer sb = new StringBuffer();
		sb.append("<select id='level2Id' name='level2Id' onChange='level2_changed()'>");
		sb.append("<option value ='0'>選択</option>");
		Iterator it = mst002List.iterator();
		while (it.hasNext()) {
			Mst002Bean mst002Bean = (Mst002Bean) it.next();
				sb.append("<option value ='" + mst002Bean.getLevel2Id() + "'>"
						+ mst002Bean.getName() + "</option>");
		}
		sb.append("</select><br>");
		sb.append("<div id='level3Area'>");
		sb.append(rebuiledLevel3Area(new ArrayList<Mst003Bean>()));
		sb.append("</div>");
		return sb;
	}
	public StringBuffer rebuiledLevel3Area(List<Mst003Bean> mst003List) {
		// replace level2Area
		StringBuffer sb = new StringBuffer();
		sb.append("<select id='level3Id' name='level3Id'>");
		sb.append("<option value ='0'>選択</option>");
		Iterator it = mst003List.iterator();
		while (it.hasNext()) {
			Mst003Bean mst003Bean = (Mst003Bean) it.next();
				sb.append("<option value ='" + mst003Bean.getLevel3Id() + "'>"
						+ mst003Bean.getName() + "</option>");
		}
		sb.append("</select>");
		return sb;
	}
	
}
