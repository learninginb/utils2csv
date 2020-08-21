package com.boe.analysis.utils2csv.csv;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/c")
public class CsvController {
    @PostMapping("/csv")
    public String  batchInsert(MultipartFile file) {
        CsvUtil csvUtil = new CsvUtil();

        // 将csv文件内容转成bean
        List<GantCsvDO> csvData = csvUtil.getCsvData(file, GantCsvDO.class);
        HashSet<String> nameSet = new HashSet<>();
        HashMap<String,GantCsvDO> res = new HashMap<>();
        for (GantCsvDO csvDatum : csvData) {
            if (nameSet.add(csvDatum.getName())){
                res.put(csvDatum.getName(),csvDatum);
            }else {
                merge(res.get(csvDatum.getName()),csvDatum);
            }
        }
        for(GantCsvDO v:res.values())
        {
            System.out.println(v.toString());
        }
        //csvData.stream().forEach((c)-> System.out.println(c.getName()));

        return "yes";

    }

    private void merge(GantCsvDO gantCsvDO, GantCsvDO csvDatum) {

        List<String> list1 = Arrays.asList(gantCsvDO.getResources().split(";"));
        List<String> list2 = Arrays.asList(csvDatum.getResources().split(";"));
        List<String> listAll = new ArrayList<>();
        listAll.addAll(list1);
        listAll.addAll(list2);
        listAll = new ArrayList<String>(new LinkedHashSet<>(listAll));
        gantCsvDO.setResources(StringUtils.join(listAll.toArray(),";"));
    }

    @GetMapping("test")
    public String test(){
        return "1";
    }
}
