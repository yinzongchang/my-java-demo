package org.example.test.sql2es;

import org.junit.Test;

/**
 * TestMysql2Es.java
 *
 * @author yinzongchang
 * 创建时间 2022/11/3
 * @since 1.0
 */
public class TestMysql2Es {

    @Test
    public void testSQL() {

        System.out.println(MySQL2ESType.typeMap);

        String path = "/Users/yinzongchang/IdeaProjects/java-demo2/java-demo/src/main/resources/inbound_order.sql";
        String s = new MySQL2ES().readFile(path);
        System.out.println(s);
    }

    @Test
    public void testInboundItem() {

        String path = "/Users/yinzongchang/IdeaProjects/java-demo2/java-demo/src/main/resources/inbound_order_item.sql";
        String s = new MySQL2ES().readFile(path);
        System.out.println(s);

    }

    @Test
    public void testOperationInboundOrder() {

        String path = "/Users/yinzongchang/IdeaProjects/java-demo2/java-demo/src/main/resources/operation_inbound_order.sql";
        String s = new MySQL2ES().readFile(path);
        System.out.println(s);
    }

    @Test
    public void testOperationInboundOrderItem() {

        String path = "/Users/yinzongchang/IdeaProjects/java-demo2/java-demo/src/main/resources/operation_inbound_order_item.sql";
        String s = new MySQL2ES().readFile(path);
        System.out.println(s);
    }


    @Test
    public void testOutboundSQL() {

        System.out.println(MySQL2ESType.typeMap);

        String path = "/Users/yinzongchang/IdeaProjects/java-demo2/java-demo/src/main/resources/outbound_order.sql";
        String s = new MySQL2ES().readFile(path);
        System.out.println(s);
    }

    @Test
    public void testOutboundItemSQL() {

        System.out.println(MySQL2ESType.typeMap);

        String path = "/Users/yinzongchang/IdeaProjects/java-demo2/java-demo/src/main/resources/outbound_order_item.sql";
        String s = new MySQL2ES().readFile(path);
        System.out.println(s);
    }

    @Test
    public void testOutboundOrderPackageSQL() {

        System.out.println(MySQL2ESType.typeMap);

        String path = "/Users/yinzongchang/IdeaProjects/java-demo2/java-demo/src/main/resources/outbound_order_package.sql";
        String s = new MySQL2ES().readFile(path);
        System.out.println(s);
    }

    @Test
    public void testOperationOutboundSQL() {

        System.out.println(MySQL2ESType.typeMap);

        String path = "/Users/yinzongchang/IdeaProjects/java-demo2/java-demo/src/main/resources/operation_outbound_order.sql";
        String s = new MySQL2ES().readFile(path);
        System.out.println(s);
    }

    @Test
    public void testOperationOutboundItemSQL() {

        System.out.println(MySQL2ESType.typeMap);

        String path = "/Users/yinzongchang/IdeaProjects/java-demo2/java-demo/src/main/resources/outbound_order_item.sql";
        String s = new MySQL2ES().readFile(path);
        System.out.println(s);
    }

    @Test
    public void testPurchaseSQL() {

        System.out.println(MySQL2ESType.typeMap);

        String path = "/Users/yinzongchang/IdeaProjects/java-demo2/java-demo/src/main/resources/purchase_complete_change_log.sql";
        String s = new MySQL2ES().readFile(path);
        System.out.println(s);
    }

}
