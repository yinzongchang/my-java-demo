package com.noah.demo.middle.execl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TestExcel {


    public static void main(String[] args) {


        String filePath = "/Users/yinzongchang/Downloads/出库单导入模版.xlsx";
        List<OutboundOrderImportElement> elements = EasyExcel.read(filePath)
                .excelType(ExcelTypeEnum.XLSX)
                .head(OutboundOrderImportElement.class)
                .sheet()
                .doReadSync();

        System.out.println(JSONObject.toJSONString(elements));

//        // 新建一个ExcelReaderBuilder实例
//        ExcelReaderBuilder readerBuilder = EasyExcel.read();
//        // 读取的文件对象，可以是File、路径（字符串）或者InputStream实例
//        readerBuilder.file("");
//        // 文件的密码
//        readerBuilder.password("");
//        // 指定sheet，可以是数字序号sheetNo或者字符串sheetName，若不指定则会读取所有的sheet
//        readerBuilder.sheet("");
//        // 是否自动关闭输入流
//        readerBuilder.autoCloseStream(true);
//        // Excel文件格式，包括ExcelTypeEnum.XLSX和ExcelTypeEnum.XLS
//        readerBuilder.excelType(ExcelTypeEnum.XLSX);
//        // 指定文件的标题行，可以是Class对象（结合@ExcelProperty注解使用），或者List<List<String>>实例
//        readerBuilder.head(Collections.singletonList(Collections.singletonList("head")));
//        // 注册读取事件的监听器，默认的数据类型为Map<Integer,String>，第一列的元素的下标从0开始
//        readerBuilder.registerReadListener(new AnalysisEventListener() {
//
//            @Override
//            public void invokeHeadMap(Map headMap, AnalysisContext context) {
//                // 这里会回调标题行，文件内容的首行会认为是标题行
//            }
//
//            @Override
//            public void invoke(Object o, AnalysisContext analysisContext) {
//                // 这里会回调每行的数据
//            }
//
//            @Override
//            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//
//            }
//        });
//        // 构建读取器
//        ExcelReader excelReader = readerBuilder.build();
//        // 读取数据
//        excelReader.readAll();
//        excelReader.finish();
    }


    @Test
    public void test2() {

        String filePath = "/Users/yinzongchang/Downloads/调拨导入模版 (1).xlsx";
        List<OutboundOrderImportElement> elements = EasyExcel.read(filePath)
                .excelType(ExcelTypeEnum.XLSX)
                .head(TransferOrderElement.class)
                .sheet()
                .doReadSync();

        System.out.println(JSONObject.toJSONString(elements));

    }


}
