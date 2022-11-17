package org.example.test.sql2es;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;

/**
 * TestES.java
 *
 * @author yinzongchang
 * 创建时间 2022/11/2
 * @since 1.0
 */
public class TestES {


    static String s = "{\n" +
            "  \"test\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"general_order_v2\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"my_es\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"confirm_revenue_message\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"prime_order_info\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"inbound_order_20200509\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"codis-proxy-2022.10.29\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"upp_user_coupon\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { },\n" +
            "      \"upp_user_coupon_alias\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"kingdee_revenue_check_record\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".monitoring-es-6-2022.10.31\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"activity_shop_sku_snapshot_data\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"stock_out\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".monitoring-es-6-2022.10.30\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"order_item_arrival_price\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"trade_after_sale_order_item_cargo\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"order_item_arrival\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"rt_confirm_income_store_month_report_detail\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"codis-proxy-2022.10.27\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"gift_card_account_flow\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"camp_group_statistics\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"operation_outbound_order20200219\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { },\n" +
            "      \"operation_outbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"trade_after_sale_order_item\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"channel_virtual_order\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"keep_bg_user\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"receipt_address\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { },\n" +
            "      \"receipt_address_alias\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"settlement_finance_biz_message\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"general_order_v9\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"general_order\" : { },\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"calory_coin_account_flow_v2\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"calory_coin_account_flow\" : { },\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"entries_channel_v20180711\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"keepland_monthly_detail\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".monitoring-kibana-6-2022.10.27\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"member_settlement_item\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".monitoring-es-6-2022.11.01\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"camp_personal_chat\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"keep_growth_worth\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"logisticsorder_mapping_0806\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { },\n" +
            "      \"logistics_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"stockcenter_stock_change_log\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"member_settlement_total\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"keep_course_ugc_draft_plan\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"allocate_order\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"allocate_order_alias\" : { },\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"keep_event_monthly_detail\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".monitoring-es-6-2022.10.29\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"log-audit-2022-02-23\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"keepland_package_monthly_detail\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"trade_order_item_logistics\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"red_packet_activity_account_flow\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"keep_bg_rdc_plan\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"after_sale_order\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"training_record\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"order_item_v3\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { },\n" +
            "      \"order_item\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"keep_growth_worth_fault\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"keep_growth_worth_restore\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"entries_channel_v201807111\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".monitoring-kibana-6-2022.10.28\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"confirm_revenue_detail\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"revenue_stock_check_record\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"total_monthly_statement\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".monitoring-kibana-6-2022.11.01\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".monitoring-es-6-2022.10.27\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"trade_polaris_diff_detail_result\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"confirm_income_store_month_diff_report_detail\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"operation_inbound_order_20210519\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"channel_douyin_bill_detail\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"confirm_income_store_month_report_detail\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"camp_group_chat\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"stock_snapshot_data\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"payaccount_red_packet_account_v1\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { },\n" +
            "      \"payaccount_red_packet_account\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"codis-proxy-2022.10.30\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"codis-proxy-2022.10.01\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"keep_pay_refund_flow\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"operation_inbound_order_20200509\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"operation_inbound_order_2020021218\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { },\n" +
            "      \"operation_inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".kibana_1\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \".kibana\" : { },\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"log-audit-1\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"stockcenter_activity_shop_sku\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".monitoring-kibana-6-2022.10.31\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"stock_snapshot_data_20211202\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { },\n" +
            "      \"stock_snapshot_data_v1\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"codis-proxy-2022.10.31\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"polaris_outbound_order_item\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"shop_sku_day_sale_quantity\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"keep_growth_worth_comment\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"after_sale_order_v2\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".monitoring-kibana-6-2022.10.29\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \".monitoring-kibana-6-2022.10.26\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  },\n" +
            "  \"mo_rpt_challenge_run_daily\" : {\n" +
            "    \"aliases\" : {\n" +
            "      \"inbound_order\" : { }\n" +
            "    }\n" +
            "  }\n" +
            "}";


    @Test
    public void test() {

        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject.keySet());

        jsonObject.keySet().forEach(key -> {

            String str = "{\n" +
                    "            \"remove\": {\n" +
                    "            \"index\":\"stockcenter_stock_occupation\",\n" +
                    "                    \"alias\": \"inbound_order\"\n" +
                    "            }\n" +
                    "        }";

            String s1 = "        {\n" +
                    "            \"remove\": {\n" +
                    "            \"index\":\"";
            String s2 = "\",\n" +
                    "                    \"alias\": \"inbound_order\"\n" +
                    "            }\n" +
                    "        },";

            System.out.println(s1 + key + s2);

        });






    }



}
