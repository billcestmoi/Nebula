package com.ecvictor.testngNebula;


public class Control {

    public static void main(String[] args) throws Exception
    {
        tokensaleNebulaAiChineseTest chineseTest = new tokensaleNebulaAiChineseTest();
        chineseTest.setUp();
        chineseTest.testTokenSaleCN_wallet();
        chineseTest.testDown();
        chineseTest.setUp();
        chineseTest.testTokenSaleCN_TopBar();
        chineseTest.testDown();
//        chineseTest.setUp();
//        chineseTest.testTokenSaleCN_home();
//        chineseTest.testDown();
        chineseTest.setUp();
        chineseTest.rest();
        chineseTest.testDown();
        System.out.println("Test finish");
    }
}
