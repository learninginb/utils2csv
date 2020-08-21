package com.boe.analysis.utils2csv.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.io.Serializable;

@Data
public class GantCsvDO implements Serializable {
//"序号",名称,开始日期,结束日期,持续,完成,成本,协调者,前置任务,
// 大纲编号,资源,Assignments,新任务,网页连接,备注,PM
//1,智能会议管理系统2.0,19-1-1,20-12-30,522,0,0.0,,,1,
// 王晓红;杜洪军;刘炜;闫新全;邵振军,2:100.00;8:100.00;14:100.00;9:100.00;11:100.00,,,,
    //number,name,startDate,endDate,dayNumber,finishion,cost,coordinator,predecessor,Outline,resources,Assignments,newTask,WebLink,notes,PM
        @CsvBindByName(column = "number")
        private String number;
        @CsvBindByName(column = "name")
        private String name;
        @CsvBindByName(column = "startDate")
        private String startDate;
        @CsvBindByName(column = "endDate")
        private String endDate;
        @CsvBindByName(column = "dayNumber")
        private   String dayNumber;
        @CsvBindByName(column = "finishion" )
        private String finishion;
        @CsvBindByName(column = "cost")
        private   String cost;
        @CsvBindByName(column = "coordinator")
        private   String coordinator;
    @CsvBindByName(column = "predecessor")
    private   String predecessor;
    @CsvBindByName(column = "Outline")
    private   String Outline;
    @CsvBindByName(column = "resources")
    private   String resources;
    @CsvBindByName(column = "Assignments")
    private   String Assignments;
    @CsvBindByName(column = "newTask")
    private   String newTask;
    @CsvBindByName(column = "WebLink")
    private   String WebLink;
    @CsvBindByName(column = "notes")
    private   String notes;
    @CsvBindByName(column = "PM")
    private   String PM;

    @Override
    public String toString(){
        return number+","+
                name+","+
                startDate+","+
                endDate+","+
                dayNumber+","+
                finishion+","+
                cost+","+
                coordinator+","+
                predecessor+","+
                Outline+","+
                resources+","+
                Assignments+","+
                newTask+","+
                WebLink+","+
                notes+","+
                PM;
        //number,name,startDate,endDate,dayNumber,finishion,cost,coordinator,predecessor,
        // Outline,resources,Assignments,newTask,WebLink,notes,PM

    }

}
