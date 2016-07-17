package org.krisbox.jsf4birt;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.actuate.aces.idapi.ReportParameterProvider;
import com.actuate.aces.idapi.control.ActuateException;
import com.actuate.schemas.ArrayOfNameValuePair;
import com.actuate.schemas.ArrayOfRecord;
import com.actuate.schemas.ArrayOfString;
import com.actuate.schemas.DataSourceType;
import com.actuate.schemas.DataType;
import com.actuate.schemas.ParameterDefinition;
import com.actuate.schemas.ParameterDefinitionControlType;

@ManagedBean
@SessionScoped
public class BirtBean {
	private final long serialVersionUID = 20140730L;
	private String total = "0";
	final Logger PARENT_LOGGER = Logger.getLogger(BirtBean.class);
	
	private String  reportdesign = "";
	private Parameters[] parameters;
	private Properties properties = new Properties();
	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	
	@PostConstruct
	public void init() {
		try {
			properties.load(ec.getResourceAsStream("/resources/ihub.properties"));
		} catch (IOException ex) {
			PARENT_LOGGER.error(ex);
		}
	}
	
	public void setReportdesign(String reportdesign) {
		parameters = new IdapiComm().getReportParameters(reportdesign);
		Map<String, Object> test = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		for(String s : test.keySet())
		{
		  PARENT_LOGGER.debug("!!!!!" + s);
		}
		this.reportdesign = reportdesign;
	}
	
	public String getReportdesign() {
		return reportdesign;
	}
	
	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getTotal() {
		return total;
	}
	
	public Parameters[] getParameters() {
		return parameters;
	}
	
	public void setParameters() {
		
	}
	
	public class Parameters {
		final Logger CHILD_LOGGER = Logger.getLogger(Parameters.class);
		String name;
		String displayName;
		DataType columnType;
		String defaultValue;
		ArrayOfRecord defaultTableValues;
		ParameterDefinitionControlType controlType;
		String cascadingParentName;
		int autoSuggestThreshold;
		DataSourceType dataSourceType;
		DataType dataType;
		String group;
		String groupPromptText;
		String promptText;
		String helpText;
		ArrayOfNameValuePair selectNameValueList;
		ArrayOfString        selectValueList;
		boolean defaultValueIsNull;
		boolean startExpanded;
		boolean isAdHoc;
		boolean isDynamicSelectionList;
		boolean isHidden;
		boolean isPassword;
		boolean isRequired;
		boolean isViewParameter;
		boolean valueIsNull;
		
		public Parameters(String name, String displayName, DataType columnType,
						  String defaultValue, ArrayOfRecord defaultTableValues, ParameterDefinitionControlType controlType,
						  String cascadingParentName, int autoSuggestThreshold, DataSourceType dataSourceType,
						  DataType dataType, String group, String promptText,
						  String helpText, ArrayOfNameValuePair selectNameValueList, ArrayOfString selectValueList,
						  boolean defaultValueIsNull, boolean startExpanded, boolean isAdHoc,
						  boolean isDynamicSelectionList, boolean isHidden, boolean isPassword,
						  boolean isRequired, boolean isViewParameter) {
			this.name 					= name;
			this.displayName 			= displayName;
			this.columnType 			= columnType;
			this.defaultValue 			= defaultValue;
			this.defaultTableValues 	= defaultTableValues;
			this.controlType 			= controlType;
			this.cascadingParentName 	= cascadingParentName;
			this.autoSuggestThreshold 	= autoSuggestThreshold;
			this.dataSourceType 		= dataSourceType;
			this.dataType 				= dataType;
			this.group 					= group;
			this.promptText 			= promptText;
			this.helpText 				= helpText;
			this.selectNameValueList 	= selectNameValueList;
			this.selectValueList 		= selectValueList;
			this.defaultValueIsNull 	= defaultValueIsNull;
			this.startExpanded 			= startExpanded;
			this.isAdHoc 				= isAdHoc;
			this.isDynamicSelectionList = isDynamicSelectionList;
			this.isHidden 				= isHidden;
			this.isPassword 			= isPassword;
			this.isRequired 			= isRequired;
			this.isViewParameter 		= isViewParameter;
			
		}
		
		public Parameters() {
			
		}
		
		// TODO: Finish implementing these
		public void setName(String name){this.name=name;}
		public void setDisplayName(String displayName){this.displayName=displayName;}
		public void setColumnType(DataType columnType){this.columnType=columnType;}
		public void setDefaultValue(String defaultValue){this.defaultValue=defaultValue;}
		public void setDefaultTableValues(ArrayOfRecord defaultTableValues){this.defaultTableValues=defaultTableValues;}
		public void setControlType(ParameterDefinitionControlType controlType){this.controlType=controlType;}
		public void setCascadingParentName(String cascadingParentName){this.cascadingParentName=cascadingParentName;}
		public void setAutoSuggestThreshold(int autoSuggestThreshold){this.autoSuggestThreshold=autoSuggestThreshold;}
		public void setDataSourceType(DataSourceType dataSourceType){this.dataSourceType=dataSourceType;}
		public void setDataType(DataType dataType){this.dataType=dataType;}
		public void setGroup(String group){this.group=group;}
		public void setPromptText(String promptText){this.promptText=promptText;}
		public void setHelpText(String helpText){this.helpText=helpText;}
		public void setSelectNameValueList(ArrayOfNameValuePair selectNameValueList){this.selectNameValueList=selectNameValueList;}
		public void setSelectValueList(ArrayOfString selectValueList){this.selectValueList=selectValueList;}
		public void setDefaultValueIsNull(boolean defaultValueIsNull){this.defaultValueIsNull=defaultValueIsNull;}
		public void setStartExpanded(boolean startExpanded){this.startExpanded=startExpanded;}
		public void setIsAdHoc(boolean isAdHoc){this.isAdHoc=isAdHoc;}
		public void setIsDynamicSelectionList(boolean isDynamicSelectionList){this.isDynamicSelectionList=isDynamicSelectionList;}
		public void setIsHidden(boolean isHidden){this.isHidden=isHidden;}
		public void setIsPassword(boolean isPassword){this.isPassword=isPassword;}
		public void setIsRequired(boolean isRequired){this.isRequired=isRequired;}
		public void setIsViewParameter(boolean isViewParameter){this.isViewParameter=isViewParameter;}
		
		public String getName(){return name;}
		public String getDisplayName(){return displayName;}
		public /*DataType*/String getColumnType(){return "";}
		public String getDefaultValue(){return defaultValue;}
		public /*ArrayOfRecord*/String getDefaultTableValues(){return "";}
		public /*ParameterDefinitionControlType*/String getControlType(){return "";}
		public String getCascadingParentName(){return cascadingParentName;}
		public int getAutoSuggestThreshold(){return autoSuggestThreshold;}
		public /*DataSourceType*/String getDataSourceType(){return "";}
		public /*DataType*/String getDataType(){return "";}
		public String getGroup(){return group;}
		//public String getPromptText(){return promptText;}
		public String getHelpText(){return helpText;}
		public /*ArrayOfNameValuePair*/String getSelectNameValueList(){return "";}//selectNameValueList;}
		public /*ArrayOfString*/String getSelectValueList(){return "";}//selectValueList;}
		public String getGroupPromptText(){/*return groupPromptText;*/return "";}
		public boolean getDefaultValueIsNull(){return valueIsNull;}
		public boolean getStartExpanded(){return startExpanded;}
		public boolean getIsAdHoc(){return isAdHoc;}
		public boolean getIsDynamicSelectionList(){return isDynamicSelectionList;}
		public boolean getIsHidden(){return isHidden;}
		public boolean getIsPassword(){return isPassword;}
		public boolean getIsRequired(){return isRequired;}
		public boolean getIsViewParameter(){return isViewParameter;}
	}

	public class IdapiComm {
		final Logger COMM_LOGGER = Logger.getLogger(IdapiComm.class);
		
		public Parameters[] getReportParameters(String reportName) {
			ReportParameterProvider connector	  = null;
			ArrayList<ParameterDefinition> params = null;
			
			try {
				connector = new ReportParameterProvider(properties.getProperty("ihub"),
														properties.getProperty("username"), 
														properties.getProperty("password"),
														properties.getProperty("volume"));
				
				// TODO : Change the above to use authid from the session variables
				
				params = connector.getParameters(reportName);
			} catch (MalformedURLException ex) {
				COMM_LOGGER.error(ex);
			} catch (ServiceException ex) {
				COMM_LOGGER.error(ex);
			} catch (ActuateException ex) {
				COMM_LOGGER.error(ex);
			}
			
			Parameters[] allParameters = new Parameters[params.size()];
			
			try {
				int counter = 0;
				for (ParameterDefinition param : params) {
					Parameters oneParameter = new Parameters();
					if(param.getAutoSuggestThreshold() == null) {
						COMM_LOGGER.error("Auto suggest threshold is null");
						oneParameter.setAutoSuggestThreshold(0);
						COMM_LOGGER.debug("Auto suggest threshold is now " + oneParameter.getAutoSuggestThreshold());
					}else{
						oneParameter.setAutoSuggestThreshold(param.getAutoSuggestThreshold());
						COMM_LOGGER.debug("Auto suggest threshold is " + oneParameter.getAutoSuggestThreshold());
					}
					
					if(param.getCascadingParentName() == null) {
						COMM_LOGGER.error("Cascading parent name is null");
						oneParameter.setCascadingParentName("");
						COMM_LOGGER.debug("Cascading parent name is now " + oneParameter.getCascadingParentName());
					}else{
						oneParameter.setCascadingParentName(param.getCascadingParentName());
						COMM_LOGGER.debug("Cascading parent name is " + oneParameter.getCascadingParentName());
					}
					
					if(param.getColumnType() == null) {
						// Do something
						COMM_LOGGER.error("Column type is null");
						COMM_LOGGER.debug("Column type is now " + oneParameter.getColumnType());
					}else{
						oneParameter.setColumnType(param.getColumnType());
						COMM_LOGGER.debug("Column type is " + oneParameter.getColumnType());
					}
					
					if(param.getControlType() == null) {
						// Do something
						COMM_LOGGER.error("Control type is null");
						COMM_LOGGER.debug("Control type is now " + oneParameter.getControlType());
					}else{
						oneParameter.setControlType(param.getControlType());
						COMM_LOGGER.debug("Control type is " + oneParameter.getControlType());
					}
					
					if(param.getDataSourceType() == null) {
						// Do something
						COMM_LOGGER.error("Data Source type is null");
						COMM_LOGGER.debug("Data Source type is now " + oneParameter.getDataSourceType());
					}else{
						oneParameter.setDataSourceType(param.getDataSourceType());
						COMM_LOGGER.debug("Data Source type is " + oneParameter.getDataSourceType());
					}
					
					if(param.getDataType() == null) {
						// Do something
						COMM_LOGGER.error("Data type threshold is null");
						COMM_LOGGER.debug("Data type is now " + oneParameter.getDataType());
					}else{
						oneParameter.setDataType(param.getDataType());
						COMM_LOGGER.debug("Data type is " + oneParameter.getDataType());
					}

					if(param.getDefaultTableValues() == null) {
						COMM_LOGGER.error("Default table values is null");
						oneParameter.setDefaultTableValues(new ArrayOfRecord());
						COMM_LOGGER.debug("Default table values is now " + oneParameter.getDefaultTableValues());
					}else{
						oneParameter.setDefaultTableValues(param.getDefaultTableValues());
						COMM_LOGGER.debug("Default table values is " + oneParameter.getDefaultTableValues());
					}

					if(param.getDefaultValue() == null) {
						COMM_LOGGER.error("Default value is null");
						oneParameter.setDefaultValue("");
						COMM_LOGGER.debug("Default value is now " + oneParameter.getDefaultValue());
					}else{
						oneParameter.setDefaultValue(param.getDefaultValue());
						COMM_LOGGER.debug("Default value is " + oneParameter.getDefaultValue());
					}

					if(param.getDefaultValueIsNull() == null) {
						COMM_LOGGER.error("Default value is null, is null");
						oneParameter.setDefaultValueIsNull(false);
						COMM_LOGGER.debug("Default value is null, is now " + oneParameter.getDefaultValueIsNull());
					}else{
						oneParameter.setDefaultValueIsNull(param.getDefaultValueIsNull());
						COMM_LOGGER.debug("Default value is null, is " + oneParameter.getDefaultValueIsNull());
					}

					if(param.getDisplayName() == null) {
						COMM_LOGGER.error("Display name is null");
						oneParameter.setDisplayName("");
						COMM_LOGGER.debug("Display name is now " + oneParameter.getDisplayName());
					}else{
						oneParameter.setDisplayName(param.getDisplayName());
						COMM_LOGGER.debug("Display name is " + oneParameter.getDisplayName());
					}
					
					if(param.getGroup() == null) {
						COMM_LOGGER.error("Group is null");
						oneParameter.setGroup("");
						COMM_LOGGER.debug("Group is now " + oneParameter.getGroup());
					}else{
						oneParameter.setGroup(param.getGroup());
						COMM_LOGGER.debug("Group is " + oneParameter.getGroup());
					}
					
					if(param.getHelpText() == null) {
						COMM_LOGGER.error("Help text is null");
						oneParameter.setHelpText("");
						COMM_LOGGER.debug("Help text is now " + oneParameter.getHelpText());
					}else{
						oneParameter.setHelpText(param.getHelpText());
						COMM_LOGGER.debug("Help text is " + oneParameter.getHelpText());
					}
					
					if(param.getIsAdHoc() == null) {
						COMM_LOGGER.error("Is AdHoc is null");
						oneParameter.setIsAdHoc(false);
						COMM_LOGGER.debug("Is AdHoc is now " + oneParameter.getIsAdHoc());
					}else{
						oneParameter.setIsAdHoc(param.getIsAdHoc());
						COMM_LOGGER.debug("Is AdHoc is " + oneParameter.getIsAdHoc());
					}
					
					if(param.getIsDynamicSelectionList() == null) {
						COMM_LOGGER.error("Is dynamic selection list is null");
						oneParameter.setIsDynamicSelectionList(false);
						COMM_LOGGER.debug("Is dynamic selection list is now " + oneParameter.getIsDynamicSelectionList());
					}else{
						oneParameter.setIsDynamicSelectionList(param.getIsDynamicSelectionList());
						COMM_LOGGER.debug("Is dynamic selection list is " + oneParameter.getIsDynamicSelectionList());
					}
					
					if(param.getIsHidden() == null) {
						COMM_LOGGER.error("Is hidden is null");
						oneParameter.setIsHidden(false);
						COMM_LOGGER.debug("Is hidden is now " + oneParameter.getIsHidden());
					}else{
						oneParameter.setIsHidden(param.getIsHidden());
						COMM_LOGGER.debug("Is hidden is " + oneParameter.getIsHidden());
					}
					
					if(param.getIsPassword() == null) {
						COMM_LOGGER.error("Is password is null");
						oneParameter.setIsPassword(false);
						COMM_LOGGER.debug("Is password is now " + oneParameter.getIsPassword());
					}else{
						oneParameter.setIsPassword(param.getIsPassword());
						COMM_LOGGER.debug("Is password is " + oneParameter.getIsPassword());
					}
					
					if(param.getIsRequired() == null) {
						COMM_LOGGER.error("Is required is null");
						oneParameter.setIsRequired(false);
						COMM_LOGGER.debug("Is required is now " + oneParameter.getIsRequired());
					}else{
						oneParameter.setIsRequired(param.getIsRequired());
						COMM_LOGGER.debug("Is required is " + oneParameter.getIsRequired());
					}
					
					if(param.getIsViewParameter() == null) {
						COMM_LOGGER.error("Is view parameter is null");
						oneParameter.setIsViewParameter(false);
						COMM_LOGGER.debug("Is view parameter is now " + oneParameter.getIsViewParameter());
					}else{
						oneParameter.setIsViewParameter(param.getIsViewParameter());
						COMM_LOGGER.debug("Is view parameter is " + oneParameter.getIsViewParameter());
					}
					
					if(param.getName() == null) {
						COMM_LOGGER.error("Start name is null");
						oneParameter.setName("");
						COMM_LOGGER.debug("Name is now " + oneParameter.getName());
					}else{
						oneParameter.setName(param.getName());
						COMM_LOGGER.debug("Name is " + oneParameter.getName());
					}
					
					if(param.getSelectNameValueList() == null) {
						COMM_LOGGER.error("Select name value list is null");
						oneParameter.setSelectNameValueList(new ArrayOfNameValuePair());
						COMM_LOGGER.debug("Select name value list is now " + oneParameter.getSelectNameValueList());
					}else{
						oneParameter.setSelectNameValueList(param.getSelectNameValueList());
						COMM_LOGGER.debug("Select name value list is " + oneParameter.getSelectNameValueList());
					}
					
					if(param.getSelectNameValueList() == null) {
						COMM_LOGGER.error("Select name value list is null");
						oneParameter.setSelectNameValueList(new ArrayOfNameValuePair());
						COMM_LOGGER.debug("Select name value list  now " + oneParameter.getStartExpanded());
					}else{
						oneParameter.setSelectValueList(param.getSelectValueList());
						COMM_LOGGER.debug("Select value list is " + oneParameter.getSelectValueList());
					}
					
					if(param.getStartExpanded() == null) {
						COMM_LOGGER.error("Start expanded is null");
						oneParameter.setStartExpanded(false);
						COMM_LOGGER.debug("Start expanded is now " + oneParameter.getStartExpanded());
					}else{
						param.setStartExpanded(param.getStartExpanded());
						COMM_LOGGER.debug("Start expanded is " + oneParameter.getStartExpanded());
					}
					allParameters[counter] = oneParameter;
					counter++;
				}
			}catch(Exception ex){
				COMM_LOGGER.error(ex);
			}
			total = Integer.toString(allParameters.length);
			return allParameters;
		}
	}
}
