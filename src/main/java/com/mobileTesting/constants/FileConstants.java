package com.mobileTesting.constants;

import com.mobileTesting.utils.CommonUtils;

public class FileConstants {
    public static final String phoneData_FILE_PATH2 =  System.getProperty("user.dir") + "/src/main/resources/testData/nobile.properties";

    public static final String SCREENSHOT_PATH =  System.getProperty("user.dir") + "/src/main/resources/reports/"+ CommonUtils.getStringDateAndTimeStamp()+"_SFDC.PNG";
}

