package com.example.myuser.remotejson3;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by chandra prakash on 13-05-2016.
 */

public class Survey {
    //variable
    private String surveyId;
    private String surveyName;
    private String surveyCategory;
    private String surveyBase;
    private String surveyStartdate;
    private String surveyEnddate;
    private String surveyActive;
    private String surveyAward;


    //generate ArrayList
    private ArrayList<QuetionBean> quetionBeanArrayList;

    public ArrayList<QuetionBean> getQuetionBeanArrayList() {
        return quetionBeanArrayList;
    }

    public void setQuetionBeanArrayList(ArrayList<QuetionBean> quetionBeanArrayList) {
        this.quetionBeanArrayList = quetionBeanArrayList;
    }
//Generet Getter And Setter


    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyCategory() {
        return surveyCategory;
    }

    public void setSurveyCategory(String surveyCategory) {
        this.surveyCategory = surveyCategory;
    }

    public String getSurveyBase() {
        return surveyBase;
    }

    public void setSurveyBase(String surveyBase) {
        this.surveyBase = surveyBase;
    }

    public String getSurveyStartdate() {
        return surveyStartdate;
    }

    public void setSurveyStartdate(String surveyStartdate) {
        this.surveyStartdate = surveyStartdate;
    }

    public String getSurveyEnddate() {
        return surveyEnddate;
    }

    public void setSurveyEnddate(String surveyEnddate) {
        this.surveyEnddate = surveyEnddate;
    }

    public String getSurveyActive() {
        return surveyActive;
    }

    public void setSurveyActive(String surveyActive) {
        this.surveyActive = surveyActive;
    }

    public String getSurveyAward() {
        return surveyAward;
    }

    public void setSurveyAward(String surveyAward) {
        this.surveyAward = surveyAward;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "surveyId='" + surveyId + '\'' +
                ", surveyName='" + surveyName + '\'' +
                ", surveyCategory='" + surveyCategory + '\'' +
                ", surveyBase='" + surveyBase + '\'' +
                ", surveyStartdate='" + surveyStartdate + '\'' +
                ", surveyEnddate='" + surveyEnddate + '\'' +
                ", surveyActive='" + surveyActive + '\'' +
                ", surveyAward='" + surveyAward + '\'' +
                ", quetionBeanArrayList=" + quetionBeanArrayList +
                '}';
    }
}