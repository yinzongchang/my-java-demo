package com.noah.demo.middle.execl;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
public class OutboundOrderImportElement implements Serializable {

    @ExcelProperty("出库单类型*")
    private String businessType;

    @ExcelProperty("仓库名称*")
    private String warehouseName;

    @ExcelProperty("skuCode*")
    private Long skuCode;

    @ExcelProperty("商品类型*")
    private String stockType;

    @ExcelProperty("出库数量*")
    private Integer number;

    /**
     * 采购单号
     */
    @ExcelProperty("采购单号")
    private String purchaseOrderNo;

    /**
     * 运单号
     */
    @ExcelProperty("发货单号")
    private String logisticsOrderNo;

    /**
     * 服务单号
     */
    @ExcelProperty("服务单号")
    private String serviceOrderNo;

    /**
     * 审批单号
     */
    @ExcelProperty("审批单号")
    private String approvalOrderNo;

    /**
     * 返厂单号
     */
    @ExcelProperty("返厂单号")
    private String refurbishOrderNo;

    /**
     * 调拨单号
     */
    @ExcelProperty("调拨单号")
    private String transferOrderNo;

    /***
     * 快递 公司
     */
    @ExcelProperty("快递公司")
    private String logisticsCompany;

    /**
     * 物流单号
     */
    @ExcelProperty("运单号")
    private String outLogisticsNo;

    /**
     * 发货人
     */
    @ExcelProperty("收货人*")
    private String receiverName;

    /**
     * 发货人手机号
     */
    @ExcelProperty("收货人电话*")
    private String receiverMobileNumber;

    /**
     * 发货人省
     */
    @ExcelProperty("收货人省*")
    private String receiverProvince;

    /**
     * 发货人市
     */
    @ExcelProperty("收货人市*")
    private String receiverCity;

    /**
     * 发货人地区
     */
    @ExcelProperty("收货人区/县*")
    @NotBlank(message = "收货人地区不能为空")
    private String receiverDistrict;


    /**
     * 发货人地址
     */
    @ExcelProperty("收货人地址*")
    @NotBlank(message = "收货人地址不能为空")
    private String receiverShippingAddress;

    @ExcelProperty("备注")
    private String description;

    /**
     * 后续补充字段
     */
    @ExcelIgnore
    private String skuName;
    @ExcelIgnore
    private String warehouseCode;
    @ExcelIgnore
    private String warehouseProviderCode;

    /**
     * 效期标志
     */
    @ExcelProperty("是否效期商品*")
    private String batchValue;

    /**
     * 期望完成时间
     */
    @ExcelProperty("期望出库效期（当是效期商品时，必填）")
    private Date expectProductionDate;

}
