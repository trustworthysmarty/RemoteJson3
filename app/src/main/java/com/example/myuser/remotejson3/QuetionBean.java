package com.example.myuser.remotejson3;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by chandra prakash on 13-05-2016.
 */
public class QuetionBean {

    private String questionsId;
    private String questionOrder;
    private String questionsQuestion;
    private String questionResponses;
    private String questionBase;
    private String questionResponsetype;
    private String questionRandomize;
    private String questionOther;
    private String questionNone;
    private String questionNotsure;
    private String questionDecline;

    private ArrayList<ResponseBean>responseBeanslist;

    public ArrayList<ResponseBean> getResponseBeanslist() {
        return responseBeanslist;
    }

    public void setResponseBeanslist(ArrayList<ResponseBean> responseBeanslist) {
        this.responseBeanslist = responseBeanslist;
    }
    //set Getter And Setter


    public String getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(String questionsId) {
        this.questionsId = questionsId;
    }

    public String getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(String questionOrder) {
        this.questionOrder = questionOrder;
    }

    public String getQuestionsQuestion() {
        return questionsQuestion;
    }

    public void setQuestionsQuestion(String questionsQuestion) {
        this.questionsQuestion = questionsQuestion;
    }

    public String getQuestionResponses() {
        return questionResponses;
    }

    public void setQuestionResponses(String questionResponses) {
        this.questionResponses = questionResponses;
    }

    public String getQuestionBase() {
        return questionBase;
    }

    public void setQuestionBase(String questionBase) {
        this.questionBase = questionBase;
    }

    public String getQuestionResponsetype() {
        return questionResponsetype;
    }

    public void setQuestionResponsetype(String questionResponsetype) {
        this.questionResponsetype = questionResponsetype;
    }

    public String getQuestionRandomize() {
        return questionRandomize;
    }

    public void setQuestionRandomize(String questionRandomize) {
        this.questionRandomize = questionRandomize;
    }

    public String getQuestionOther() {
        return questionOther;
    }

    public void setQuestionOther(String questionOther) {
        this.questionOther = questionOther;
    }

    public String getQuestionNone() {
        return questionNone;
    }

    public void setQuestionNone(String questionNone) {
        this.questionNone = questionNone;
    }

    public String getQuestionNotsure() {
        return questionNotsure;
    }

    public void setQuestionNotsure(String questionNotsure) {
        this.questionNotsure = questionNotsure;
    }

    public String getQuestionDecline() {
        return questionDecline;
    }

    public void setQuestionDecline(String questionDecline) {
        this.questionDecline = questionDecline;
    }

    @Override
    public String toString() {
        return "QuetionBean{" +
                "questionsId='" + questionsId + '\'' +
                ", questionOrder='" + questionOrder + '\'' +
                ", questionsQuestion='" + questionsQuestion + '\'' +
                ", questionResponses='" + questionResponses + '\'' +
                ", questionBase='" + questionBase + '\'' +
                ", questionResponsetype='" + questionResponsetype + '\'' +
                ", questionRandomize='" + questionRandomize + '\'' +
                ", questionOther='" + questionOther + '\'' +
                ", questionNone='" + questionNone + '\'' +
                ", questionNotsure='" + questionNotsure + '\'' +
                ", questionDecline='" + questionDecline + '\'' +
                ", responseBeanslist=" + responseBeanslist +
                '}';
    }
}