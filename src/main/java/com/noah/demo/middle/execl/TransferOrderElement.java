package com.noah.demo.middle.execl;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * TransferOrderElement.java
 *
 * @author yinzongchang
 * 创建时间 2022/10/17
 * @since 1.0
 */
@Data
public class TransferOrderElement implements Serializable {


    /**
     * 调出仓库
     */
    @NotBlank(message = "调出仓库不能为空")
    @ExcelProperty("调出仓库 *")
    private String fromWarehouseName;

    /**
     * 调入仓库
     */
    @NotBlank(message = "调入仓库不能为空")
    @ExcelProperty("调入仓库 *")
    private String toWarehouseName;

    /**
     * 调出库存类型
     */
    @NotBlank(message = "调出库存类型不能为空")
    @ExcelProperty("调出库存类型 *")
    private String fromStockTypeName;

    /**
     * 调入库存类型
     */
    @NotBlank(message = "调入库存类型不能为空")
    @ExcelProperty("调入库存类型 *")
    private String toStockTypeName;

    /**
     * skuCode
     */
    @NotNull(message = "skuCode不能为空")
    @Min(value = 1, message = "skuCode格式不正确")
    @ExcelProperty("skuCode *")
    private Long skuCode;

    /**
     * 调拨数量
     */
    @NotNull(message = "调拨数量不能为空")
    @Min(value = 1, message = "调拨数量需为正整数")
    @ExcelProperty("调拨数量\n(正整数) *")
    private Integer quantity;

    /**
     * 出库物流单号
     */
    @ExcelProperty("出库物流单号\n(调出仓为Keep仓时必填，多个半角逗号分隔)")
    private String outLogisticsNos;

    /**
     * 备注
     */
    @ExcelProperty("备注")
    private String remark;

    /**
     * 调拨业务类型
     *
     */
    @NotNull(message = "业务类型不能为空")
    @ExcelProperty("业务类型 *")
    private String businessType;

    /**
     * 上游业务单号
     * 允许为空
     */
    @ExcelProperty("业务单据号")
    private String businessCode;


    /**
     * 收件人姓名
     */
    @ExcelProperty("收货人")
    private String receiver;

    /**
     * 收件人移动电话
     */
    @ExcelProperty("收货人电话")
    private String receiverPhone;

    /**
     * 收件人所在省
     */
    @ExcelProperty("收货人省")
    private String receiverProvince;

    /**
     * 收件人所在城市
     */
    @ExcelProperty("收货人市")
    private String receiverCity;

    /**
     * 收件人所在县区
     */
    @ExcelProperty("收货人区/县")
    private String receiverDistrict;

    /**
     * receiverShippingAddress
     */
    @ExcelProperty("收货人地址")
    private String receiverDetailAddress;


}
